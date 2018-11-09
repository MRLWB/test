package com.jx.service;

import java.util.List;

import com.jx.pojo.SysGradeList;
import com.jx.pojo.SysUser;
import com.jx.pojo.SysUserMessage;

/**
 * 用户基本信息获取
 * @author Administrator
 *
 */
public interface SysUserMessageService {

	SysUserMessage findObject(Integer userId);

	List<SysGradeList> findUserGradeList(Integer user_id);

	//查询用户信息
	SysUser findSysUser(Integer id);
	//更新用户信息
	int updateUserMessage(SysUser entity);
}
