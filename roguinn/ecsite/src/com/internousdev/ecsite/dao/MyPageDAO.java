package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();															//
	private Connection connection = dbConnector.getConnection();												//

//-----------------------------------------------------------------------------------------------------------------------------------------------
	public ArrayList<MyPageDTO> getMyPageUserInfo																	//

	(String item_transaction_id, String user_master_id) throws SQLException {							//

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();								//
		String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY insert_date DESC";

//		String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date "
//			            + "FROM user_buy_item_transaction ubit"
//				        + "LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id"
//				        + "WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ?"
//				        + "ORDER BY insert_date DESC";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);					//sql文のコンパイル
			preparedStatement.setString(1, item_transaction_id);														//バインド変数のパラメーター設定
			preparedStatement.setString(2, user_master_id);																//バインド変数のパラメーター設定

			ResultSet resultSet = preparedStatement.executeQuery();												//sql文の処理結果をresulsetに代入する

			while (resultSet.next()) {																									//sql文の行がある限りtrue

				MyPageDTO dto = new MyPageDTO();																			//dtoのインスタンス化
				dto.setId(resultSet.getString("id"));																				//引数を用いてdtoのsetterに代入
				dto.setItemName(resultSet.getString("item_name"));													//引数を用いてdtoのsetterに代入
				dto.setTotalPrice(resultSet.getString("total_price"));													//引数を用いてdtoのsetterに代入
				dto.setTotalCount(resultSet.getString("total_count"));													//引数を用いてdtoのsetterに代入
				dto.setPayment(resultSet.getString("pay"));																	//引数を用いてdtoのsetterに代入
				dto.setInsert_date(resultSet.getString("insert_date"));												//引数を用いてdtoのsetterに代入
				myPageDTO.add(dto);																										//list型mypageDTOにリスト値を代入する

			}

		}

		catch (Exception e) {e.printStackTrace();}																			//exception定義
		finally {connection.close();}																									//DBの接続解除
		return myPageDTO;																													//myPageDTOを戻り値としてreturn

	}
//-----------------------------------------------------------------------------------------------------------------------------------------------

	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException {
																																						//メソッドの定義
		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";
																																						//SQL文の定義
		PreparedStatement preparedStatement;																					//preparedStatementの変数化

		int result = 0;																															//int型変数resultの定義と、定数0の代入

		try {

			preparedStatement = connection.prepareStatement(sql);													//SQL文の実行。値の所得
			preparedStatement.setString(1, item_transaction_id);														//バインド変数のパラメーター設定
			preparedStatement.setString(2, user_master_id);																//バインド変数のパラメーター設定

			result = preparedStatement.executeUpdate();																	//SQLを実行し、戻り値（処理した件数）を変数に代入する

		}

		catch (SQLException e) {e.printStackTrace();}																		//
		finally {connection.close();}																									//
		return result;																															//

	}

}