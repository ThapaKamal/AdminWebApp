/**
 * LoginDAOImp.java
 * @author Kamal Thapa(KT)
 * @Created Jan 16, 2018
 * 
 */
package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginDAOImpl implements LoginDAO{


	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public boolean checklogin(String username, String pass) {

		System.out.println("Checking Login..");
		Session session=sessionFactory.openSession();
		boolean userFound=false;
		
		//HQL
		String login_query="from users as o where o.username=? and o.pass=?";
		Query query=session.createQuery(login_query);
		query.setParameter(0, username);
		query.setParameter(1, pass);
		List list=query.list();
		
		if( (list!=null) && (list.size()>0)) {
			userFound=true;
		}
		session.close();
		return userFound;
	}

}
