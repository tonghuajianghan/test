package com.wondersgroup.pss.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.wondersgroup.core.bean.Page;
import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.dao.BaseDAO;
import com.wondersgroup.core.exception.DAOException;
import com.wondersgroup.pss.bean.SearchCondition;
import com.wondersgroup.pss.bo.PssUser;
import com.wondersgroup.pss.constant.BusinessConstants;

/**
 * 用户相关操作
 * 
 * @author SHI
 */
@Repository
public class UserDAO extends BaseDAO {
    /**
     * 保存或更新用户对象
     * 
     * @param user 用户对象
     */
    public void update(PssUser user) {
        super.update(user);
    }

    /**
     * 物理删除用户对象
     * 
     * @param user 用户对象
     */
    public void delete(PssUser user) {
        String id = user.getUserId();

        if (StringUtils.isBlank(id)) {
            throw new DAOException("用户ID不存在，无法删除！");
        }

        // 删除用户对象
        super.delete(user);

        // 刪除用户关联产品对象
        String jpql = "delete from MpUserProd where userId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    /**
     * 通过ID获取用户对象
     * 
     * @param id
     * @return
     */
    public PssUser get(String id) {
        return super.get(PssUser.class, id);
    }

    /**
     * 通过用户名获取有效的用户对象
     * 
     * @param userName
     * @return
     */
    public PssUser getByName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return null;
        }

        return super.findUniqueByJPQL("from PssUser where userName = ?1 and valid = ?2", userName, GlobalConstants.YES_VALUE);
    }

    /**
     * 通过用户名查询用户数
     * 
     * @param userName
     * @return
     */
    public int countByName(String userName) {
        return super.countByJPQL("select count(u) from PssUser u where userName = ?1", userName);
    }

    /**
     * 批量设置用户有效性
     * 
     * @param list
     * @param valid
     */
    public void batchValid(List<String> list, String valid) {
        String jpql = "update PssUser set valid = ?1 where userId in (?2)";
        Query query = em.createQuery(jpql);

        // 批量更新用户有效性
        query.setParameter(1, valid);
        query.setParameter(2, list);
        query.executeUpdate();
    }

    /**
     * 分页查询用户（查询结果不包括系统管理员）
     * 
     * @param condition 查询条件
     * @return
     */
    public Page findUserWithPage(SearchCondition condition) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        StringBuffer jpql = new StringBuffer("from PssUser where userType != :sysUser");
        parameterMap.put("sysUser", BusinessConstants.USER_TYPE_SYS);

        PssUser user = condition.getUser();
        if (user == null) {
            user = new PssUser();
        }

        if (StringUtils.isNotBlank(user.getUserName())) {
            jpql.append(" and userName like :userName");
            parameterMap.put("userName", "%" + StringUtils.trimToEmpty(user.getUserName()) + "%");
        }

        if (StringUtils.isNotBlank(user.getUserType())) {
            jpql.append(" and userType = :userType");
            parameterMap.put("userType", user.getUserType());
        }

        return super.findByJPQLWithPage(jpql.toString(), condition.getPageNo(), condition.getPageSize(), parameterMap);
    }
}
