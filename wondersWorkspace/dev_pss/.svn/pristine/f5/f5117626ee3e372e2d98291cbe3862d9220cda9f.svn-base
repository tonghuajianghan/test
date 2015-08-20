package com.wondersgroup.pss.bo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import com.wondersgroup.core.constant.GlobalConstants;

@Entity
@Table(name = "PSS" + GlobalConstants.DB_PREFIX + "PSS_QA")
public class PssQa implements java.io.Serializable {

    // Fields

    private static final long serialVersionUID = -6054326529985225088L;

    // 问题id
    private String qaId;

    // 问题描述
    private String qaDesc;

    // 问题回复
    private String qaCont;

    // 产品ID
    private String prodId;

    // 问题动态权重
    private Integer weight;

    private Set<PssQaTag> pssQaTagSet;

    @Id
    @Column(name = "QA_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
    public String getQaId() {
        return this.qaId;
    }

    public void setQaId(String qaId) {
        this.qaId = qaId;
    }

    @Column(name = "QA_DESC", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
    public String getQaDesc() {
        return qaDesc;
    }

    public void setQaDesc(String qaDesc) {
        this.qaDesc = qaDesc;
    }

    @Column(name = "QA_CONT", unique = false, nullable = false, insertable = true, updatable = true, length = 4000)
    public String getQaCont() {
        return qaCont;
    }

    public void setQaCont(String qaCont) {
        this.qaCont = qaCont;
    }

    @Column(name = "PROD_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 32)
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    @Transient
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pssQa")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public Set<PssQaTag> getPssQaTagSet() {
        return pssQaTagSet;
    }

    public void setPssQaTagSet(Set<PssQaTag> pssQaTagSet) {
        this.pssQaTagSet = pssQaTagSet;
    }
}