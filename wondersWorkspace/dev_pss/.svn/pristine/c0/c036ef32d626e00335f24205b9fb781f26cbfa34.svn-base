package com.wondersgroup.pss.bean;

import java.util.ArrayList;
import java.util.List;

import com.wondersgroup.pss.bo.MpUserProd;
import com.wondersgroup.pss.bo.PssUser;

public class UserInfo {

    // 用户ID
    private String userId;

    // 用户姓名
    private String userName;

    // 用户昵称
    private String nickName;

    // 用户邮箱
    private String email;

    // 用户电话
    private String tel;

    // 用户类型
    private String userType;

    // 用户可管理的产品列表
    private List<String> prodIdList;

    public UserInfo(PssUser user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.nickName = user.getNickName();
        this.email = user.getEmail();
        this.tel = user.getTel();
        this.userType = user.getUserType();

        this.prodIdList = new ArrayList<String>();
        for (MpUserProd prod : user.getMpUserProdSet()) {
            this.prodIdList.add(prod.getProdId());
        }
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<String> getProdIdList() {
        return prodIdList;
    }

    public void setProdIdList(List<String> prodIdList) {
        this.prodIdList = prodIdList;
    }
}