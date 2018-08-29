package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailAction  extends ActionSupport  implements SessionAware{

	private String ItemName;
	private String ItemPrice;
	private String ItemStock;

	public Map<String,Object> session;

	public String execute() {

		session.put("ItemNameKey", ItemName);
		session.put("ItemPriceKey", ItemPrice);
		session.put("ItemStockKey", ItemStock);

		return SUCCESS;

		}



	public String getItemName() {
		return ItemName;
	}



	public void setItemName(String itemName) {
		ItemName = itemName;
	}



	public String getItemPrice() {
		return ItemPrice;
	}



	public void setItemPrice(String itemPrice) {
		ItemPrice = itemPrice;
	}



	public String getItemStock() {
		return ItemStock;
	}



	public void setItemStock(String itemStock) {
		ItemStock = itemStock;
	}



	public Map<String, Object> getSession() {
		return session;
	}



	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}