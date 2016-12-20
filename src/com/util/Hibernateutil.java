package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {
	private static SessionFactory sessionFactory = null;

	// 采用单例模式
	private Hibernateutil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// 创建Configuration对象:对应hibernate的基本配置信息和对象关系映射信息
			Configuration config = new Configuration().configure();
			// 创建一个对象StandardServiceRegistry，configure("你的***.cfg.xml")，默认为hibernate.cfg.xml
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure().build();
			// 创建会话工厂对象
			sessionFactory = config.buildSessionFactory(registry);
			return sessionFactory;
		} else
			return sessionFactory;
	}

}
