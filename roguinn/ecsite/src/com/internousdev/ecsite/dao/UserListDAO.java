package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	ArrayList<UserListDTO> UserList = new ArrayList<UserListDTO>();

	public ArrayList<UserListDTO> getUserInfo() throws SQLException{


		String sql = "SELECT * FROM login_user_transaction";  													//sql文を定義

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);				//psにsql文を格納
			ResultSet resultSet = preparedStatement.executeQuery();											//変数rsにsql処理値を格納する

			while(resultSet.next()) {																										//rsにデータが入っていればtrue(客情報があるかないかの判定)

				UserListDTO DTO = new UserListDTO();
				DTO.setLoginId(resultSet.getString("login_id"));												//ProductListDTOのsetterにrsの値を代入する
				DTO.setLoginPass(resultSet.getString("login_pass"));								//ProductListDTOのsetterにrsの値を代入する
				DTO.setUserName(resultSet.getString("user_name"));										//ProductListDTOのsetterにrsの値を代入する
				DTO.setInsertDate(resultSet.getString("insert_date"));
				UserList.add(DTO);

			}

		}
		catch (Exception e) {e.printStackTrace();}																		//exception定義

		return UserList;																													//ProductListDTOを戻り値としてreturn

	}

}
