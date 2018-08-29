package com.internousdev.webproj2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class HelloStrutsDAO {

//retの中身を決めるプログラム
//基本的にbooleanのfalseとtrueを決めるもの

	public boolean select() {

		boolean ret=false; //boolean型のretはfalse

		DBConnector db = new DBConnector();//dbconnectorのインスタンス化
		Connection con = db.getConnection();//

		String sql = "select * from users";//sql文 usersテーブルから全ての値を所得する

		try {
			PreparedStatement ps = con.prepareStatement(sql);//sql文の所得
			ResultSet rs = ps.executeQuery();//prearedStatementからのsql文のコンストラクタ化

			if (rs.next()) {//sql文の有無を条件文にしている
				ret=true;//boolean型のretの値をtrueに
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			con.close();

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return ret;

	}
}