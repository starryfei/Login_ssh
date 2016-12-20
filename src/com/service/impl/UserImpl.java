package com.service.impl;

import com.entity.User;

//用户业务逻辑接口
public interface UserImpl {
	// login
	public boolean Login(User user);

	public boolean Register(User user);
}
