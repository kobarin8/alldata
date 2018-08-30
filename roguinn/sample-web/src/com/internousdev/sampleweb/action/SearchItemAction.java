package com.internousdev.sampleweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb.dao.MCategoryDAO;
import com.internousdev.sampleweb.dao.ProductInfoDAO;
import com.internousdev.sampleweb.dto.MCategoryDTO;
import com.internousdev.sampleweb.dto.PaginationDTO;
import com.internousdev.sampleweb.dto.ProductInfoDTO;
import com.internousdev.sampleweb.util.InputChecker;
import com.internousdev.sampleweb.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private String pageNo;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		InputChecker inputChecker = new InputChecker();

		if
		(keywords==null)
		{keywords="";}

		keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false,true,true);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();

		switch
		(categoryId)
		{
			case "1"://replaceallとsplitを使って単語検索の際に付いた全角スペースを、半角スペースに置換し、splitで半角スペースごとに単語を切り分け、配列化する。
				productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
				result = SUCCESS;
				break;

			default:
				productInfoDtoList = productInfoDAO.getProductInfoListByKeywords(keywords.replaceAll("　", " ").split(" "), categoryId);
				result = SUCCESS;
				break;
		}

		System.out.println("categoryIdは"+categoryId+"です");
		System.out.println("keywordsは"+keywords+"です");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();

		if																																				//
		(!(iterator.hasNext()))																											//リストの要素が続かない場合
		{productInfoDtoList = null;}																									//リストを空っぽにする
		session.put("keywordsErrorMessageList", keywordsErrorMessageList);								//


		if(!session.containsKey("mCategoryList"))																			//
		{
		MCategoryDAO mCategoryDao = new MCategoryDAO();														//
		mCategoryDtoList = mCategoryDao.getMCategoryList();														//
		session.put("mCategoryDtoList", mCategoryDtoList);															//
		}


		if(!(productInfoDtoList==null))																								//listがあるならtrue
		{
		Pagination pagination = new Pagination();																		//paginationのインスタンス化
		PaginationDTO paginationDTO = new PaginationDTO();													//paginationのインスタンス化

			if
			(pageNo==null)																													//ページ数がない場合
			{paginationDTO = pagination.initialize(productInfoDtoList, 9);}										//initiliazeメソッドを実行する

					else
					{paginationDTO = pagination.getPage(productInfoDtoList, 9, pageNo);}						//getpageメソッドを実行する

					session.put("productInfoDtoList", 	paginationDTO.getCurrentProductInfoPage());			//レコードリストの作成

					session.put("totalPageSize", 			paginationDTO.getTotalPageSize());							//総ページ数の作成

					session.put("currentPageNo", 		paginationDTO.getCurrentPageNo());						//現在のページの作成

					session.put("totalRecordSize", 		paginationDTO.getTotalRecordSize());						//レコードの幅を作製

					session.put("startRecordNo", 		paginationDTO.getStartRecordNo());							//レコードの始まりを指定
					session.put("endRecordNo", 			paginationDTO.getEndRecordNo());							//レコードの終わりを指定

					session.put("previousPage", 			paginationDTO.hasPreviousPage());							//前項の有無を判定
					session.put("previousPageNo", 		paginationDTO.getPreviousPageNo());						//前項の有無を真偽で判定
					session.put("nextPage", 					paginationDTO.hasNextPage());									//次項の有無を判定
					session.put("nextPageNo", 			paginationDTO.getNextPageNo());								//次項の有無を真偽で判定

		}

			else {session.put("productInfoDtoList", null);}		//リストを空っぽにしてエラーメッセージを出すようにしている																//

		return result;																															//

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public String getPageNo() {
		return pageNo;
	}


	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}


	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
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
	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}
	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
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
