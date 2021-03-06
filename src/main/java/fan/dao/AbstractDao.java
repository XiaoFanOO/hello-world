package fan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session findSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public abstract Class<T> getEntityClass();
	
	//根据ID号获取某条数据
	@SuppressWarnings("unchecked")
	public T findById(long id){
		return (T) findSession().get(getEntityClass().getName(), id);
	}
	
	//将某个对象保存到数据库
	public void save(T t){
		findSession().save(t);
	}
	
	//删除数据库中的某条书籍
	public void delete(T t){
		findSession().delete(t);
	}
	
	//修改对象
	public void update(T t){
		findSession().update(t);
	}
	
	//获取某张数据表的所有数据
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return findSession().createCriteria(getEntityClass()).list();
	}
	
	//传入制定的字段名及值，获取唯一的一条数据对象
	@SuppressWarnings("unchecked")
	public T findUniqueByProperty(String key, Object val){
		String query = "from " + getEntityClass().getName() + " where " + key + " = '" + val.toString() + "'";
		return (T) findSession().createQuery(query).uniqueResult();
				
	}
	
	//传入制定的字段名及值，获取一个数据列表
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String key, Object val){
		String query = "from " + getEntityClass().getName() + " where " + key + " = '" + val.toString() + "'";
		return findSession().createQuery(query).list();
				
	}
	
	//获取某张数据表的数量
	public int findCount(){
		String queyr = "select count(*) from " + getEntityClass().getName();
		return Integer.parseInt(findSession().createQuery(queyr).uniqueResult().toString());
	}
	
	//根据制定的字段名及值，获取数量
	public int findCountByProperty(String key, Object val){
		String query = "select count(*) from " + getEntityClass().getName() + " where " + key + " = '" + val + "'";
		return Integer.parseInt(findSession().createQuery(query).uniqueResult().toString());
	}

}
