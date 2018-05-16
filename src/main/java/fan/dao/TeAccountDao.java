package fan.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fan.model.TeAccount;;

@Repository
public class TeAccountDao extends AbstractDao<TeAccount>{
	
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String STATE = "state";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String NICKNAME = "nickname";
	public static final String CREATOR = "creator";
	
	
	
	@Override
	public Class<TeAccount> getEntityClass() {
		// TODO Auto-generated method stub
		return TeAccount.class;
	}

}
