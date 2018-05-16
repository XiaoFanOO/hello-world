package fan.exception;

import java.io.Serializable;

import javax.validation.constraints.Null;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fan.support.JSONReturn;

public class AssException implements Serializable{

	private static final long serialVersionUID = 6198133878504835436L;
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@ExceptionHandler(NullPointerException.class)
	public  JSONReturn exception(Exception ex){
		ex.printStackTrace();
		return JSONReturn.buildFailure("服务器异常！");
	}

}
