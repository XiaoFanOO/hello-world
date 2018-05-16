package fan.dto;

import java.io.Serializable;

/**
 * 封装下拉菜单数据列表
 * @author cool boy
 *
 */
public class SelectDto implements Serializable{

	private static final long serialVersionUID = 8014461465523543160L;
	
	private long id;
	private String name;
	
	public SelectDto() {
		// TODO Auto-generated constructor stub
	}

	public SelectDto(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SelectDto [id=" + id + ", name=" + name + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
