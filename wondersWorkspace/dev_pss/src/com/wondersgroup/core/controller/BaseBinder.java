package com.wondersgroup.core.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.wondersgroup.core.util.ext.DateEditor;
import com.wondersgroup.core.util.ext.NumberEditor;

public class BaseBinder {
    /**
     * 注册自定义属性编辑器，将Form的指定数据类型的null值进行转换，作为判断是否录入为空的条件
     * 
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, new NumberEditor(Integer.class));
        binder.registerCustomEditor(Short.class, new NumberEditor(Short.class));
        binder.registerCustomEditor(Double.class, new NumberEditor(Double.class));
        binder.registerCustomEditor(BigDecimal.class, new NumberEditor(BigDecimal.class));
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }
}