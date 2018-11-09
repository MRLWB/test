package com.jx.controller;
/**
 * 用户controller
 */
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.pojo.SysRole;
import com.jx.pojo.SysUser;
import com.jx.service.SysRoleService;
import com.jx.service.SysUserService;
import com.jx.vo.ResultVO;

@RequestMapping("/user/")
@Controller
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	 @RequestMapping("dofindObjectByUserName")
	 @ResponseBody
	 public ResultVO dofindObjectByUserName(int number){
		 SysUser user = sysUserService.findObjectByUserName(number);
		 System.out.println(user);
		 return new ResultVO(user);
	 }
	 
	 @RequestMapping("dofindRoleIdsByUserName")
	 @ResponseBody
	 public ResultVO dofindRoleIdsByUserName(int number){
		 int role = sysUserService.findRoleIdsByUserName(number);
		return new ResultVO(role); 
	 }
	 
	 @RequestMapping("doinsertObject")
	 @ResponseBody
	 public ResultVO doinsertObject(SysUser user){
		 int insertObject = sysUserService.insertObject(user);
		 System.out.println(insertObject);
		return new ResultVO("insert ok"); 
	 }
	/* @RequestMapping("dofindUserByUserName")
	 @ResponseBody
	 public ResultVO dofindUserByUserName(String username,String password,Integer id){
		SysUser userl = sysUserService.findUserByUserName(username, password, id);
		return new ResultVO(userl); 
	 }*/
	 
	 
}