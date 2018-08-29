package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
public class HomeAction extends ActionSupport implements SessionAware {

public Map<String, Object> session;

public String execute() {
//ログアウト状態
String result = "login";

//ログイン判定
if (session.containsKey("id")) {

//購入履歴を返している
BuyItemDAO buyItemDAO = new BuyItemDAO();
BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

//buytem.jspでの商品情報の値を入れるセッション変数を作成する
session.put("id", buyItemDTO.getId());
session.put("buyItem_name", buyItemDTO.getItemName());
session.put("buyItem_price", buyItemDTO.getItemPrice());

result = SUCCESS;

}
return result;

}
@Override
public void setSession(Map<String, Object> session){this.session = session;}

}

