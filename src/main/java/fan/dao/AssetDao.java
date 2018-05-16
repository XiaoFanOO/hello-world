package fan.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import fan.dao.AbstractDao;
import fan.model.Asset;

@Repository
public class AssetDao extends AbstractDao<Asset> implements Serializable{

	private static final long serialVersionUID = -12357805888637141L;

	public static final String ID = "id";
	public static final String EXIST = "exist";
	public static final String NAME = "name";
	public static final String STATE = "state";
	public static final String TYPE = "type";
	public static final String ADDRESS = "address";
	public static final String PERSON = "person";
	public static final String CREATOR = "creator";
	public static final String COLLEGE = "college";
	public static final String DESCRIPTION = "description";
	public static final String EMERGENCY = "emergency";
	public static final String NOTE = "note";
	
	@Override
	public Class<Asset> getEntityClass() {
		// TODO Auto-generated method stub
		return Asset.class;
	}

}
