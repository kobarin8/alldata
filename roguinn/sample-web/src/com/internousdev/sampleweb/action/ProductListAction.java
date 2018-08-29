package com.internousdev.sampleweb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb.dao.MCategoryDAO;
import com.internousdev.sampleweb.dao.ProductInfoDAO;
import com.internousdev.sampleweb.dto.MCategoryDTO;
import com.internousdev.sampleweb.dto.PaginationDTO;
import com.internousdev.sampleweb.dto.ProductInfoDTO;
import com.internousdev.sampleweb.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware{

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;

	private String categoryId;
	private String keywords;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		ProductInfoDAO productInfoDao = new ProductInfoDAO();											//商品情報所得
		productInfoDtoList = productInfoDao.getProductInfoList();



		Pagination pagination = new Pagination();																	//ページ分け
		PaginationDTO paginationDTO = pagination.initialize(productInfoDtoList, 9);

		session.put("totalPageSize", paginationDTO.getTotalPageSize());								//9
		session.put("currentPageNumber", paginationDTO.getCurrentPageNo());					//1
		session.put("totalRecordSize", paginationDTO.getTotalPageSize());							//9
		session.put("startRecordNo", paginationDTO.getStartRecordNo());								//0
		session.put("endRecordNo", paginationDTO.getEndRecordNo());									//8
		session.put("pageNumberList", paginationDTO.getPageNumberList());						//1~9
		session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());		//0~8

		//has get は同じ内容(真偽boolean型)

		session.put("hasNextPage", paginationDTO.hasNextPage());										//true
		session.put("hasPreviousPage", paginationDTO.hasPreviousPage());							//false

		session.put("nextPageNo", paginationDTO.getNextPageNo());										//true
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());						//false

		if(!session.containsKey("mCategoryList"))
		{
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();

			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		result = SUCCESS;
		return result;

	}



















	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
