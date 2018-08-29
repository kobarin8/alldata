package dao;
import java.sql.Connection;
//--------------------------------------------------------------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class toukouDAO{

private DBConnector dbConnector = new DBConnector();
private Connection connection = dbConnector.getConnection();
private DateUtil dateUtil = new DateUtil();


private String sql = "INSERT INTO hatugenTABLE (hatugenVALUE, insert_date) VALUES(?, ?)";

public void createUser(String setkey) throws SQLException {

try {

PreparedStatement

preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, setkey);
preparedStatement.setString(2, dateUtil.getDate());
preparedStatement.execute();

}

catch(Exception e) {e.printStackTrace();}
finally {connection.close();}

}

}