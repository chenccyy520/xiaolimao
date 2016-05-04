package com.sozunyi.xiaolimao.entity;

public class CollectionShop {
	private int ID;
	private String shopName;
	private String notice;
	private float star;
	private String shopAdress;
	private String phone;
	private String weChatNum;
	private float distributionFee;
	private String range;
	private String openTime;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public String getShopAdress() {
		return shopAdress;
	}
	public void setShopAdress(String shopAdress) {
		this.shopAdress = shopAdress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeChatNum() {
		return weChatNum;
	}
	public void setWeChatNum(String weChatNum) {
		this.weChatNum = weChatNum;
	}
	public float getDistributionFee() {
		return distributionFee;
	}
	public void setDistributionFee(float distributionFee) {
		this.distributionFee = distributionFee;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
}
