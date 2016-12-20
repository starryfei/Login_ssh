package com.service.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;
import com.service.impl.UserImpl;
import com.util.Hibernateutil;

public class UserDao implements UserImpl {
	private Transaction ts = null;
	private String sql = "";
	private Session session = null;

	@Override
	public boolean Login(User user) {
		try {
			getSession();
			sql = "select username,pwd from User where username=?and pwd=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPwd());
			List list = query.list();
			ts.commit();
			if (!list.isEmpty())
				return true;
			else
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean Register(User user) {
		// TODO Auto-generated method stub
		try {
			getSession();
			session.save(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public void getSession() {
		session = Hibernateutil.getSessionFactory().openSession();
		ts = session.beginTransaction();
	}
}
