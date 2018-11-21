package com.zerozzl.study.common.dao;

import java.util.List;

import com.zerozzl.study.common.model.User;

public interface UserDao {

	List<User> selectAll();

}
