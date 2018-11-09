package com.jx.service;

import com.jx.pojo.SysRole;


public interface SysRoleService {
	/**
	 * 基于角色id查询角色数据
	 * @param id
	 * @return
	 */
	SysRole findRoleByRoleId(Integer id);
}
