package com.test.inv.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyInvHandler implements InvocationHandler {
	
	private Object delegate;
	public Object bind(Object delegate)
	{
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), 
				this.delegate.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object res = null;
		System.out.println(method.getName()+" start!");
		res = method.invoke(delegate, args);
		System.out.println(method.getName()+" end!");
		return res;
	}

}
