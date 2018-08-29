package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO();
//--------------------------------------------------------------------------------------------------------
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ? AND login_pass = ?";  //sql文を定義

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);				//psにsql文を格納
			preparedStatement.setString(1, loginUserId);																//バインド変数を定義する
			preparedStatement.setString(2, loginPassword);															//バインド変数を定義する
			ResultSet resultSet = preparedStatement.executeQuery();											//変数rsにsql処理値を格納する

			if (resultSet.next()) {																										//rsにデータが入っていればtrue(客情報があるかないかの判定)

				loginDTO.setLoginId(resultSet.getString("login_id"));												//LoginDTOのsetterにrsの値を代入する
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));								//LoginDTOのsetterにrsの値を代入する
				loginDTO.setUserName(resultSet.getString("user_name"));										//LoginDTOのsetterにrsの値を代入する

				if (!(resultSet.getString("login_id").equals(null))) {													//rsのlogin_idの値がnullでなければtrue(客情報が存在すればtrue)

					loginDTO.setLoginFlg(true);																					//LoginDTOのsetterの値をtrueにする

				}

			}

		}
		catch (Exception e) {e.printStackTrace();}																		//exception定義

		return loginDTO;																													//loginDTOを戻り値としてreturn

	}
//--------------------------------------------------------------------------------------------------------
	public LoginDTO getLoginDTO() {return loginDTO;}												//

}