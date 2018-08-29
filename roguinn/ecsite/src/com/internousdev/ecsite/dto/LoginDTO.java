package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;																														//setget変数
	private String loginPassword;																										//setget変数
	private String userName;																												//setget変数
	private boolean loginFlg = false;																									//getset定数

	public String getLoginId() {return loginId;}																					//getter
	public void setLoginId(String loginId) {this.loginId = loginId;}													//setter

	public String getLoginPassword() {return loginPassword;}															//getter
	public void setLoginPassword(String loginPassword) {this.loginPassword = loginPassword;}	//setter

	public String getUserName() {return userName;}																			//getter
	public void setUserName(String userName) {this.userName = userName;}								//setter

	public boolean getLoginFlg() {return loginFlg;}																			//getter
	public void setLoginFlg(boolean loginFlg) {this.loginFlg = loginFlg;}											//setter

}