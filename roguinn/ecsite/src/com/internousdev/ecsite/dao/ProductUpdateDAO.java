package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class ProductUpdateDAO extends ActionSupport{



	private DBConnector dbConnector = new DBConnector();															//
	private Connection connection = dbConnector.getConnection();												//

	public void productUpdate(String name, String price, String stock, String kobetu1, String kobetu2, String kobetu3) throws SQLException {

		String sql = "UPDATE item_info_transaction SET item_name =?, item_price =?, item_stock =? WHERE item_name = ?  AND item_price = ? AND item_stock = ?";
//		"UPDATE item_info_transaction SET item_name =?, item_price =?, item_stock =? WHERE item_name = ?  AND item_price = ? AND item_stock = ?";
//		UPDATE item_info_transaction SET item_name ='うまいぼう', item_price ='10', item_stock ='400' WHERE item_name = '33'  AND item_price = '120' AND item_stock = '60';

		PreparedStatement preparedStatement;																					//preparedStatementの変数化

		try {

			preparedStatement = connection.prepareStatement(sql);													//SQL文の実行。値の所得
			preparedStatement.setString(1, name);																				//バインド変数のパラメーター設定
			preparedStatement.setString(2, price);																				//バインド変数のパラメーター設定
			preparedStatement.setString(3, stock);																				//バインド変数のパラメーター設定

			System.out.println("SQLメソッド通過(1)");

			preparedStatement.setString(4, kobetu1);																			//バインド変数のパラメーター設定
			preparedStatement.setString(5, kobetu2);																			//バインド変数のパラメーター設定
			preparedStatement.setString(6, kobetu3);																			//バインド変数のパラメーター設定

			System.out.println("SQLメソッド通過(2)");

			preparedStatement.execute();

			System.out.println("SQL文実行完了");

		}

		catch (SQLException e) {e.printStackTrace();}																		//
		finally {connection.close();}																									//

}








}
