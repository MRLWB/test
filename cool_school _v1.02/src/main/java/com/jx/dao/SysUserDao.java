package com.jx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jx.pojo.SysGradeList;
import com.jx.pojo.SysUser;
import com.jx.pojo.SysUserMessage;

public interface SysUserDao {

	List<SysUser> findByIds(@Param("list")List<Integer> ids,
			                @Param("startIndex") int startIndex,
			                @Param("pagesize") int pagesize);
	
	//根据登录用户id查询用户名，密码，邮箱，手机号
	SysUser findSysUser(Integer id);
	
	//根据登录的用户id，修改密码，邮箱，手机号
	int  updateMessage(SysUser entity);
	
	//根据登录id查找用户基本信息
	SysUserMessage findObject(@Param("id")Integer id);
	
	//根据id查找成绩
	List<SysGradeList> findUserGradeList(Integer user_id);
	
	//基于学号获取用户名对象
	SysUser findObjectByUserName(int number);
	//基于用户名称查找角色id
	int findRoleIdsByUserName(int number);
	
	int insertObject(SysUser user);
}
