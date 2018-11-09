package com.jx.controller;
/**
 * 角色controller
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.pojo.SysRole;
import com.jx.service.SysRoleService;
import com.jx.vo.ResultVO;

@Controller
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	 @RequestMapping("doFindRoleById")
	 @ResponseBody
	 public ResultVO doFindRoleById(Integer id){
		 SysRole role = sysRoleService.findRoleByRoleId(id);
		 System.out.println(role);
		 return new ResultVO(role);
	 }
	
}
