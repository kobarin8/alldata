package com.internousdev.sampleweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb.dao.CartInfoDAO;
import com.internousdev.sampleweb.dto.CartInfoDTO;
import com.internousdev.sampleweb.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;

	private String categoryId;

	private Map<String, Object> session;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public String execute() {

		String result=ERROR;
		String userId = null;
		String tempUserId = null;

		 if
		 (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId")))				//ログインしていないかつ、添付ユーザーidがない時true
		 {
			 CommonUtility commonUtility = new CommonUtility();												//インスタンス化
			 session.put("tempUserId", commonUtility.getRamdomValue());									//メソッドの実行、セッション変数化
		}


		if
		(session.containsKey("loginId"))																						//ログイン済みの時true
		{userId = String.valueOf(session.get("loginId"));}															//変数userIdに値を代入する


		if
		(!(session.containsKey("loginId")) && session.containsKey("tempUserId"))					//ログインしておらず、かつセッション変数tempuserIdがない時true
		{
			userId = String.valueOf(session.get("tempUserId"));													//変数に値を代入する
			tempUserId = String.valueOf(session.get("tempUserId"));											//変数に値を代入する
		}

		productCount = String.valueOf((productCount.split(" ,",0))[0]);

		CartInfoDAO cartInfoDao = new CartInfoDAO();																//インスタンス化
		int count = cartInfoDao.regist(userId,tempUserId,productId,productCount,price);			//registメソッドを実行

		if
		(count > 0)																															//0以上ならtrue 更新できてデータが存在していればtrue
		{result=SUCCESS;}																												//変数resultにsuccessを代入する

		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();							//リストを作成
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);												//getCartInfoDtoListメソッドを実行し、代入する
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();											//リストをiterator化する

		if
		(!(iterator.hasNext()))																										//要素が続かなければtrue
		{cartInfoDtoList = null;}																									//nullを代入する

		session.put("cartInfoDtoList", cartInfoDtoList);																//セッション変数化

		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));	//getTotalPriceメソッドを実行し、値を変数totalPriceに代入する

		session.put("totalPrice", totalPrice);																					//セッション変数化

		return result;

	}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getReleaseCompany() {
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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
