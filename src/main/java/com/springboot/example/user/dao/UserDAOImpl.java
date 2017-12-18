package com.springboot.example.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.example.dao.UserDAO;
import com.springboot.example.user.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	/*	here we can set the session factory or we can use the @Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }	

	public void saveUser(User user) {
		getCurrentSession().saveOrUpdate(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

	public User getUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void deleteUser(int uid) {
		/*User userid = (User) sessionFactory.getCurrentSession().load(
                User.class, uid);*/
		User userid = (User) sessionFactory.getCurrentSession().get(User.class, uid);
        if (null != userid) {
            this.sessionFactory.getCurrentSession().delete(userid);
        }
	}

	public void updateUser(User user) {
		this.sessionFactory.getCurrentSession().update(user);
//		User userdata = (User) sessionFactory.getCurrentSession().get(User.class, user.getUserId());
//		if (null != userdata) {
//			userdata.setAddress(userdata.getAddress());
//			userdata.setContact(userdata.getContact());
//			userdata.setPassword(userdata.getPassword());
//			this.sessionFactory.getCurrentSession().save(userdata);
//        }
	}
		

}
