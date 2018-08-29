package com.internousdev.webproj2.action;
import com.internousdev.webproj2.dao.TestDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private String username;									//フィールド定義
	private String password;									//フィールド定義

	public String execute(){									//execute()メソッドの定義

		String ret=ERROR;										//String型定数retの定義

		TestDAO dao=new TestDAO();								//TestDAOのインスタンス化

		int count=dao.insert(username, password);				//int型変数であるcountを定義しつつ、メソッドを実行しており、さらにreturnの値がcountに代入されている。

		if(count>0){											//int型変数countが0以上の場合
			ret=SUCCESS;										//Stiring型変数retにSuccessを代入する
		}

		return ret;												//retをexecute()戻り値としてreturnする
	}
																//getter setterの定義
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}