package com.internousdev.ecsite.dto;

public class ProductListDTO {

	private String ItemName;																														//setget変数
	private String ItemPrice;																										//setget変数
	private String ItemStock;																												//setget変数

	public String getItemName() {return ItemName;}																					//getter
	public void setItemName(String ItemName) {this.ItemName = ItemName;}													//setter

	public String getItemPrice() {return ItemPrice;}															//getter
	public void setItemPrice(String ItemPrice) {this.ItemPrice = ItemPrice;}	//setter

	public String getItemStock() {return ItemStock;}																			//getter
	public void setItemStock(String ItemStock) {this.ItemStock = ItemStock;}								//setter

}
