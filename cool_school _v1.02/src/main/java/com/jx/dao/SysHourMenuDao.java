package com.jx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface SysHourMenuDao {
	List<Integer> findCourseIdByProIds(Integer...proIds);
	/*int insertObject(
			@Param("proId")Integer proId,
			@Param("courseIds")Integer[] courseIds);*/
	
}
