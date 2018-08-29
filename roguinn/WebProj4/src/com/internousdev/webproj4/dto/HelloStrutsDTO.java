package com.internousdev.webproj4.dto;
public class HelloStrutsDTO {

private int userId;														//getter setter用のフィールド変数の定義
private String userName;												//getter setter用のフィールド変数の定義
private String password;												//getter setter用のフィールド変数の定義
private String result;													//getter setter用のフィールド変数の定義

public int getUserId() {return userId;}									//getter
public void setUserId(int userId) {this.userId = userId;}				//setter

public String getUserName() {return userName;}							//getter
public void setUserName(String userName) {this.userName = userName;}	//setter

public String getPassword() {return password;}							//getter
public void setPassword(String password) {this.password = password;}	//setter

public String getResult() {return result;}								//getter
public void setResult(String result) {this.result = result;}			//setter

//DTOはgetterを作成し、他のクラスへ値を送るもの

}