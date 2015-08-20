package com.wondersgroup.pss.service;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.util.ext.WebContext;
import com.wondersgroup.pss.bean.UserInfo;
import com.wondersgroup.pss.bo.PssUser;
import com.wondersgroup.pss.dao.UserDAO;

/**
 * 个人账户管理
 * 
 * @author machanggnag,mazhuowen
 */
@Transactional
@Service
public class PassportService {

    @Autowired
    private UserDAO userDAO;

    /**
     * 根据用户名及密码校验用户登录
     * 
     * @param userName
     * @param userPwd
     * @return 登录失败，返回失败信息；登录成功，将用户对象保存至会话，返回空消息
     */
    public String verify(String userName, String userPwd) {
        // 根据用户名获取用户对象
        PssUser user = userDAO.getByName(userName);

        // 校验登录信息，返回校验信息
        if (user == null) {
            return "用户名不存在！";
        } else if (!StringUtils.equals(user.getUserPwd(), userPwd)) {
            return "用户密码错误！";
        }

        // 登录成功，则将用户对象保存至会话
        HttpSession session = WebContext.getSession();
        session.setAttribute(GlobalConstants.SESSION_USER, new UserInfo(user));

        // 登录成功，返回空消息
        return "";
    }
}
