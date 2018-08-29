package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {


private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();


public String execute() throws SQLException {

userCreateCompleteDAO.createUser(


session.get("loginUserIdkey").toString(),
session.get("loginPasswordkey").toString(),
session.get("userNamekey").toString()

);

String result = SUCCESS;
return result ;

}


//値受け渡し
private String loginUserId;
private String loginPassword;
private String userName;

public String getLoginUserId() {return loginUserId;}
public void setLoginUserId(String loginUserId) {this.loginUserId = loginUserId;}
public String getLoginPassword() {return loginPassword;}
public void setLoginPassword(String loginPassword) {this.loginPassword = loginPassword;}
public String getUserName() {return userName;}
public void setUserName(String userName) {this.userName = userName;}


public Map<String,Object> session;
@Override
public void setSession(Map<String, Object> session) {this.session = session;}


}