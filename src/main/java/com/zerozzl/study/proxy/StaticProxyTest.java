package com.zerozzl.study.proxy;

import java.util.List;

import com.zerozzl.study.common.dao.UserDao;
import com.zerozzl.study.common.dao.impl.UserDaoImpl;
import com.zerozzl.study.common.model.UserDO;

public class StaticProxyTest implements UserDao {

	private UserDao dao = new UserDaoImpl();

	@Override
	public List<UserDO> selectAll() {
		List<UserDO> users = null;
		System.out.println("Before invoke selectAll");
		users = dao.selectAll();
		System.out.println("After invoke selectAll");
		return users;
	}

	public static void main(String[] args) {
		StaticProxyTest proxy = new StaticProxyTest();
		List<UserDO> users = proxy.selectAll();
		System.out.println(users);
	}

}
