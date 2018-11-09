package com.jx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.pojo.SysUser;
import com.jx.service.SysUserService;
import com.jx.vo.ResultVO;

@Controller
@RequestMapping("/")
public class IndexController {

	private int number;


	public int getNumber(){
		return this.number;
	}

	@Autowired
	private SysUserService sysUserService;


	@RequestMapping("index")
	public String Index(int number){
		this.number = number;
		return "pages/index1.0";
	}
	
	@RequestMapping("index10")
	public String Index(){
		
		return "pages/index1.0";
	}

	@RequestMapping("individual")
	public String individual(){
		return "pages/individualTermSchedule";
	}

	@RequestMapping("dofindObjectByUserName")
	@ResponseBody
	public ResultVO dofindObjectByUserName(){
		SysUser user = sysUserService.findObjectByUserName(number);
		return new ResultVO(user);
	}
}
