package com.ljh.domain.entity.po;

import java.util.Date;

public class ProPhoto {

    private Long id;

    private Long proId;

    private String url;

    private String name;

    private Date createTime;

    public ProPhoto() {
    }

    public ProPhoto(Long proId, String url, String name) {
        super();
        this.proId = proId;
        this.url = url;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
