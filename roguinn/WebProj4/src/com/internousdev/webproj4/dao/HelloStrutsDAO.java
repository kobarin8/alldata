package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.HelloStrutsDTO;
import com.internousdev.webproj4.util.DBConnector;

public class HelloStrutsDAO {

	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();		//配列を定義する

	public List<HelloStrutsDTO> select() {											//selectメソッドを定義する

		DBConnector db = new DBConnector();											//dbcnnectorをインスタンス化する
		Connection con = db.getConnection();										//

		String sql = "select * from users";											//usersテーブルの全ての要素を初頭するsql文を定義する

		try{																		//このメソッドの実行している事の全て

			PreparedStatement ps = con.prepareStatement(sql);						//sql文を変数psに代入しつつ、conを利用し、sqlのデータを所得する
			ResultSet rs = ps.executeQuery();										//変数rsを指定しつつ、sqlのデータを格納していく

			while (rs.next()) {														//DBのデータが存在すればtrue

				HelloStrutsDTO dto = new HelloStrutsDTO();							//dtoをインスタンス化する

				dto.setUserId(rs.getInt("user_id"));								//dtoのsetterにsql文の値を格納していく
				dto.setUserName(rs.getString("user_name"));							//dtoのsetterにsql文の値を格納していく
				dto.setPassword(rs.getString("password"));							//dtoのsetterにsql文の値を格納していく
				dto.setResult("MySQL と接続できます。");							//dtoのsetterに文章を格納していく

				helloStrutsDTOList.add(dto);										//配列に埋め込んでいく
			}

		}
																					//exception定義
		catch (SQLException e) {e.printStackTrace();}
		try {con.close();}
		catch (SQLException e) {e.printStackTrace();}

		return helloStrutsDTOList;													//戻り値としてlistをreturnする
	}

}