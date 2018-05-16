package fan.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import fan.dto.SelectDto;
import fan.dto.SelectTypeDto;
import fan.model.AssetStype;

@Repository
public class AssetTypeDao extends AbstractDao<AssetStype> implements Serializable{
	private static final long serialVersionUID = 8802669483309191923L;
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String EXIST = "exist";
	public static final String CREATOR = "creator";

	
	
	
	@Override
	public Class<AssetStype> getEntityClass() {
		// TODO Auto-generated method stub
		return AssetStype.class;
	}




	@SuppressWarnings("unchecked")
	public List<SelectTypeDto> findSelectType() {
		
		String query = "select new fan.dto.SelectTypeDto(id, name) from AssetStype ";

		return findSession().createQuery(query).list();
	}
	
	

}
