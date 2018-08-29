package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.util.DBConnector;

import dto.kakuninDTO;

public class kakuninDAO {

private DBConnector dbConnector = new DBConnector();
private Connection connection = dbConnector.getConnection();

public kakuninDTO getkakuninInfo(){

	String sql ="SELECT hatugenVALUE FROM hatugentable";
	kakuninDTO kakuninDTO = new kakuninDTO();
	try {

	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet resultSet = preparedStatement.executeQuery();//()内にsql文が入っている

	if(resultSet.next()) {

	kakuninDTO.setKakunin(resultSet.getString("hatugenVALUE"));
	}

}

catch(Exception e){
	e.printStackTrace();
}
	return kakuninDTO;
}

}