package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ProductListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ProductListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	ArrayList<ProductListDTO> ProductListDTOList = new ArrayList<ProductListDTO>();

	public ArrayList<ProductListDTO> getProductInfo() throws SQLException{


		String sql = "SELECT * FROM item_info_transaction";  													//sql文を定義

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);				//psにsql文を格納
			ResultSet resultSet = preparedStatement.executeQuery();											//変数rsにsql処理値を格納する

			while(resultSet.next()) {																										//rsにデータが入っていればtrue(客情報があるかないかの判定)

				ProductListDTO DTO = new ProductListDTO();
				DTO.setItemName(resultSet.getString("item_name"));												//ProductListDTOのsetterにrsの値を代入する
				DTO.setItemPrice(resultSet.getString("item_price"));								//ProductListDTOのsetterにrsの値を代入する
				DTO.setItemStock(resultSet.getString("item_stock"));										//ProductListDTOのsetterにrsの値を代入する
				ProductListDTOList.add(DTO);

			}

		}
		catch (Exception e) {e.printStackTrace();}																		//exception定義

		return ProductListDTOList;																													//ProductListDTOを戻り値としてreturn

	}

}
