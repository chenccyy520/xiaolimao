package com.sozunyi.xiaolimao.entity;

public class AdressInfo {

	private int id;
	private String name;
	private String phone;
	private String Adress;
	private boolean defaultAdress;//是否是默认地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 收货人
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 收货人
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 收货人手机
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 收货人手机
	 * @return
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取收货地址
	 * @return
	 */
	public String getAdress() {
		return Adress;
	}
	/**
	 * 设置收货地址
	 * @param adress
	 */
	public void setAdress(String adress) {
		Adress = adress;
	}
	/**
	 * 是否是默认地址
	 * @return
	 */
	public boolean getDefaultAdress() {
		return defaultAdress;
	}
	/**
	 * 设置默认地址
	 * @return
	 */
	public void setDefaultAdress(boolean isDefaultAdress) {
		this.defaultAdress = isDefaultAdress;
	}
	
}
