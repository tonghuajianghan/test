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
import com.wondersgroup.core.util.ext.WebContext;
import com.wondersgroup.pss.bean.SearchCondition;
import com.wondersgroup.pss.bean.UserInfo;
import com.wondersgroup.pss.bo.PssQa;

@Repository
public class QADAO extends BaseDAO {

    /**
     * 通过ID获取智能问答对象
     * 
     * @param id
     * @return
     */
    public PssQa get(String id) {
        return super.get(PssQa.class, id);
    }

    /**
     * 保存或更新智能问答对象
     * 
     * @param qa
     */
    public void update(PssQa qa) {
        super.update(qa);
    }

    /**
     * 删除智能问答对象
     * 
     * @param qa
     */
    public void delete(PssQa qa) {
        // 智能问答对象ID
        String qaId = qa.getQaId();

        if (StringUtils.isBlank(qaId)) {
            throw new DAOException("智能问答对象ID为空，无法删除！");
        }
        // 删除智能问题对象
        String jpqlqa = "delete from PssQa where qaId = ?1";
        Query queryqa = em.createQuery(jpqlqa);
        queryqa.setParameter(1, qaId);
        queryqa.executeUpdate();

        // 删除智能问答关联标签
        String jpqltag = "delete from PssQaTag where qaId = ?1";
        Query querytag = em.createQuery(jpqlqa);
        queryqa.setParameter(1, qaId);
        queryqa.executeUpdate();
    }

    /**
     * 根据条件获取智能问答页对象
     * 
     * @param condition
     * @return
     */
    public Page findByConditionWithPage(SearchCondition condition) {
        // 创建JBQL语句
        StringBuffer jpql = new StringBuffer("select qa from PssQa qa where 1 = 1 ");
        Map<String, Object> parameterMap = new HashMap<String, Object>();

        // 查询问题标签
        if (StringUtils.isNotBlank(condition.getTagDesc())) {
            jpql.append(" and exists (select 1 from PssQaTag tag where qa.qaId = tag.qaId and tag.tagDesc = :tagDesc)");
            parameterMap.put("tagDesc", StringUtils.trimToEmpty(condition.getTagDesc()));
        }

        // 查询问题描述
        if (StringUtils.isNotBlank(condition.getQaDesc())) {
            jpql.append(" and qa.qaDesc like :qaDesc");
            parameterMap.put("qaDesc", "%" + StringUtils.trimToEmpty(condition.getQaDesc() + "%"));
        }

        // 查询问题相关产品
        if (StringUtils.isNotBlank(condition.getProdId())) {
            jpql.append(" and qa.prodId = :prodId");
            parameterMap.put("prodId", condition.getProdId());
        }

        // 根据用户权限查询
        UserInfo user = (UserInfo) WebContext.getSession().getAttribute(GlobalConstants.SESSION_USER);
        List<String> prodIdList = user.getProdIdList();

        if (prodIdList == null || prodIdList.isEmpty()) {
            return Page.EMPTY_PAGE;
        } else {
            jpql.append(" and qa.prodId in (:prodIdList)");
            parameterMap.put("prodIdList", prodIdList);
        }

        // 排序
        jpql.append(" order by qaId asc");

        // 返回智能问答页对象
        return super.findByJPQLWithPage(jpql.toString(), condition.getPageNo(), condition.getPageSize(), parameterMap);

    }

    /**
     * 根据关键词查询智能问答列表
     * 
     * @param list
     * @return
     */
    public List<PssQa> findByKeywords(List<String> list) {
        // 关键词不能为空
        if (list == null || list.isEmpty()) {
            return null;
        }

        StringBuffer jpql = new StringBuffer("select qa from PssQa qa where 1 != 1");
        Map<String, Object> parameterMap = new HashMap<String, Object>();

        // 模糊匹配问题描述或全匹配问题标签
        int idx = 0;
        for (String keyword : list) {
            jpql.append(" or qa.qaDesc like :qaDesc").append(idx);
            jpql.append(" or exists (select 1 from PssQaTag tag where 1 = 1 and qaId = qa.qaId and tagDesc = :tagDesc").append(idx).append(")");

            parameterMap.put("qaDesc" + idx, "%" + StringUtils.trimToEmpty(keyword) + "%");
            parameterMap.put("tagDesc" + idx++, StringUtils.trimToEmpty(keyword));
        }

        // 返回智能问答列表
        return super.findByJPQL(jpql.toString(), parameterMap);
    }
}
