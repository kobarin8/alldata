package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
//--------------------------------------------------------------------------------------------------------------
private String loginUserId1;
private String loginPassword;
private String userName;
public Map<String,Object> session;
private String errorMassage;
//--------------------------------------------------------------------------------------------------------------
public String getLoginUserId() {return loginUserId1;}
public void setLoginUserId(String loginUserId) {this.loginUserId1 = loginUserId;}

public String getLoginPassword() {return loginPassword;}
public void setLoginPassword(String loginPassword) {this.loginPassword = loginPassword;}
public String getUserName() {return userName;}
public void setUserName(String userName) {this.userName = userName;}
//--------------------------------------------------------------------------------------------------------------
public String execute() {

String result = SUCCESS;

if(
!(loginUserId1.equals(""))
&&
!(loginPassword.equals(""))
&&
!(userName.equals(""))
) {

session.put("loginUserIdkey", loginUserId1);

session.put("loginPasswordkey", loginPassword);

session.put("userNamekey", userName);}

else {setErrorMassage("未入力の項目があります。"); result = ERROR;}

return result;

}
//--------------------------------------------------------------------------------------------------------------

@Override

public void setSession(Map<String, Object> session) {this.session = session;}

public String getErrorMassage() {return errorMassage;}
public void setErrorMassage(String errorMassage) {this.errorMassage = errorMassage;}

}