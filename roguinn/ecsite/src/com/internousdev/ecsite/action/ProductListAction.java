package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ProductListDAO;
import com.internousdev.ecsite.dto.ProductListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport{

	private ProductListDAO productListDAO = new ProductListDAO();														//DAOインスタンス
	ArrayList<ProductListDTO> ProductListDTOList = new ArrayList<ProductListDTO>();

	public String execute() throws SQLException {

		ProductListDTOList=productListDAO.getProductInfo();

		return SUCCESS;

		}

	public ProductListDAO getProductListDAO() {
		return productListDAO;
	}

	public void setProductListDAO(ProductListDAO productListDAO) {
		this.productListDAO = productListDAO;
	}

	public ArrayList<ProductListDTO> getProductListDTOList() {
		return ProductListDTOList;
	}

	public void setProductListDTOList(ArrayList<ProductListDTO> productListDTOList) {
		ProductListDTOList = productListDTOList;
	}

}

