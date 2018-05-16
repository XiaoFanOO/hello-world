package fan.dto;

import java.io.Serializable;

public class SelectTypeDto implements Serializable{
	private static final long serialVersionUID = 4661892327922851788L;
	
	private long id;
	private String name;
	
	public SelectTypeDto() {
		// TODO Auto-generated constructor stub
	}

	public SelectTypeDto(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "SelectTypeDto [id=" + id + ", name=" + name + "]";
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
