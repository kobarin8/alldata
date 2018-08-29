package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.DeleteItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteItemAction  extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public String execute() throws SQLException {

		DeleteItemDAO DAO = new DeleteItemDAO();

		String name =session.get("ItemNameKey").toString();
		String price =session.get("ItemPriceKey").toString();
		String stock =session.get("ItemStockKey").toString();

		DAO.ItemDelete(name,price,stock);

		System.out.println(name);
		System.out.println(price);
		System.out.println(stock);

		return SUCCESS;

		}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}








}
