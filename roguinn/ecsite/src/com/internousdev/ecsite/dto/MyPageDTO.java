package com.internousdev.ecsite.dto;

public class MyPageDTO {

	public String itemName;																//setget変数
	public String totalPrice;															//setget変数
	public String totalCount;															//setget変数
	public String payment;																//setget変数
	public String userName;																//setget変数
	public String id;																	//setget変数
	public String insert_date;															//setget変数

	public String getId() {return id;}													//getter
	public void setId(String id) {this.id = id;}										//setter

	public String getItemName() {return itemName;}										//getter
	public void setItemName(String itemName) {this.itemName = itemName;}				//setter

	public String getTotalPrice() {return totalPrice;}									//getter
	public void setTotalPrice(String totalPrice) {this.totalPrice = totalPrice;}		//setter

	public String getTotalCount() {return totalCount;}									//getter
	public void setTotalCount(String totalCount) {this.totalCount = totalCount;}		//etter

	public String getPayment() {return payment;}										//getter
	public void setPayment(String payment) {this.payment = payment;	}					//setter

	public String getUserName() {return userName;}										//getter
	public void setUserName(String userName) {this.userName = userName;}				//setter

	public String getInsert_date() {return insert_date;}								//getter
	public void setInsert_date(String insert_date) {this.insert_date = insert_date;}	//setter

}