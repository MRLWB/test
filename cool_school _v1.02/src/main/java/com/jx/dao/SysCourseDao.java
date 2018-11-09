package com.jx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jx.pojo.SysCourse;

public interface SysCourseDao {

	List<SysCourse> findAll(List<Integer> num);
	
	SysCourse findByCouserName(@Param("name")String name);
	
	List<SysCourse> findCourseByCourseId(List<Integer> courseId);
	
}
