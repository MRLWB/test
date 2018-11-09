package com.jx.controller;

/**
 * 课程contrller
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.pojo.SysHour;
import com.jx.service.SysCourseService;
import com.jx.vo.CourseGuideVO;
import com.jx.vo.CourseTeacherVO;
import com.jx.vo.CourseVO;
import com.jx.vo.PageVO;
import com.jx.vo.ResultVO;

@Controller
@RequestMapping("/course/")
public class SysCourseController {

	@Autowired
	private SysCourseService service;

	@RequestMapping("doCourseSearch")
	public String doCourseSearch(){
		return "pages/courseSearchList";
	}

	@RequestMapping("doFindList")
	@ResponseBody
	public ResultVO doFindList(int userId){
		List<CourseVO> list = service.findCourse(userId);
		return new ResultVO(list);
	}

	@RequestMapping("doFindGuide")
	@ResponseBody
	public ResultVO doFindGuide(int userId){
		List<CourseGuideVO> list =service.findCourseGuide(userId);
		return new ResultVO(list);
	}

	@RequestMapping("doSerch")
	@ResponseBody
	public ResultVO doSerch(String courseName,int pageCurrent){
		PageVO<CourseTeacherVO> pvo = service.findCourseTeacher(courseName, pageCurrent);
		return new ResultVO(pvo);
	}


	
	@RequestMapping("doTimeCourse")
	@ResponseBody
	public ResultVO doTimeCourse(int userId){
		List<SysHour> list = service.findHourCourse(userId);
		return new ResultVO(list);
	}
}
