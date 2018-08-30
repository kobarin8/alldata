package com.internousdev.sampleweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb.dao.MCategoryDAO;
import com.internousdev.sampleweb.dao.PurchaseHistoryInfoDAO;
import com.internousdev.sampleweb.dto.MCategoryDTO;
import com.internousdev.sampleweb.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware{
	private String categoryId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String, Object> session;
	public String execute() {

		PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();														//インスタンス化

		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();					//リスト作成

		purchaseHistoryInfoDtoList = purchaseHistoryInfoDao.getPurchaseHistoryList(String.valueOf(session.get("loginId")));//セッション変数からログイン済みidを引数にする

		Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDtoList.iterator();		//iteratorメソッドを付加し、コレクション要素を順番に処理させるようにする

		if
		(!(iterator.hasNext()))																						//要素が続かなければtrue
		{purchaseHistoryInfoDtoList = null;}																//リストの中身をnullにし、空にする

		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);		//DtoListにpurchaseHistoryから所得した情報を代入する

		if
		(!session.containsKey("mCategoryList"))															//セッション変数化されたカテゴリリストがなければtrue カテゴリリストの作成を実行する
		{
			MCategoryDAO mCategoryDao = new MCategoryDAO();								//インスタンス化
			mCategoryDtoList = mCategoryDao.getMCategoryList();								//メソッドを実行する
			session.put("mCategoryDtoList", mCategoryDtoList);									//セッションに代入し、リストを作成
		}

		return SUCCESS;
	}


//-----------------------------------------------------------------------------------------------------------------------------------------------------

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}


	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}


	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
