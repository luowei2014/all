package com.luowei.demo;

import com.luowei.demo.algorithm.ChooseAlgorithm;
import com.luowei.demo.proxy.dynamicproxy.CustomizeHandle;
import com.luowei.demo.proxy.dynamicproxy.ISubject;
import com.luowei.demo.proxy.dynamicproxy.ISubjectImpl;
import com.luowei.demo.proxy.dynamicproxy.JDKProxyTest;
import com.luowei.demo.proxy.staticproxy.AccountProxy;
import com.luowei.demo.testpackage.Hello;
import com.luowei.demo.testpackage.HelloSon;
import com.luowei.demo.thread.ThreadLocalDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void testDynamicProxy(){
		CustomizeHandle handle = new CustomizeHandle(ISubjectImpl.class) ;
		ISubject subject = (ISubject) Proxy.newProxyInstance(AccountProxy.class.getClassLoader(), new Class[]{ISubject.class}, handle);
		subject.execute() ;
		subject.sayHi("luowei");
	}

	@Test
	public void testThreadLocal(){
		ThreadLocalDemo td=new ThreadLocalDemo();
		td.start();
	}

	@Test
	public void testAlgorithm(){
//		ChooseAlgorithm chooseAlgorithm=new ChooseAlgorithm();
//		chooseAlgorithm.testAlgorithm();
		String s="sss";
		String s2="sss";
		String s3=new String ("sss");
        String s4=new String ("sss");
		System.out.println(s==(s3));
	}
}
