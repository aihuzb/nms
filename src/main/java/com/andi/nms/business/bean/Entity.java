package com.andi.nms.business.bean;

import javax.persistence.*;

@Table(name = "t_entity")
public class Entity {
    @Id
    @Column(name = "entity_id")
    private Integer entityId;

    @Column(name = "entity_key")
    private String entityKey;

    private String name;

    @Column(name = "name_us")
    private String nameUs;

    private String url;

    private Integer parent;

    private String icon;

    private Integer sort;

    /**
     * 1：菜单，2：按钮，3：操作
     */
    private Integer type;

    private String description;

    /**
     * @return entity_id
     */
    public Integer getEntityId() {
        return entityId;
    }

    /**
     * @param entityId
     */
    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    /**
     * @return entity_key
     */
    public String getEntityKey() {
        return entityKey;
    }

    /**
     * @param entityKey
     */
    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name_us
     */
    public String getNameUs() {
        return nameUs;
    }

    /**
     * @param nameUs
     */
    public void setNameUs(String nameUs) {
        this.nameUs = nameUs;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return parent
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取1：菜单，2：按钮，3：操作
     *
     * @return type - 1：菜单，2：按钮，3：操作
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1：菜单，2：按钮，3：操作
     *
     * @param type 1：菜单，2：按钮，3：操作
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}