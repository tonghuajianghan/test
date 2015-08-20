package com.wondersgroup.pss.bean;

import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.pss.bo.PssUser;

public class SearchCondition {
    private int pageNo = 1;

    private int pageSize = Integer.valueOf(ConfigConstants.getInstance().get("page.pageSize"));

    private PssUser user = new PssUser();

    private String prodId;

    private String tagDesc;

    private String qaDesc;

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    public String getQaDesc() {
        return qaDesc;
    }

    public void setQaDesc(String qaDesc) {
        this.qaDesc = qaDesc;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PssUser getUser() {
        return user;
    }

    public void setUser(PssUser user) {
        this.user = user;
    }

}
