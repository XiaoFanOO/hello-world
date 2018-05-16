package fan.utils;

import java.io.Serializable;

import fan.dto.PageDto;

/**
 * 分页工具类
 * @author cool boy
 *
 */
public class PageUtil implements Serializable{


	private static final long serialVersionUID = -5312003865943883443L;
	
	public static PageDto pack(int size, int count, int page){
		PageDto dto = new PageDto();
		dto.setSize(size);
		dto.setCurrent(page);
		dto.setCount(count);
		
		//计算总页数
		if(count % size > 0){
			dto.setTotal(count / size + 1);
		}else{
			dto.setTotal(count / size);
		}
		return dto;
	}

}
