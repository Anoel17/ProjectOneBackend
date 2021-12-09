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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javassist.bytecode.Descriptor.Iterator;
import pojo.RequestPojo;
import presentation.HibernateUtil;

public class RequestDaoImpl implements RequestDao {

	private static final Logger logger = LogManager.getLogger(RequestDaoImpl.class);
	
	public RequestDaoImpl() {
		
	}
	
	@Override
	public void createRequest(int userId, String date, int amount) {
		RequestPojo rP = new RequestPojo(userId, date, amount, "pending");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(rP);
		transaction.commit();
		session.close();
	}




	@Override
	public List<RequestPojo> getRequestsForUser(int userId) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where user_id="+userId);
		
		List<RequestPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}
		
	


	@Override
	public List<RequestPojo> getAllRequests() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info", RequestPojo.class);
		
		List<RequestPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}


	@Override
	public void deleteRequest(int rID) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		RequestPojo unedited = session.get(RequestPojo.class, rID);
		unedited.setStatus("deleted");
		session.update(unedited);
		transaction.commit();
		session.close();
	}




	@Override
	public List<RequestPojo> getPendingRequests() {
	
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where status='pending'");
		
		List<RequestPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}




	@Override
	public List<RequestPojo> getResolvedRequests() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where status='approved' or status='denied'");
		
		List<RequestPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}




	@Override
	public void updateRequest(int rID, String status) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		RequestPojo unedited = session.get(RequestPojo.class, rID);
		unedited.setStatus(status);
		session.update(unedited);
		transaction.commit();
		session.close();
	}
		
	


//select * from request_info where user_id=1 and status='rejected' or user_id=1 and status='approved';


	@Override
	public List<RequestPojo> getUserResolved(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where user_id=" + userId + "and status='approved' or user_id="+userId+"and status='denied");
		
		List<RequestPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}




	@Override
	public List<RequestPojo> getUserPending(int userId) {
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where user_id="+userId+" and status='pending'");
		
		List<RequestPojo> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
		
	}
}
