package com.internousdev.webproj3.dto;

public class LoginDTO {

	private String username;												//getter setterのためのprivate変数を定義
	private String password;												//getter setterのためのprivate変数を定義

	public String getUsername() {return username;}							//setterから送られた値をDTOのprivate変数を通してgetterとして代入されている
	public void setUsername(String username) {this.username = username;}	//DAOから送られた値を引数とし、DTO内の変数に代入している

	public String getPassword() {return password;}							//setterから送られた値をDTOのprivate変数を通してgetterとして代入されている
	public void setPassword(String password) {this.password = password;}	//DAOから送られた値を引数とし、DTO内の変数に代入している

}