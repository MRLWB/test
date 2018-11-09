package com.jx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jx.pojo.SysGarde;



public interface SysGardeDao {
	
	List<SysGarde> findCourseNumByUserId(int userId);
	
	double findById(@Param("userId") int userId,@Param("courseNum") int courseNum);
}
