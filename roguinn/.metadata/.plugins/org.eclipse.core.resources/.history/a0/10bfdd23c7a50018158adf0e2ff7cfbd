package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;																					//session変数の定義
	private MyPageDAO myPageDAO = new MyPageDAO();														//DAOをインスタンス化する

	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();				//空のリストmyPageListを定義する

	private String deleteFlg;																										//String変数deleteFlgを定義
	private String message;																										//String型変数messageを定義

//-----------------------------------------------------------------------------------------------------------------------------------------------

	public String execute() throws SQLException {																				//executeメソッドを定義する

		if (!session.containsKey("id")) {return ERROR;}																		//キー名がidのsessinが存在しない場合。errorを返す。
																																							//LoginActionの際に作ったsessionの有無を利用している

		if (deleteFlg == null) {																												//deleteFlgがnullの場合true 商品一覧を表示する

			String item_transaction_id = session.get("id").toString();													//バインド変数の為の定義？
			String user_master_id = session.get("login_user_id").toString();										//バインド変数の為の定義？
			myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);		//sql文で所得したリスト表を代入する
		}

		else if (deleteFlg.equals("1")) {delete();}																					//deleteFlgが1ならtrue deleteメソッドをreturnする

		String result = SUCCESS;																											//String型変数resultにSUCCESSを定義する
		return result;																																//resultを戻り値としてreturnする
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------

	public void delete() throws SQLException {																					//deleteメソッドを定義する

		String item_transaction_id = session.get("id").toString();														//バインド変数の為の定義？
		String user_master_id = session.get("login_user_id").toString();											//バインド変数の為の定義？
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);				//returnされた削除数の値を代入する

		if (res > 0) {																		//resが0以上の場合true
			myPageList = null;															//myPageListをnullにする
			setMessage("商品情報を正しく削除しました。");						//setMessageに文章を代入する
		}

		else if (res == 0) {																//resが0と等しい時true
			setMessage("商品情報の削除に失敗しました。");						//setMessageに文章を代入する
		}

	}

//-----------------------------------------------------------------------------------------------------------------------------------------------

	public void setDeleteFlg(String deleteFlg) {this.deleteFlg = deleteFlg;}						//

	@Override

	public void setSession(Map<String, Object> session) {this.session = session;}			//

	public ArrayList<MyPageDTO> getMyPageList() {return this.myPageList;}					//

	public String getMessage() {return this.message;}														//
	public void setMessage(String message) {this.message = message;}							//

}

//-----------------------------------------------------------------------------------------------------------------------------------------------

//今回のsql文の処理は、特定のものを指定して行うものであり、特にログインしている人の情報を限定いて