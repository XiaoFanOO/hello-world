package fan.utils;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import antlr.StringUtils;


public class EncryptUtil implements Serializable{

	
	private static final long serialVersionUID = -6118701475577061803L;
	
	/**
	 * md5加密字符串 
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		if(org.apache.commons.lang.StringUtils.isEmpty(str)){
			return "";
		}
		return DigestUtils.md5Hex(str);
	}
	

}
