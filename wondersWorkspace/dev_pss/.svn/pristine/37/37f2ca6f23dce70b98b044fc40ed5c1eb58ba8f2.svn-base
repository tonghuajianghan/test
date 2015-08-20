package com.wondersgroup.core.util.ext;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import com.wondersgroup.core.constant.GlobalConstants;

public class NumberEditor extends PropertyEditorSupport {
    private final Class<? extends Number> numberClass;

    public NumberEditor(Class<? extends Number> numberClass) throws IllegalArgumentException {
        this.numberClass = numberClass;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (!StringUtils.hasText(text)) {
            setValue(null);
        } else {
            setValue(NumberUtils.parseNumber(text, numberClass));
        }
    }

    @Override
    public void setValue(Object value) {
        if (value == null) {
            if (numberClass.equals(Integer.class)) {
                super.setValue(GlobalConstants.FORM_INTEGER_NULL);
            } else if (numberClass.equals(Short.class)) {
                super.setValue(GlobalConstants.FORM_SHORT_NULL);
            } else if (numberClass.equals(Double.class)) {
                super.setValue(GlobalConstants.FORM_DOUBLE_NULL);
            } else if (numberClass.equals(BigDecimal.class)) {
                super.setValue(GlobalConstants.FORM_BIGDECIMAL_NULL);
            } else {
                super.setValue(null);
            }
        } else if (value instanceof Number) {
            super.setValue(NumberUtils.convertNumberToTargetClass((Number) value, numberClass));
        } else {
            super.setValue(value);
        }
    }
}
