package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;																							//jspgetset変数
	private String loginPassword;																					//jspgetset変数

	public Map<String, Object> session;																			//session変数

	private LoginDAO loginDAO = new LoginDAO();														//DAOインスタンス
	private LoginDTO loginDTO = new LoginDTO();															//DTOインスタンス
	private BuyItemDAO buyItemDAO = new BuyItemDAO();											//DAOインスタンス

	public String execute() {																								//executeメソッド定義

		String result = ERROR;																							//String型変数resultの定義

		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);					//LoginDTOに代入(客情報があるかないかの過程)
		session.put("loginUser", loginDTO);																		//list型LoginDTOを代入する。キー名はloginUser

		if (
				((LoginDTO) session.get("loginUser")).getLoginFlg()									//getLoginFlgの戻り値がtrueならtrue
																																		//getLoginFlgはboolean型であり、LoginDTOで初期値がfalseになっている

			){
																																		//ログインができることが確認されたので、購入情報を持ってくる
			result = SUCCESS;																								//変数resultにSUCCESSを代入

			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();							//DTOのインスタンス化

			session.put("login_user_id", loginDTO.getLoginId());										//LoginDTOのgetterをsession変数に代入する
			session.put("id", buyItemDTO.getId());																//LoginDTOのgetterをsession変数に代入する
			session.put("buyItem_name", buyItemDTO.getItemName());							//LoginDTOのgetterをsession変数に代入する
			session.put("buyItem_price", buyItemDTO.getItemPrice());								//LoginDTOのgetterをsession変数に代入する

			return result;																										//resultをreturnする(SUCCESS)

		}

		return result;																											//resultをreturnする(ERROR)

	}

	public String getLoginUserId() {return loginUserId;}																		//getter
	public void setLoginUserId(String loginUserId) {this.loginUserId = loginUserId;}							//setter

	public String getLoginPassword() {return loginPassword;}																//getter
	public void setLoginPassword(String loginPassword) {this.loginPassword = loginPassword;}		//setter

	@Override
	public void setSession(Map<String, Object> session) {this.session = session;}								//session setter

}