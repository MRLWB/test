package com.jx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jx.pojo.SysRole;

/**
 * POJO:
 * 1)封装数据(客户端表单数据,服务端表中数据)
 * 2)数据传递(dao<-->controller)
 * @author ta
 */
public interface SysRoleDao {
	//String findPermissionByRoleId(Integer id);
	//基于角色id(role_id)获取角色对象信息
	SysRole findRoleByRoleId(Integer id);
}
