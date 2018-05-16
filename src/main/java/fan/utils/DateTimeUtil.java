package fan.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

import fan.constant.TimeFormatConstant;

/**
 * 时间工具类
 * @author cool boy
 *
 */
public class DateTimeUtil implements Serializable{

	private static final long serialVersionUID = 3802575581908013326L;
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date getCurrentTime(){
		return new Date();
	}
	
	//将Date转化为字符串
	public static String dateTOString(Date date ,String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 将日期格式的字符串转化为时间
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date stringToDate(String dateStr, String format){
		try {
			return new SimpleDateFormat(format).parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCurrentTime();
	}
	
	

}
