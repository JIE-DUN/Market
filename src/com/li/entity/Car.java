package com.li.entity;

import java.io.Serializable;

/**
 * 购物车
 */
public class Car implements Serializable {

    private Integer id;
    /**
     * 商品id
     */
    private Integer itemId;
    /**
     * 商品对象
     * 用于级联查询
     */
    private Item item;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品单价
     */
    private Double price;

    /**
     * 商品总价
     */
    private String total;
    
	public Car(Integer id, Integer itemId, Item item, Integer userId, Integer num, Double price, String total) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.item = item;
		this.userId = userId;
		this.num = num;
		this.price = price;
		this.total = total;
	}

	public Car() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", itemId=" + itemId + ", item=" + item + ", userId=" + userId + ", num=" + num
				+ ", price=" + price + ", total=" + total + "]";
	}


}
