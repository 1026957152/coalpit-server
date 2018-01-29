package com.coalvalue.domain;

//import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Peter Xu on 12/08/2014.
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseDomain implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "create_by")
    @CreatedBy
    private Integer createBy;

    @Column(name = "modify_by")
    @LastModifiedBy
    private Integer modifyBy;

    @Column(name = "create_date")
    @CreatedDate
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @Column(name = "modify_date")
    @LastModifiedDate
   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    @Column(name = "version")
    @Version
    private Integer version;

    @Transient
    protected String uri;


    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public String getUri() throws Exception {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean canbeDelete(Integer id) {
        return true;
    }
}
