package com.wondersgroup.pss.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.core.annotation.Outer;
import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.exception.ServiceException;
import com.wondersgroup.core.util.FormUtil;
import com.wondersgroup.pss.annotation.Modual;
import com.wondersgroup.pss.bean.UserInfo;
import com.wondersgroup.pss.bo.PssUser;
import com.wondersgroup.pss.constant.BusinessConstants;
import com.wondersgroup.pss.service.PassportService;
import com.wondersgroup.pss.service.UserService;

/**
 * 个人账户管理
 * 
 * @author SHI
 */
@Controller
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private PassportService passportService;

    @Autowired
    private UserService userService;

    /**
     * 注销登录
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        // 清除session中的用户数据
        Enumeration<?> enu = session.getAttributeNames();
        while (enu.hasMoreElements()) {
            session.removeAttribute((String) enu.nextElement());
        }

        return "redirect:/passport/login";
    }

    /**
     * 转至登录页面
     * 
     * @return
     */
    @Outer
    @RequestMapping("/login")
    public String login() {
        return "passport/login";
    }

    /**
     * 验证用户登录
     * 
     * @param userName
     * @param userPwd
     * @return
     */
    @Outer
    @ResponseBody
    @RequestMapping("/login_verify")
    public String verify(String userName, String userPwd) {
        // 返回用户登录验证信息
        return passportService.verify(userName, userPwd);
    }

    /**
     * 转至个人中心页面
     * 
     * @param session
     * @param model
     * @return
     */
    @Modual(BusinessConstants.MODUAL_P_CENTER)
    @RequestMapping("/center")
    public String center(HttpSession session, Model model) {
        // 获取会话中保存的用户信息
        UserInfo user = (UserInfo) session.getAttribute(GlobalConstants.SESSION_USER);
        // 根据ID获取用户对象
        PssUser pssUser = userService.get(user.getUserId());
        // 将用户对象转至页面
        model.addAttribute("pssUser", pssUser);
        // 转至个人中心页面
        return "passport/center";
    }

    /**
     * 更新个人资料
     * 
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/profile_update")
    public String update(@RequestBody
    PssUser user, HttpSession session) {
        try {
            // 判断用户是否存在
            if (user == null) {
                throw new ServiceException("用户不存在！");
            }

            // 获取用户ID
            String id = user.getUserId();

            // 判断用户ID是否为空
            if (StringUtils.isBlank(id)) {
                throw new ServiceException("用户ID为空！");
            }

            // 当前已存在的用户对象
            PssUser existedUser = userService.get(id);

            // 如果当前操作为修改密码，则判断旧密码与当前密码是否一致
            if (StringUtils.isNotBlank(user.getPrevPwd()) && !StringUtils.equals(user.getPrevPwd(), existedUser.getUserPwd())) {
                return "用户旧密码不正确！";
            }

            // 将页面内容更新至用户对象
            FormUtil.copyProperties(existedUser, user);

            // 更新已有用户信息
            userService.update(existedUser);

            // 更新会话中的用户信息
            session.setAttribute(GlobalConstants.SESSION_USER, new UserInfo(existedUser));
        } catch (Throwable t) {
            // 用户信息保存失败，返回失败信息
            return "用户信息保存失败！";
        }

        // 保存成功，返回空信息
        return "";
    }
}
