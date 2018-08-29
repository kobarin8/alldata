package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.HelloStrutsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport {

	public String execute() {

		String ret=ERROR;//retの初期値をerrorに

		HelloStrutsDAO dao=new HelloStrutsDAO();//daoのインスタンス化

		boolean b=dao.select();//boolean型の変数bを定義すると共に、dao側のbooleanの判定を決めている

		if(b==true){//boolean型の変数bがtrueならば
			ret=SUCCESS;//String型の変数retにSUCCESSを代入する
		}

		else{//boolean型の変数bがfalseの場合
			ret=ERROR;//String型の変数retにERRORを代入する
		}

		return ret;

	}
}