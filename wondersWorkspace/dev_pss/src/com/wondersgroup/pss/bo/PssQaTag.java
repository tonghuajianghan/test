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

/**
 * 问题标签实体类
 *
 * @author jianghan
 */
@Entity
@Table(name = "PSS" + GlobalConstants.DB_PREFIX + "PSS_QA_TAG")
public class PssQaTag implements java.io.Serializable {

    private static final long serialVersionUID = 5772327734152504781L;

    // 标签ID
    private String tagId;

    // 标签描述
    private String tagDesc;

    // 问题ID
    private String qaId;

    // 智能问答对象
    private PssQa pssQa;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "TAG_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Column(name = "TAG_DESC", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    @Column(name = "QA_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 32)
    public String getQaId() {
        return qaId;
    }

    public void setQaId(String qaId) {
        this.qaId = qaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QA_ID", referencedColumnName = "QA_ID", insertable = false, updatable = false)
    public PssQa getPssQa() {
        return pssQa;
    }

    public void setPssQa(PssQa pssQa) {
        this.pssQa = pssQa;
    }
}