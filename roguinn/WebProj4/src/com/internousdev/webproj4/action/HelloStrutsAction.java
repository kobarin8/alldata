package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.HelloStrutsDAO;
import com.internousdev.webproj4.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HelloStrutsAction extends ActionSupport {										//

	private List<HelloStrutsDTO> HelloStrutsDTOList = new ArrayList<HelloStrutsDTO>();		//getter setterのためのフィールド定義

	public String execute() {																//executeメソッドの定義

		String ret = ERROR;																	//String型変数のretを定義しつつ、初期値をERRORに
		HelloStrutsDAO dao = new HelloStrutsDAO();											//daoのインスタンス化

		HelloStrutsDTOList = dao.select();													//空のlistにメソッドによって作られた配列を埋め込むという意味

		if (HelloStrutsDTOList.size() > 0)													//listの数が0以上ならtrue(言い換えると、リストが存在するならば)
		{ret = SUCCESS;}																	//String型変数retにSUCCESSを代入する

		else																				//ifがfalseの場合に実行される処理内容
		{ret = ERROR;}																		//String型変数retにERRORを返す。

		return ret;																			//戻り値としてretをreturnする
	}

	public List<HelloStrutsDTO> getHelloStrutsDTOList() {									//getter
		return HelloStrutsDTOList;															//getter
		}

	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList) {			//setter
		HelloStrutsDTOList = helloStrutsDTOList;											//setter
		}
}