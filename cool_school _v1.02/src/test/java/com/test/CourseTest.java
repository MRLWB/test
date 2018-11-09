package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jx.dao.SysCourseDao;
import com.jx.pojo.SysCourse;
import com.jx.service.SysCourseService;
import com.jx.vo.CourseTeacherVO;
import com.jx.vo.CourseVO;
import com.jx.vo.PageVO;


public class CourseTest extends testBase{

	@Test
	public void TestCourse(){

		SysCourseDao dao = cpxac.getBean("sysCourseDao",SysCourseDao.class);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		List<SysCourse> list = dao.findAll(ids);	
		Assert.assertNotEquals(null, list);
		for(SysCourse sc : list){
			System.out.println(sc.toString());
		}
	}
	
	@Test
	public void TestCourse2(){
		
		SysCourseService service = cpxac.getBean(SysCourseService.class);
		List<CourseVO> list = service.findCourse(1);
		Assert.assertNotEquals(null, list);
		for(CourseVO cvo : list){
			System.out.println(cvo.toString());
		}
	}
	
	@Test 
	public void TestCourse3(){
		SysCourseService service = cpxac.getBean(SysCourseService.class);
		PageVO<CourseTeacherVO> pvo = service.findCourseTeacher("计算机应用基础", 1);
		Assert.assertNotEquals(null, pvo);
		System.out.println(pvo);

	}
}
