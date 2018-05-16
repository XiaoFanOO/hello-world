package fan.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Asset entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "asset")

public class Asset implements java.io.Serializable {

	private static final long serialVersionUID = 6952379585602123432L;


	private long id;
	private Date timestamp;
	private Date creation;
	private String warranty;
	private Integer exist;
	private String name;
	private long state;
	private long type;
	private String address;
	private String person;
	private String creator;
	private String college;
	private String madetime;
	private String description;
	private String emergency;
	private String note;

	// Constructors

	/** default constructor */
	public Asset() {
	}

	/** minimal constructor */
	public Asset(long state, long type) {
		this.state = state;
		this.type = type;
	}

	/** full constructor */
	public Asset(Date creation, String warranty, Integer exist, String name, long state, long type, String address,
			String person, String creator, String college, String madetime, String description, String emergency,
			String note) {
		this.creation = creation;
		this.warranty = warranty;
		this.exist = exist;
		this.name = name;
		this.state = state;
		this.type = type;
		this.address = address;
		this.person = person;
		this.creator = creator;
		this.college = college;
		this.madetime = madetime;
		this.description = description;
		this.emergency = emergency;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", timestamp=" + timestamp + ", creation=" + creation + ", warranty=" + warranty
				+ ", exist=" + exist + ", name=" + name + ", state=" + state + ", type=" + type + ", address=" + address
				+ ", person=" + person + ", creator=" + creator + ", college=" + college + ", madetime=" + madetime
				+ ", description=" + description + ", emergency=" + emergency + ", note=" + note + "]";
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

	@Column(name = "warranty", length = 20)

	public String getWarranty() {
		return this.warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Column(name = "exist")

	public Integer getExist() {
		return this.exist;
	}

	public void setExist(Integer exist) {
		this.exist = exist;
	}

	@Column(name = "name", length = 256)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "state", nullable = false)

	public long getState() {
		return this.state;
	}

	public void setState(long state) {
		this.state = state;
	}

	@Column(name = "type", nullable = false)

	public long getType() {
		return this.type;
	}

	public void setType(long type) {
		this.type = type;
	}

	@Column(name = "address", length = 60)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "person", length = 20)

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Column(name = "creator", length = 20)

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "college", length = 60)

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Column(name = "madetime", length = 20)

	public String getMadetime() {
		return this.madetime;
	}

	public void setMadetime(String madetime) {
		this.madetime = madetime;
	}

	@Column(name = "description", length = 2048)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "emergency", length = 60)

	public String getEmergency() {
		return this.emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	@Column(name = "note", length = 2048)

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}