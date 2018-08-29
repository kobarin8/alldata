package action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.toukouDAO;

public class toukou extends ActionSupport implements SessionAware {

private toukouDAO toukouDAO = new toukouDAO();
public Map<String,Object> session;

public String execute() throws SQLException {

toukouDAO.createUser(
session.get("hatugenKey").toString()
);




return SUCCESS;

}

@Override
public void setSession(Map<String, Object> session) {this.session = session;}

public Map<String, Object> getSession() {return session;}

}
