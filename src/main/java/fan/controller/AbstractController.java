package fan.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import fan.constant.SessionKey;
import fan.model.TeAccount;

public class AbstractController implements Serializable{

	private static final long serialVersionUID = -3890539455156952689L;
	
	public String acctName (HttpServletRequest request){
		try {
			TeAccount account = (TeAccount) request.getSession().getAttribute(SessionKey.LOGIN_USER_INFO);
		    return account == null ? "" : account.getUsername();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
