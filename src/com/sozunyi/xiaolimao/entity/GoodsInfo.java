package com.sozunyi.xiaolimao.entity;

public class GoodsInfo {
	private int ID;
	private String goodsName;
	private int count;
	private float price;
	private String imgUrl;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
