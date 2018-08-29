package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.LoginDTO;
import com.internousdev.webproj4.util.DBConnector;

public class LoginDAO {

	public String username;														//String型変数usernameの定義
	public String password;														//String型変数passwordの定義

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();				//Arraylist型変数LoginDTOの定義

	public List<LoginDTO> select(String username, String password) {			//引数付きselectメソッドの作成

		DBConnector db = new DBConnector();										//dbのインスタンス化
		Connection con = db.getConnection();									//conectionのインスタンス化

		String sql = "select * from users where user_name=? and password=?";	//SQL文の指定 usersテーブルからuser_nameとpasswordカラムを全て所得する

		try {
			PreparedStatement ps = con.prepareStatement(sql);					//psにsql文をコンパイルする

			ps.setString(1, username);											//jspからの値を変数として、sql文の一番目を扱う
			ps.setString(2, password);											//jspからの値を変数として、sql文の二番目を扱う

			ResultSet rs = ps.executeQuery();									//rsにsqlの処理内容を格納する

			while (rs.next()) {													//データがある限りtrueし続ける
				LoginDTO dto = new LoginDTO();									//LoginDTOのインスタンス化
				dto.setUsername(rs.getString("user_name"));						//dtoのsetterにsql文から所得した値を代入する
				dto.setPassword(rs.getString("password"));						//dtoのsetterにsql文から所得した値を代入する
				loginDTOList.add(dto);											//dtoの内容を全て代入する(sqlから所得したものと化す)
			}

			if (loginDTOList.size() <= 0) {										//所得した文のサイズが0以下の場合true
				LoginDTO dto = new LoginDTO();									//LoginDTOのインスタンス化
				dto.setUsername("該当なし");									//dtoのsetterに該当なしを代入する
				dto.setPassword("該当なし");									//dtoのsetterに該当なしを代入する
				loginDTOList.add(dto);											//dtoの内容を全て代入する(該当なしを代入しているようなもの)
			}

		}

		catch (SQLException e) {e.printStackTrace();}							//exception処理
		try {con.close();}														//exception処理
		catch (SQLException e) {e.printStackTrace();}							//exception処理

		return loginDTOList;													//loginDTOlistを戻り値として返す
	}
}