package com.zerozzl.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import com.zerozzl.study.common.dao.UserDao;
import com.zerozzl.study.common.dao.impl.UserDaoImpl;
import com.zerozzl.study.common.model.UserDO;

public class DynamicProxyTest implements InvocationHandler {

	private Object subject;

	public DynamicProxyTest(
			Object sub) {
		this.subject = sub;
	}

	@Override
	public Object invoke(Object proxy,
			Method method,
			Object[] args) throws Throwable {
		Object res = null;
		System.out.println("Before invoke: " + method.getName());
		res = method.invoke(subject, args);
		System.out.println("After invoke: " + method.getName());
		return res;
	}

	public static void main(String[] args) {
		UserDaoImpl target = new UserDaoImpl();
		InvocationHandler handler = new DynamicProxyTest(target);
		UserDao interf = (UserDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		List<UserDO> users = interf.selectAll();
		System.out.println(users);
	}

}
