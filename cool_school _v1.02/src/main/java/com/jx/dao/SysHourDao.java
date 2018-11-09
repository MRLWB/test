package com.jx.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jx.pojo.SysHour;


public interface SysHourDao {
	//SysHour findObjectByUserId(Integer id);
	//SysHour findAllByCourseId(Integer id);
	List<SysHour> findAllByCourseId(List<Integer> courseIds);
}
