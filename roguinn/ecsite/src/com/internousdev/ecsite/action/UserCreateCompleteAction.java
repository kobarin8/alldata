package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
public Map<String,Object> session;

public String execute() throws SQLException {

userCreateCompleteDAO.createUser(
session.get("loginUserIdkey").toString(),
session.get("loginPasswordkey").toString(),
session.get("userNamekey").toString()
);

String result = SUCCESS;
return result ;

}

@Override
public void setSession(Map<String, Object> session) {this.session = session;}


}