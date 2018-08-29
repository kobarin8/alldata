package com.internousdev.webproj2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class TestDAO {

	public int insert(String username, String password) {					//引数を指定する

		int ret = 0;														//ローカル変数を定義

		DBConnector db = new DBConnector();									//インスタンス化

		Connection con = db.getConnection();								//代入

		String sql = "insert into users(user_name, password) values(?,?)";	//sql文定義

		try {																//try文の定義

			PreparedStatement ps = con.prepareStatement(sql);				//変数psにsql文のリストを代入

			ps.setString(1, username);										//指定した引数をsql文に代入する

			ps.setString(2, password);										//指定した引数をsql文に代入する

			int i = ps.executeUpdate();										//int型の変数iを定義しつつ、sqlを更新する際の数を代入する(今回の場合は1)数というのはテーブルの行数

			if (i > 0) {													//変数iは0以上か
				System.out.println(i + "件登録されました");					//変数iを代入し、sysoを実行する
				ret = i;													//変数retにiの値を代入する
			}
		}

																			//exception定義
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	return ret;																//returnでretの値を値として返す(今回の場合、int型変数countの値となる)

	}
}