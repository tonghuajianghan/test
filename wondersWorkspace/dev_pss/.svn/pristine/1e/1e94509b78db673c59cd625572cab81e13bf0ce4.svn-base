package com.wondersgroup.pss.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.wondersgroup.core.constant.GlobalConstants;

@Entity
@Table(name = "PSS" + GlobalConstants.DB_PREFIX + "MP_USER_PROD")
public class MpUserProd implements java.io.Serializable {

    private static final long serialVersionUID = 9211097045131125713L;

    // 用户产品关系表ID
    private String mpId;

    // 用户ID
    private String userId;

    // 产品ID
    private String prodId;

    // 网站用户
    private PssUser pssUser;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "MP_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
    public String getMpId() {
        return mpId;
    }

    public void setMpId(String mpId) {
        this.mpId = mpId;
    }

    @Column(name = "USER_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "PROD_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public PssUser getPssUser() {
        return pssUser;
    }

    public void setPssUser(PssUser pssUser) {
        this.pssUser = pssUser;
    }
}
