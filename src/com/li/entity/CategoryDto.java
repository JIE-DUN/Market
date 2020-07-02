package com.li.entity;

import java.util.List;

/**
 * 一级类目和它的二级类目列表
 */
public class CategoryDto {

    private ItemCategoryOne father;

    private List<ItemCategoryTwo> childrens;

    public ItemCategoryOne getFather() {
        return father;
    }

    public void setFather(ItemCategoryOne father) {
        this.father = father;
    }

	public List<ItemCategoryTwo> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<ItemCategoryTwo> childrens) {
		this.childrens = childrens;
	}
}
