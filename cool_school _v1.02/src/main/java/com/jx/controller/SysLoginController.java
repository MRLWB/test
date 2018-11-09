package com.jx.controller;
/**
 * 登录controller
 */
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.service.SysUserService;
import com.jx.vo.ResultVO;

@RequestMapping("/")
@Controller
public class SysLoginController {
	//登录页面跳转
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "pages/login";
	}

	@RequestMapping("doLogin")
	@ResponseBody
	public ResultVO doLogin(String number, String password) {
		
		System.out.println("username"+number+",password"+password);
		
		// 1.通过Subject提交用户信息,交给shiro框架进行认证操作
		// 1.1对用户进行封装
		// 1.2对用户信息进行身份认证
		UsernamePasswordToken token = new UsernamePasswordToken(
				number, // 身份信息
				password);// 凭证信息
		// 2.获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);

		// 分析:
		// 1)token会传给shiro的SecurityManager
		// 2)SecurityManager将token传递给认证管理器
		// 3)认证管理器会将token传递给realm
		return new ResultVO("login ok");
	}
	
}
