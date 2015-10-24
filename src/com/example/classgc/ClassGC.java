package com.example.classgc;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ClassGC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			Enhancer enhancer=new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);// 关闭CGLib缓存，否则总是生成同一个类
			enhancer.setCallback(new MethodInterceptor(){

				@Override
				public Object intercept(Object arg0, Method arg1,
						Object[] arg2, MethodProxy arg3) throws Throwable {
					// TODO Auto-generated method stub
					return arg3.invoke(arg1, arg2);
				}
			});
			enhancer.create();
		}
	}
	
	static class OOMObject{
		
	}

}
