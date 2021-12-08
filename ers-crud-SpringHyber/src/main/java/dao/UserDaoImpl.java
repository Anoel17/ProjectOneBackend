package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojo.RequestPojo;
import pojo.UserPojo;
import presentation.HibernateUtil;

public class UserDaoImpl implements UserDao{

	
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
	@Override
	public List<UserPojo> getAllUsers() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from user_info");
		
		List<UserPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}
	
	
	

	@Override
	public UserPojo getUser(int userId) {
		UserPojo output;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		output= session.get(UserPojo.class, userId);
		transaction.commit();
		session.close();
		return output;
	}

	@Override
	public void editUser(int userId, String screenName, String home_state, String home_town, String address) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserPojo unedited = session.get(UserPojo.class, userId);
		unedited.setScreenName(screenName);
		unedited.setHomeState(home_state);
		unedited.setHomeTown(home_town);
		unedited.setAddress(address);
		session.update(unedited);
		transaction.commit();
		session.close();
		
	}




	@Override
	public UserPojo getUserByEmail(String email, String password) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from user_info where email='"+email+"' and password='"+password+"'");
		
		List<UserPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq.get(0);
	}

}
