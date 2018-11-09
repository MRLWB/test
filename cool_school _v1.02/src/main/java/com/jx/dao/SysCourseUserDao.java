package com.jx.dao;

import java.util.List;

public interface SysCourseUserDao {

	List<Integer> findByIds(int courseId);
}
