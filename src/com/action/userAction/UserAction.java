package com.action.userAction;

import java.util.Map;

import javax.enterprise.event.Observes;

import org.apache.struts2.interceptor.RequestAware;

import com.entity.User;
import com.service.dao.UserDao;

public class UserAction implements RequestAware {
	private String username;
	private String pwd;
	private Map<String, Object> request;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String Login() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		if (userDao.Login(user)) {
			request.put("username", username);
			return "success";
		} else
			return "error";
	}
	public String Register() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		if(userDao.Register(user)){
			return "success";
		}else
		return "failure";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
