package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserAddCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserAddCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private String id;
	private String pass;
	private String name;

	public String execute()  throws SQLException{

		session.put("idkey", id);
		session.put("passkey", pass);
		session.put("namekey", name);

		UserAddCompleteDAO DAO = new UserAddCompleteDAO();

		DAO.createUser(
			session.get("idkey").toString(),
			session.get("passkey").toString(),
			session.get("namekey").toString()
			);

		return SUCCESS;

		}

	@Override
	public void setSession(Map<String, Object> session) {this.session = session;}

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}



}