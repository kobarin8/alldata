package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{

	private UserListDAO UserListDAO = new UserListDAO();														//DAOインスタンス
	ArrayList<UserListDTO> UserList = new ArrayList<UserListDTO>();

	public String execute() throws SQLException {

		UserList=UserListDAO.getUserInfo();

		return SUCCESS;

		}

	public UserListDAO getUserListDAO() {
		return UserListDAO;
	}

	public void setUserListDAO(UserListDAO userListDAO) {
		UserListDAO = userListDAO;
	}

	public ArrayList<UserListDTO> getUserList() {
		return UserList;
	}

	public void setUserList(ArrayList<UserListDTO> userList) {
		UserList = userList;
	}






}

