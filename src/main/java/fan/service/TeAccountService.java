package fan.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fan.model.TeAccount;
import fan.support.JSONReturn;

public abstract interface TeAccountService {


	public abstract JSONReturn login(String username, String password, HttpServletRequest request);
	
	
}
