package com.sozunyi.xiaolimao.entity;

import java.util.Date;
import java.util.List;

public class OrdersInfo {
	private int ID;//订单id
	private String orderNumber;//订单号
	private int shopId;//店铺ID
	private String shopName;//店铺名称
	private int count;//商品总数
	private float totalPrice;//总金额
	private Date orderDate;
	private int orderStates;//订单状态
	private float carriage;//运费
	private List<GoodsInfo> listGoods;//商品信息
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderStates() {
		return orderStates;
	}
	public void setOrderStates(int orderStates) {
		this.orderStates = orderStates;
	}
	public float getCarriage() {
		return carriage;
	}
	public void setCarriage(float carriage) {
		this.carriage = carriage;
	}
	public List<GoodsInfo> getListGoods() {
		return listGoods;
	}
	public void setListGoods(List<GoodsInfo> listGoods) {
		this.listGoods = listGoods;
	}
		
}
