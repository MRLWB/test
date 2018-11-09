package com.jx.service;

import com.jx.pojo.SysUser;

public interface SysUserService {
	//通过用户名获取用户名和用户密码,角色id
//	SysUser findUserByUserName(String username,String password,Integer role_id);
	//通过用户名获取用户信息
	SysUser findObjectByUserName(int number);
	//通过用户名获取角色id
	int findRoleIdsByUserName(int number);
	
	//向用户表插入数据
	int insertObject(SysUser user);
}
