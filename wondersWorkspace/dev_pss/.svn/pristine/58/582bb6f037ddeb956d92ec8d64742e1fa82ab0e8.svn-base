package com.wondersgroup.pss.controller;

import java.io.IOException;
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
import com.wondersgroup.pss.bo.PssQa;
import com.wondersgroup.pss.bo.PssQaTag;
import com.wondersgroup.pss.constant.BusinessConstants;
import com.wondersgroup.pss.service.QAService;
import com.wondersgroup.pss.util.BusinessUtil;

/**
 * 智能问答管理控制
 * 
 * @author huangjiabei
 */
@Controller
@RequestMapping("/qa")
public class QAController {
    @Autowired
    private QAService qaService;

    /**
     * 转至问题删除页面
     * 
     * @param qaId
     */
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(String qaId) {
        try {
            // 删除pssQa
            PssQa pssQa = new PssQa();
            pssQa.setQaId(qaId);
            qaService.delete(pssQa);
        } catch (Exception e) {
            return "问题删除失败！";
        }

        return "success";

    }

    /**
     * 批量删除选中问题
     * 
     * @param idStr
     */
    @ResponseBody
    @RequestMapping("/batchdel")
    public String batchDelete(String idStr) {
        // 拆分idStr为数组
        String[] idArr = idStr.split(";");
        try {
            for (int i = 0; i < idArr.length; i++) {
                PssQa pssQa = qaService.get(idArr[i]);
                qaService.delete(pssQa);
            }
        } catch (Exception e) {
            return "问题删除失败！";
        }

        return "success";

    }

    /**
     * robot 通过jpql语句访问数据库， 通过连表查询， 通过tagId查询qaCont
     * 
     * @param model
     * @param searchRobot
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/searchRobot")
    public List<PssQa> robot(String searchRobot) {
        if (StringUtils.isBlank(searchRobot)) {
            return null;
        }

        // 返回匹配的智能问答
        return BusinessUtil.clearChain(qaService.findByKeywords(searchRobot));
    }

    /**
     * 转至问题查询页面
     * 
     * @return
     */
    @Modual(BusinessConstants.MODUAL_QA_MANA)
    @RequestMapping("/qa_list")
    public String list(SearchCondition condition, Model model) {
        if (condition != null) {
            Page page = qaService.findByConditionWithPage(condition);
            model.addAttribute("page", page);
            model.addAttribute("condition", condition);
        }
        return "qa/qa_list";
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody
    PssQa pssQa) {
        try {
            if (pssQa == null) {
                throw new ServiceException("该问题不存在！");
            }

            // 获取问题ID
            String id = pssQa.getQaId();

            // 问题ID不为空，说明当前操作是编辑操作
            if (StringUtils.isNotBlank(id)) {
                // 当前已存在的问题对象
                PssQa existedPssQa = qaService.get(id, 0);

                // 将页面内容更新至问题对象
                FormUtil.copyProperties(existedPssQa, pssQa);

                // 将页面内容更新至问题产品关联集合
                if (existedPssQa.getPssQaTagSet() == null) {
                    Set<PssQaTag> pssQaTagSet = new LinkedHashSet<PssQaTag>();
                    pssQaTagSet.addAll(pssQa.getPssQaTagSet());
                    existedPssQa.setPssQaTagSet(pssQaTagSet);
                } else {
                    FormUtil.updateSet(existedPssQa.getPssQaTagSet(), pssQa.getPssQaTagSet());
                }
                // 级联设置用户对象主键
                CascadeUtil.setRefProperty(pssQa, id, "qaId");
                // 更新已有问题信息
                qaService.update(existedPssQa);
            } else {

                // 保存新增问题信息
                // 级联设置用户对象主键
                CascadeUtil.setRefProperty(pssQa, BusinessUtil.randomUUID(), "qaId");

                qaService.update(pssQa);

            }
        } catch (Throwable t) {
            t.printStackTrace();
            // 问题信息保存失败，返回失败信息
            return "问题保存失败！";
        }

        // 保存成功，返回成功信息
        return "success";
    }

    /**
     * 转至问题保存与修改页面
     * 
     * @param qaId
     * @param model
     * @return
     */
    @RequestMapping("/qa_edit")
    public String edit(String qaId, Model model) {
        PssQa pssQa = new PssQa();
        if (StringUtils.isNotEmpty(qaId)) {
            pssQa = qaService.get(qaId,0);
        }
        // 把问题对象传至下一个页面
        model.addAttribute("pssQa", pssQa);
        // 跳转至qa_edit页面
        return "qa/qa_edit";
    }
}
