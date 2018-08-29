package com.internousdev.webproj3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj3.dto.LoginDTO;
import com.internousdev.webproj3.util.DBConnector;

public class LoginDAO {

	public String username;														//String型変数usernameの定義
	public String password;														//String型変数passwordの定義

	public LoginDTO select(String username, String password) {					//selectメソッドの定義をし、引数を指定する

		DBConnector db = new DBConnector();										//dbConnectorのインスタンス化

		Connection con = db.getConnection();									//

		LoginDTO dto = new LoginDTO();											//DTOのインスタンス化

		String sql = "select * from users where user_name=? and password=?";	//usersテーブルのuser_name、passwordカラムから全ての値を所得するSQL文を指定する。
																				//今回の場合、sql文にはバインド変数が使われている。(同じ値の要求をしなくてすむ変数の事。)

		try {

			PreparedStatement ps = con.prepareStatement(sql);					//preparedStatementを使い、SQL文を実行し、全値を所得する

			ps.setString(1, username);											//引数をSQL文にセットする。
			ps.setString(2, password);											//引数をSQL文にセットする。

			ResultSet rs = ps.executeQuery();									//

			if (rs.next()) {													//SQL文があればtrueの処理文
				dto.setUsername(rs.getString("user_name"));						//DTOのsetterにuser_nameのフィールドを代入する
				dto.setPassword(rs.getString("password"));						//DTOのsetterにpasswordのフィールドを代入する
			}

			else {																//falseの場合を定義
				dto.setUsername("該当なし");									//DTOのsetterに該当なしを代入する
				dto.setPassword("該当なし");									//DTOのsetterに該当なしを代入する
			}

		}
																				//excption定義
		catch (SQLException e) {e.printStackTrace();}

		try {con.close();}

		catch (SQLException e) {e.printStackTrace();}

		return dto;																//dtoを戻り値としてreturnする

	}
}