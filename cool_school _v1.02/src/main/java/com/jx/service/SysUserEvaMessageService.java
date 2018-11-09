package com.jx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.jx.pojo.SysUserEvaMessage;

public interface SysUserEvaMessageService {
	/**
	 * 根据课程编号获取评价信息
	 * @param nunm
	 * @return
	 */
	List<SysUserEvaMessage> findUserEvaMassege(Integer nunm);
	

}
