package action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.kakuninDAO;
import dto.kakuninDTO;

public class kakunin extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String execute(){

		kakuninDAO kakuninDAO = new kakuninDAO();

		kakuninDTO kakuninDTO = kakuninDAO.getkakuninInfo();



		session.put("kakuninkey", kakuninDTO.getKakunin());

		String result = SUCCESS;

		return result;

}

@Override
public void setSession(Map<String, Object> session){
	this.session = session;}

public Map<String, Object> getSession() {
	return session;}


}
