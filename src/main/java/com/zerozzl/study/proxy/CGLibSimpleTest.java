package com.zerozzl.study.proxy;

import java.lang.reflect.Method;
import java.util.List;

import com.zerozzl.study.common.dao.impl.UserDaoImpl;
import com.zerozzl.study.common.model.UserDO;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibSimpleTest implements MethodInterceptor {

	@Override
	public Object intercept(Object obj,
			Method method,
			Object[] args,
			MethodProxy methodProxy) throws Throwable {
		Object res = null;
		System.out.println("Before invoke: " + method.getName());
		res = methodProxy.invokeSuper(obj, args);
		System.out.println("After invoke: " + method.getName());
		return res;
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserDaoImpl.class);
		enhancer.setCallback(new CGLibSimpleTest());
		UserDaoImpl instance = (UserDaoImpl) enhancer.create();
		List<UserDO> users = instance.selectAll();
		System.out.println(users);
	}

}
