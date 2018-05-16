package fan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.EnterpriseBean;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.StringUtils;
import fan.constant.SessionKey;
import fan.constant.db.TeAccountState;
import fan.constant.db.TeAccountType;
import fan.dao.TeAccountDao;
import fan.model.TeAccount;
import fan.service.TeAccountService;
import fan.support.JSONReturn;
import fan.utils.EncryptUtil;
import fan.utils.Logable;;


//在spring-context.xml中配置了通过注解开发的模式，所以service层类要注解 “trainsactional”

@Service
@Transactional
public class TeAccountServiceImpl implements TeAccountService {

	@Autowired
	private TeAccountDao teAccountDao;

	
	public JSONReturn login(String username, String password, HttpServletRequest request) {
		
		//检测用户名和密码是否为空		
		if(org.apache.commons.lang.StringUtils.isEmpty(username) || org.apache.commons.lang.StringUtils.isEmpty(password)){
			return JSONReturn.buildFailure("非法操作！");
		}
		
		TeAccount account = teAccountDao.findUniqueByProperty(teAccountDao.USERNAME, username);
		if(account == null){
			//数据不存在，说明用户名都不对
		//	error("");
			return JSONReturn.buildFailure("帐号或密码不正确！");
		}
		//通过密码检测传入的密码是否正确
		if(!account.getPassword().equals(EncryptUtil.md5(password))){
			return JSONReturn.buildFailure("帐号或密码不正确！");
		}
		
		request.getSession().setAttribute(SessionKey.LOGIN_USER_INFO, account);
		
		return JSONReturn.buildSuccessWithEmptyBody(null);
	}

	
	
	
	

	
}
