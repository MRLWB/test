package com.jx.service.impl;

import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jx.dao.SysUserDao;
import com.jx.exception.ServiceException;
import com.jx.pojo.SysUser;
import com.jx.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;

	/*
	 * public SysUser findUserByUserName(String username, String password,
	 * Integer role_id) { // 1.合法性验证 if (username == null) throw new
	 * ServiceException("请输入用户名"); if (password == null) throw new
	 * ServiceException("请输入用户密码"); // 2.用户登录角色认证操作 SysUser user =
	 * sysUserDao.findUserByUserName(username, password, role_id); return user;
	 * 
	 * }
	 */
	@Override
	public int findRoleIdsByUserName(int number) {
		int roleid = sysUserDao.findRoleIdsByUserName(number);
		return roleid;
	}

	@Override
	public SysUser findObjectByUserName(int number) {
		SysUser Object = sysUserDao.findObjectByUserName(number);
		return Object;
	}

	@Override
	public int insertObject(SysUser user) {
		// 1.校验
		if (user == null)
			throw new IllegalArgumentException("更新对象不能为空");
		/*if (StringUtils.isEmpty(user.getUserName()))
			throw new IllegalArgumentException("用户名不能为空");*/
		/*if(roleid!=1||roleid!=2||roleid!=3)
	    	throw new IllegalArgumentException("需要为用户分配角色:1为学生角色，2为教师角色，3为管理员角色");*/
//		System.out.println("PassWord:"+user.getPassWord()+user.getUserName());
		String salt=UUID.randomUUID().toString();
    	String password=user.getPassWord();
    	SimpleHash sh=//这个api属于shiro框架,后续需要引入shiro依赖
    	    	new SimpleHash("MD5",//algorithmName 表示加密算法
    	    			password, //source 为要加密的对象
    	    			salt);//salt 加密盐值
    	user.setPassWord(sh.toHex());
    	user.setSalt(salt);
		// 2.更新
		int rows = sysUserDao.insertObject(user);
		// 3.返回
		return rows;
	}

}
