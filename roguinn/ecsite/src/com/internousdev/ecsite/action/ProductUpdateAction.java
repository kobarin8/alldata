package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductUpdateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductUpdateAction extends ActionSupport  implements SessionAware  {

	private String ItemName;
	private String ItemPrice;
	private String ItemStock;

	public Map<String,Object> session;

	public String execute() throws SQLException {

		ProductUpdateDAO DAO = new ProductUpdateDAO();

		String name =ItemName;
		String price =ItemPrice;;
		String stock =ItemStock;

		String kobetu1 =session.get("ItemNameKey").toString();
		String kobetu2 =session.get("ItemPriceKey").toString();
		String kobetu3 =session.get("ItemStockKey").toString();

		DAO.productUpdate(name, price, stock, kobetu1, kobetu2, kobetu3);

		System.out.println("全行動終了");

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