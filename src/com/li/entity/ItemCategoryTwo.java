package com.li.entity;

/**
 * 二级类目
 *
 */
public class ItemCategoryTwo {

	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 类目名称
	 */
	private String name;

	/**
	 * 一级类目id（外键）
	 */
	private Integer oid;

	/**
	 * 一级类目
	 */
	private ItemCategoryOne itemCategoryOne;

	public ItemCategoryTwo(Integer id, String name, Integer oid, ItemCategoryOne itemCategoryOne) {
		super();
		this.id = id;
		this.name = name;
		this.oid = oid;
		this.itemCategoryOne = itemCategoryOne;
	}

	public ItemCategoryTwo() {
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

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public ItemCategoryOne getItemCategoryOne() {
		return itemCategoryOne;
	}

	public void setItemCategoryOne(ItemCategoryOne itemCategoryOne) {
		this.itemCategoryOne = itemCategoryOne;
	}

	@Override
	public String toString() {
		return "ItemCategoryTwo [id=" + id + ", name=" + name + ", oid=" + oid + ", itemCategoryOne=" + itemCategoryOne
				+ "]";
	}

	
	
}
