package com.jx.service;

import java.util.List;

import com.jx.pojo.SysHour;
import com.jx.vo.CourseGuideVO;
import com.jx.vo.CourseTeacherVO;
import com.jx.vo.CourseVO;
import com.jx.vo.PageVO;

public interface SysCourseService {

	List<CourseVO> findCourse(int userId);
	
	List<CourseGuideVO> findCourseGuide(int userId);
	
	PageVO<CourseTeacherVO>  findCourseTeacher(String courseName,int pageCurrent);
	
	List<SysHour> findHourCourse(int userId);
	
}
