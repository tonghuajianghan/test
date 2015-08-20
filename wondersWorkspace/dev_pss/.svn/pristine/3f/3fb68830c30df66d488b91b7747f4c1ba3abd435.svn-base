package com.wondersgroup.pss.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.core.bean.Page;
import com.wondersgroup.core.exception.ServiceException;
import com.wondersgroup.core.util.CascadeUtil;
import com.wondersgroup.core.util.FormUtil;
import com.wondersgroup.pss.annotation.Modual;
import com.wondersgroup.pss.bean.SearchCondition;
import com.wondersgroup.pss.bo.MpUserProd;
import com.wondersgroup.pss.bo.PssUser;
import com.wondersgroup.pss.constant.BusinessConstants;
import com.wondersgroup.pss.service.QAService;
import com.wondersgroup.pss.service.UserService;
import com.wondersgroup.pss.util.BusinessUtil;

/**
 * 网站用户管理维护
 * 
 * @author chenjijun,lijinhao,zhoujian
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QAService qaService;

    /**
     * 转至用户列表页面
     * 
     * @param condition 查询条件
     * @param model
     * @return
     */
    @Modual(BusinessConstants.MODUAL_USER_MANA)
    @RequestMapping("/list")
    public String list(SearchCondition condition, Model model) {
        // 分页查询用户列表
        Page page = userService.findUserWithPage(condition);

        // 将分页查询结果返回页面
        model.addAttribute("page", page);
        // 将查询条件返回页面
        model.addAttribute("condition", condition);

        // 转至用户列表页面
        return "user/user_list";
    }

    /**
     * 删除用户
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public String del(String id) {
        try {
            // 删除用户
            userService.delete(id);
        } catch (Throwable t) {
            // 删除失败，返回失败信息
            return "用户删除失败！";
        }

        // 操作成功，返回空信息
        return "";
    }

    /**
     * 用户有效性设置
     * 
     * @param id
     * @param valid
     * @return
     */
    @ResponseBody
    @RequestMapping("/valid_ctrl")
    public String validity(String id, String valid) {
        try {
            // 设置用户有效性
            userService.valid(id, valid);
        } catch (Throwable t) {
            // 设置用户有效性失败，返回失败信息
            return "操作失败！";
        }

        // 操作成功，返回空信息
        return "";
    }

    /**
     * 用户密码重置
     * 
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/reset_pwd")
    public String resetPwd(String id) {
        try {
            // 重置用户密码
            userService.resetPwd(id);
        } catch (Throwable t) {
            // 重置用户密码失败，返回失败信息
            return "用户密码重置操作失败！";
        }

        // 操作成功，返回空信息
        return "";
    }

    /**
     * 弹出用户信息编辑窗口
     * 
     * @return
     */
    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        // 用户ID不为空，说明当前操作是编辑操作
        if (StringUtils.isNotBlank(id)) {
            // 获取已存在的用户对象
            PssUser user = userService.get(id, 0);
            // 将已存在的用户对象传至页面
            model.addAttribute("pssUser", user);
        }
        
        // 弹出用户信息编辑窗口
        return "user/pop_edit";
    }

    /**
     * 用户查重校验
     * 
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/verify_dup")
    public boolean verifyDup(String userName) {
        // 返回校验结果
        return userService.verifyDup(userName);
    }

    /**
     * 保存用户信息
     * 
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody
    PssUser user) {

        try {
            if (user == null) {
                throw new ServiceException("用户不存在！");
            }
            // 获取用户ID
            String id = user.getUserId();

            // 用户ID不为空，说明当前操作是编辑操作
            if (StringUtils.isNotBlank(id)) {
                // 当前已存在的用户对象
                PssUser existedUser = userService.get(id, 0);

                // 将页面内容更新至用户对象
                FormUtil.copyProperties(existedUser, user);

                // 将页面内容更新至用户产品关联集合
                if (existedUser.getMpUserProdSet() == null) {
                    Set<MpUserProd> mpUserProdSet = new LinkedHashSet<MpUserProd>();
                    mpUserProdSet.addAll(user.getMpUserProdSet());
                    existedUser.setMpUserProdSet(mpUserProdSet);
                } else {
                    FormUtil.updateSet(existedUser.getMpUserProdSet(), user.getMpUserProdSet());
                }
                // 级联设置用户对象主键
                CascadeUtil.setRefProperty(user, id, "userId");
                // 更新已有用户信息
                userService.update(existedUser);
            } else {
                // 级联设置用户对象主键
                CascadeUtil.setRefProperty(user, BusinessUtil.randomUUID(), "userId");
                // 保存新增用户信息
                userService.update(user);
            }
        } catch (Throwable t) {
            t.printStackTrace();
            // 用户信息保存失败，返回失败信息
            return "用户信息保存失败！";
        }

        // 保存成功，返回空信息
        return "";
    }

    /**
     * 批量更新选中的用户的有效性
     * 
     * @param ids
     * @param valid
     * @return
     */
    @ResponseBody
    @RequestMapping("/batch/valid")
    public String batchValid(@RequestBody
    List<String> ids, String valid) {
        try {
            // 批量设置用户有效性
            userService.batchValid(ids, valid);
        } catch (Throwable t) {
            // 设置用户有效性失败，返回失败信息
            return "操作失败！";
        }
        return "";
    }

    /**
     * 批量删除用户
     * 
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batch/delete")
    public String batchDelete(@RequestBody
    List<String> ids) {
        try {
            // 批量删除用户
            for (String id : ids) {
                userService.delete(id);
            }
        } catch (Throwable t) {
            // 批量删除失败，返回失败信息
            return "用户删除失败！";
        }

        // 操作成功，返回空信息
        return "";
    }

    /**
     * 批量重置密码
     * 
     * @param ids 批量选中的用户id
     * @return
     */
    @ResponseBody
    @RequestMapping("/batch/reset_pwd")
    public String batchResetPWD(@RequestBody
    List<String> ids) {
        System.out.println("ids: " + ids);
        try {
            // 批量重置用户密码
            for (String id : ids) {
                userService.resetPwd(id);
            }
        } catch (Throwable t) {
            // 重置用户密码失败，返回失败信息
            return "用户密码批量重置操作失败！";
        }

        // 操作成功，返回空信息
        return "";
    }
}