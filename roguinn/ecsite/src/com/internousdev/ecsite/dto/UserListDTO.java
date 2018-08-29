package com.internousdev.ecsite.dto;

public class UserListDTO {

	private String loginId;																														//setget変数
	private String loginPass;																										//setget変数
	private String userName;																												//setget変数
	private String insertDate;

	public String getLoginId() {return loginId;}																					//getter
	public void setLoginId(String loginId) {this.loginId = loginId;}													//setter

	public String getLoginPass() {return loginPass;}															//getter
	public void setLoginPass(String loginPass) {this.loginPass = loginPass;}	//setter

	public String getUserName() {return userName;}																			//getter
	public void setUserName(String userName) {this.userName = userName;}								//setter

	public String getInsertDate() {return insertDate;}
	public void setInsertDate(String insertDate) {this.insertDate = insertDate;}



}
