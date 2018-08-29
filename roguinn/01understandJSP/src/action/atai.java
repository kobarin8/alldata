package action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class atai extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private String hatugen;

	public String execute() {

		session.put("hatugenKey", hatugen);
		String result = SUCCESS;
		return result;
	}

//	public String getatai() {return hatugen;}
//	public void setatai(String hatugen) {this.hatugen = hatugen;}

	@Override

	public void setSession(Map<String, Object> session) {this.session = session;}

	public String getHatugen() {return hatugen;}
	public void setHatugen(String hatugen) {this.hatugen = hatugen;}

	public Map<String, Object> getSession() {return session;
	}

}
