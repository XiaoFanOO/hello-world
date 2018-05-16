package fan.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * AssetState entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "asset_state")

public class AssetState implements java.io.Serializable {
	private static final long serialVersionUID = 2723473312704107239L;
	
	private long id;
	private Date timestamp;
	private Date creation;
	private String name;
	private String description;
	private Integer exist;
	private String creator;

	// Constructors

	/** default constructor */
	public AssetState() {
	}

	/** full constructor */
	public AssetState(Date creation, String name, String description, Integer exist, String creator) {
		this.creation = creation;
		this.name = name;
		this.description = description;
		this.exist = exist;
		this.creator = creator;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "id", unique = true, nullable = false)

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "AssetState [id=" + id + ", timestamp=" + timestamp + ", creation=" + creation + ", name=" + name
				+ ", description=" + description + ", exist=" + exist + ", creator=" + creator + "]";
	}

	@Version
	@Column(name = "timestamp", nullable = false, length = 19)

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "creation", length = 19)

	public Date getCreation() {
		return this.creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	@Column(name = "name", length = 512)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 1024)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "exist")

	public Integer getExist() {
		return this.exist;
	}

	public void setExist(Integer exist) {
		this.exist = exist;
	}

	@Column(name = "creator", length = 512)

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}