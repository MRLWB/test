package com.jx.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.vo.ResultVO;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResultVO doHandler(RuntimeException e){
		ResultVO vo = new ResultVO();
		vo.error(e.getMessage());
		return vo;
	}
/*	
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public ResultVo doHandlerIncorrectCredentialsException(ShiroException e){
		ResultVo vo = new ResultVo();
		vo.setStatus(0);
		if(e instanceof IncorrectCredentialsException){
			vo.setMessage("密码不正确");
		}else if(e instanceof UnknownAccountException){
			vo.setMessage("账户不存在");
		}else if(e instanceof LockedAccountException){
			vo.setMessage("账户已被锁定");
		}else if(e instanceof UnauthorizedException){
			vo.setMessage("没有权限");
		}
		return vo;
	}*/
}
