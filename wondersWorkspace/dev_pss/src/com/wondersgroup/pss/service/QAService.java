package com.wondersgroup.pss.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.core.bean.Page;
import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.util.CascadeUtil;
import com.wondersgroup.pss.bean.SearchCondition;
import com.wondersgroup.pss.bo.PssQa;
import com.wondersgroup.pss.bo.PssQaTag;
import com.wondersgroup.pss.dao.QADAO;
import com.wondersgroup.pss.util.RobotUtil;

@Service
@Transactional
public class QAService {
    @Autowired
    private QADAO qaDAO;

    /**
     * 通过ID获取智能问答对象
     * 
     * @param id
     * @param loadMode
     * @return
     */
    public PssQa get(String id, int... loadMode) {
        PssQa qa = qaDAO.get(id);

        if (qa != null && loadMode.length > 0) {
            for (int m : loadMode) {
                switch (m) {
                case 0:
                    CascadeUtil.lazyInit(qa); // 级联加载全部集合
                    break;
                default:
                    break;
                }
            }
        }

        return qa;
    }

    /**
     * 删除智能问答对象
     * 
     * @param qa
     */
    public void delete(PssQa qa) {
        qaDAO.delete(qa);
    }

    /**
     * 保存或更新智能问答对象
     * 
     * @param qa
     */
    public void update(PssQa qa) {
        qaDAO.update(qa);
    }

    /**
     * 根据条件获取智能问答页对象
     * 
     * @param condition
     * @return
     */
    @SuppressWarnings("unchecked")
    public Page findByConditionWithPage(SearchCondition condition) {
        // 根据条件获取智能问答页对象
        Page page = qaDAO.findByConditionWithPage(condition);

        if (page != null) {
            // 级联加载关联集合
            for (PssQa qa : (List<PssQa>) page.getResult()) {
                CascadeUtil.lazyInit(qa);
            }
        }

        return page;
    }

    /**
     * 根据关键词查询智能问答列表
     * 
     * @param keywords
     * @return
     */
    public List<PssQa> findByKeywords(String keywords) {
        // 分词
        List<String> kwdList = RobotUtil.splitKeyword(keywords);
        // 匹配智能问答
        List<PssQa> list = qaDAO.findByKeywords(kwdList);
        // 匹配结果条数不为空时，进行加权
        if (list != null && !list.isEmpty()) {
            int weight;
            for (PssQa pssQa : list) {
                weight = 0;
                StringBuilder tags = new StringBuilder();
                for (PssQaTag tagTmp : pssQa.getPssQaTagSet()) {
                    tags.append(tagTmp.getTagDesc());
                }
                for (String key : kwdList) {
                    if (pssQa.getQaDesc().indexOf(key) != -1) {
                        weight = weight + GlobalConstants.QA_DESC_WEIGHT;
                    }
                    if (tags.indexOf(key) != -1) {
                        weight = weight + GlobalConstants.TAG_DESC_WEIGHT;
                    }
                }
                pssQa.setWeight(weight);
            }
            // 排序
            Collections.sort(list, new Comparator<PssQa>() {
                public int compare(PssQa q1, PssQa q2) {
                    return q1.getWeight().compareTo(q2.getWeight());
                }
            });
            // 逆序
            Collections.reverse(list);
        }

        return list == null ? new ArrayList<PssQa>() : list;
    }
}
