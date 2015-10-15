package com.wondersgroup.pss.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.core.bean.Page;
import com.wondersgroup.core.exception.ServiceException;
import com.wondersgroup.core.util.CascadeUtil;
import com.wondersgroup.core.util.MD5Util;
import com.wondersgroup.pss.bean.SearchCondition;
import com.wondersgroup.pss.bo.PssUser;
import com.wondersgroup.pss.dao.UserDAO;

/**
 * 用户管理相关操作
 * 
 * @author SHI
 */
@Transactional
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * 通过ID获取用户对象
     * 
     * @param id
     * @param loadMode
     * @return
     */
    public PssUser get(String id, int... loadMode) {
        PssUser user = userDAO.get(id);

        if (user != null && loadMode.length > 0) {
            for (int m : loadMode) {
                switch (m) {
                case 0:
                    CascadeUtil.lazyInit(user); // 级联加载全部集合
                    break;
                default:
                    break;
                }
            }
        }

        return user;
    }

    /**
     * 保存或更新用户对象
     * 
     * @param user
     */
    public void update(PssUser user) {
        userDAO.update(user);
    }

    /**
     * 物理删除用户对象
     * 
     * @param user
     */
    public void delete(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ServiceException("用户ID为空！");
        }

        PssUser user = new PssUser();
        user.setUserId(id);
        userDAO.delete(user);
    }

    /**
     * 设置用户有效性
     * 
     * @param id
     * @param valid
     */
    public void valid(String id, String valid) {
        if (StringUtils.isBlank(id)) {
            throw new ServiceException("用户ID为空！");
        }

        // 根据ID获取用户对象
        PssUser user = userDAO.get(id);
        if (user == null) {
            throw new ServiceException("用户对象不存在！");
        }

        // 设置用户有效性
        user.setValid(valid);
        // 更新用户信息
        userDAO.update(user);
    }

    /**
     * 批量更新用户有效性
     * 
     * @param ids
     * @param valid
     */
    public void batchValid(List<String> ids, String valid) {
        if (ids == null || ids.isEmpty()) {
            throw new ServiceException("用户ID为空！");
        }

        // 批量更新用户有效性
        userDAO.batchValid(ids, valid);
    }

    /**
     * 用户密码重置
     * 
     * @param id
     */
    public void resetPwd(String id) {
        if (StringUtils.isBlank(id)) {
            throw new ServiceException("用户ID为空！");
        }

        // 根据ID获取用户对象
        PssUser user = userDAO.get(id);
        if (user == null) {
            throw new ServiceException("用户对象不存在！");
        }

        // 重置密码
        user.setUserPwd(MD5Util.getMD5(user.getInitPwd()));
        // 更新用户信息
        userDAO.update(user);
    }

    /**
     * 分页查询用户
     * 
     * @param condition 查询条件
     * @return
     */
    public Page findUserWithPage(SearchCondition condition) {
        return userDAO.findUserWithPage(condition);
    }

    /**
     * 用户名查重
     * 
     * @param userName
     * @return
     */
    public boolean verifyDup(String userName) {
        // 用户名为空，认为查重校验未通过
        if (StringUtils.isBlank(userName)) {
            return false;
        }

        // 用户名查重
        int count = userDAO.countByName(userName);

        // 返回校验结果
        return count == 0;
    }
}
