package fan.utils;

import org.apache.commons.lang.StringUtils;

public class QueryUtil {
	public static String packLink(String key){
		key = StringUtils.isEmpty(key) ? "" : key;
		return new StringBuffer().append("%").append("%").toString();
	}

}
