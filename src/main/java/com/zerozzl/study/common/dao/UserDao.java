package com.zerozzl.study.common.dao;

import java.util.List;

import com.zerozzl.study.common.model.UserDO;

public interface UserDao {

	List<UserDO> selectAll();

}
