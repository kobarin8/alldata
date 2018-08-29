package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.LoginDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {								//

	private String username;													//setget変数
	private String password;													//setget変数

	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();			//LoginDTOのgetset変数

	public String execute() {													//executeメソッド定義

		String ret;																//String型変数retを定義

		LoginDAO dao = new LoginDAO();											//DAOのインスタンス化
		LoginDTOList = dao.select(username, password);							//LoginDAOのselectメソッドを引数を用いて実行し、LoginDTOlistに代入する。

		if (this.username.equals(getUsername())									//ただの判定定義
				&& this.password.equals(getPassword())) 						//
		{ret = SUCCESS;}														//String型変数retにSUCCESSを代入する

		else																	//falseの場合
		{ret = ERROR;}															//String型変数にERRORを代入する

		return ret;																//retを戻り値として返す

	}

	public String getUsername() {return username;}								//getter
	public void setUsername(String username) {this.username = username;}		//setter

	public String getPassword() {return password;}								//getter
	public void setPassword(String password) {this.password = password;}		//setter

	public List<LoginDTO> getLoginDTOList() {return LoginDTOList;}				//getter
	public void setLoginDTOList(List<LoginDTO> loginDTOList) 					//setter
	{LoginDTOList = loginDTOList;}

}