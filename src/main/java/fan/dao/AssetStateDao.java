package fan.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import fan.dto.SelectDto;
import fan.model.AssetState;
import fan.utils.QueryUtil;

@Repository
public class AssetStateDao extends AbstractDao<AssetState> implements Serializable {

	private static final long serialVersionUID = 1697950972893183072L;

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String EXIST = "exist";
	public static final String CREATOR = "creator";
	@Override
	public Class<AssetState> getEntityClass() {
		// TODO Auto-generated method stub
		return AssetState.class;
	}

	@SuppressWarnings("unchecked")
	public List<AssetState> findAssetStateList(String search, int page, int line) {
		if(StringUtils.isEmpty(search)){
			String query = "from AssetState order by id desc";
			return findSession().createQuery(query)
					.setFirstResult((page-1) * line).setMaxResults(line).list();
		}
		String query = "from AssetState where name like ? order by id desc";
		return findSession().createQuery(query).setString(0, QueryUtil.packLink(search))
				.setFirstResult((page-1) * line).setMaxResults(line).list();
		
	}

	@SuppressWarnings("unchecked")
	public List<SelectDto> findSelectState() {

		String query = "select new fan.dto.SelectDto(id, name) from AssetState ";
		
		return findSession().createQuery(query).list();
	}
	
	

}
