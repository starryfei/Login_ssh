/*package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OpenHiberante {
	private static Configuration configuration;
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;

	public void open() {
		// 创建Configuration对象:对应hibernate的基本配置信息和对象关系映射信息
		configuration = new Configuration().configure();

		// 创建一个对象StandardServiceRegistry，configure("你的***.cfg.xml")，默认为hibernate.cfg.xml
		registry = new StandardServiceRegistryBuilder().configure().build();

		// 创建会话工厂对象
		sessionFactory = configuration.buildSessionFactory(registry);

		// 创建一个Session对象
		session = sessionFactory.openSession();

		// 开启事物
		transaction = session.beginTransaction();
	}

	
	 * public void saveNews() { User user = new User("fei", "123");
	 * session.save(user); }
	 
	public boolean getUser(User user) {
		
		String sql = "select username,pwd from User where username='"
				+ user.getUsername() + "'and pwd='" + user.getPwd() + "'";
		List list = session.createQuery(sql).list();
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}
	   
     * 将User对象插入到数据库中  
     * @param user  
       
    public void create(User user) {  
    		
    }  

	public void close() {
		// 提交事物
		transaction.commit();
		// 关闭session
		session.close();
		// 关闭SessionFactory对象
		sessionFactory.close();
	}
	// public static void main(String[] args) {
	// open();
	// // System.out.println(getUser());
	// close();
	//
	// }
}
*/