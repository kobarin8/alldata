package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductAddCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAddCompleteAction  extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private String name;
	private String price;
	private String stock;

	public String execute()  throws SQLException{

		session.put("namekey", name);
		session.put("pricekey", price);
		session.put("stockkey", stock);

		ProductAddCompleteDAO DAO = new ProductAddCompleteDAO();

		DAO.createUser(
			session.get("namekey").toString(),
			session.get("pricekey").toString(),
			session.get("stockkey").toString()
			);

		return SUCCESS;

		}

	@Override
	public void setSession(Map<String, Object> session) {this.session = session;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPrice() {return price;}
	public void setPrice(String price) {this.price = price;}

	public String getStock() {return stock;}
	public void setStock(String stock) {this.stock = stock;}



}
