package com.demo.ersSpring.dao;


import com.demo.ersSpring.HibernateUtil;
import com.demo.ersSpring.entity.Request;
import com.demo.ersSpring.entity.User;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends JpaRepository<User,Integer> {

	public default User getUserByEmail(String email, String password) {
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from user_info where email='"+email+"' and password='"+password+"';");
		
		List<User> userList = query.getResultList();
		
		User user = userList.get(0);
		
		transaction.commit();
	
		session.close();
		
		return user;
	}

}
