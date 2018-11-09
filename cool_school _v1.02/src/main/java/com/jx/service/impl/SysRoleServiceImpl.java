package com.jx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jx.dao.SysRoleDao;
import com.jx.pojo.SysRole;
import com.jx.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public SysRole findRoleByRoleId(Integer id) {
		SysRole role = sysRoleDao.findRoleByRoleId(id);
		System.out.println("role:"+role);
		return role;
	}
}









