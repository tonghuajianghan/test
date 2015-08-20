package com.wondersgroup.pss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品宣传网站
 * 
 * @author SHI
 */
@Controller
@RequestMapping("/w")
public class WebController {
    /**
     * 转至产品首页
     * 
     * @return
     */
    @RequestMapping("/myhome")
    public String home() {
        return "myhome/myhome";
    }

    /**
     * 转至产品详情页面
     * 
     * @param id 产品ID
     * @param model
     * @return
     */
    @RequestMapping("/prod_detail")
    public String prod(String id, Model model) {
        return "web/prod_detail";
    }

    /**
     * 转至智能机器人问答页面
     * 
     * @return
     */
    @RequestMapping("/robot")
    public String robot() {
        return "web/robot";
    }
}
