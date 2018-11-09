package com.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBase {

	protected ClassPathXmlApplicationContext cpxac;
	@Before
	public void init(){
		cpxac=new ClassPathXmlApplicationContext("spring-config.xml");
	}
	
	@After
	public void close(){
		cpxac.close();
	}
}
