package com.li.entity;

import java.io.Serializable;

/**
 * 一级类目
 */
public class ItemCategoryOne implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 类目名称
     */
    private String name;



    public ItemCategoryOne(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemCategoryOne() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "ItemCategoryOne [id=" + id + ", name=" + name + "]";
	}

    
}
