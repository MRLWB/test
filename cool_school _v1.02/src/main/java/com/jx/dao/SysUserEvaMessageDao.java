package com.jx.dao;

import java.util.List;


import com.jx.pojo.SysUserEvaMessage;

public interface SysUserEvaMessageDao {
	/**
	 * 根据课程编号获取课程信息
	 * @param nunm
	 * @return
	 */
	List<SysUserEvaMessage> findUserEvaMassege(Integer nunm);
	

}
