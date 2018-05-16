package fan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fan.constant.SessionKey;
import fan.service.TeAccountService;
import fan.support.JSONReturn;
import fan.support.RandomValidateCode;

@Controller
public class SupportController {
	
	@Autowired
	private TeAccountService teAccountService;
	
	@RequestMapping(value = "/0/findVerifycode")
	public void findVerifycode(HttpServletRequest request, HttpServletResponse response){
		//生成图形验证码并将图片返回给前台
	    RandomValidateCode.getRandcode(request, response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/0/login")
	public JSONReturn login(@RequestParam String username, @RequestParam String password, @RequestParam String verify,
			HttpServletRequest request , HttpServletResponse response){
		//处理图形验证码的检测
		if(StringUtils.isEmpty(verify)){
			
			return JSONReturn.buildFailure("验证码为空！");
		}
		Object code = request.getSession().getAttribute(SessionKey.VALIDATE_CODE);
		if(verify.equalsIgnoreCase(String.valueOf(code))){
			System.out.println("*************");
			System.out.println(code);
			System.out.println("************");
			return JSONReturn.buildFailure("验证码输入错误！");
		}
		return teAccountService.login(username, password, request);
	}
	
}
