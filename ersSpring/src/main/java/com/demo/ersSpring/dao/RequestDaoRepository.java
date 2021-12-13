package com.demo.ersSpring.dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ersSpring.HibernateUtil;
import com.demo.ersSpring.entity.Request;

@Repository
public interface RequestDaoRepository extends JpaRepository<Request,Integer>{

	public default List<Request> getPendingRequests() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where status='pending'");
		
		List<Request> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
	}
	
	public default List<Request> getResolvedRequests() {
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where status='approved' or status='rejected");
		
		List<Request> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
	}
	
	
	public default List<Request> getRequestsForUser(int userId) {
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where user_id=" + userId + ";");
		
		List<Request> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
	}
	
	public default List<Request> getUserPending(int userId) {
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where status='pending' and user_id="+userId+";");
		
		List<Request> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
	}
	
	public default List<Request> getUserResolved(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from request_info where user_id="+userId+" and status='approved' or user_id=" + userId + " and status='rejected';");
		
		List<Request> allReq= query.getResultList();
		
		transaction.commit();
	
		session.close();
		
		return allReq;
	}
	
}
