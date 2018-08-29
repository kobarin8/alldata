package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.LoginDAO;
import com.internousdev.webproj3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;																		//フィールド定義
	private String password;																		//フィールド定義

	public String execute() {																		//executeメソッドの定義

		String ret = ERROR;																			//String型変数retの定義

		System.out.println(username);																//usernameのsyso

		System.out.println(password);																//passwordのsyso

		LoginDAO dao = new LoginDAO();																//DAOをdaoとしてインスタンス化

		LoginDTO dto = new LoginDTO();																//DTOをdtoとしてインスタンス化

		dto = dao.select(username, password);														//Action内の変数を引数として代入し、メソッドを実行する

		if (this.username.equals(dto.getUsername()) && this.password.equals(dto.getPassword())) {	//this.usernameはjspの値が入っており、dto.getterには該当なしか、
																									//DBから所得された値が入っている。そのため何回かif文が試行していることになる

			ret = SUCCESS;																			//retにsuccessを代入

		}

		else {ret = ERROR;}																			//retにERRORを代入

		return ret;																					//retを戻り地として返す

	}
																									//getter setter設定
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

}