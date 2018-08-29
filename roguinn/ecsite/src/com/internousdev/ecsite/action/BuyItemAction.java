package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;														//session変数の定義
	private int count;																		//setget変数
	private String pay;																		//setget変数

	public String execute() {																//executetメソッドの定義

		String result = SUCCESS;															//String型変数resultの定義

		int intCount = Integer.parseInt(session.get("count").toString());					//int型変数intCountを定義しつつ、session変数countをつくり、値をjspから代入させたものを代入している
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());			//int型変数intCountを定義しつつ、session変数countをつくり、値をjspから代入させたものを代入している

		session.put("count", count);														//キー名countのsessin変数にcountを代入する
		session.put("total_price", intCount * intPrice);									//キー名total_priceのsessin変数にintCount*intPriceの関数を代入する

		String payment;																		//String型変数paymentを定義する

		if (pay.equals("1")) {																//

			payment = "現金払い";															//
			session.put("pay", payment);													//
		}

		else {																				//
			payment = "クレジットカード";													//
			session.put("pay", payment);													//
		}

		return result;																		//

	}

	public void setCount(int count) {this.count = count;}									//

	public void setPay(String pay) {this.pay = pay;}										//

	@Override
	public void setSession(Map<String, Object> session) {this.session = session;}			//

}