package com.jx.controller;

import java.util.List;

/**
 * 用户信息：学籍卡，学籍管理等控制层
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.pojo.SysGradeList;
import com.jx.pojo.SysUser;
import com.jx.pojo.SysUserEvaMessage;
import com.jx.pojo.SysUserMessage;
import com.jx.service.SysUserEvaMessageService;
/*import com.jx.service.SysUpdateUserMessageService;
import com.jx.service.SysUserGradeListService;*/
import com.jx.service.SysUserMessageService;
import com.jx.vo.ResultVO;

/**
 * 用户评价Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userMessage/")
public class SysUserMessageController {

	// 自动封装用户信息
	@Autowired
	private SysUserMessageService userMessageService;
	// 自动封装更新用户信息
	/*
	 * @Autowired private SysUpdateUserMessageService updateUserMessageService;
	 * //自动封装用户成绩信息
	 * 
	 * @Autowired private SysUserGradeListService sysUserGradeListService;
	 */

	// 自动封装课程评价信息
	@Autowired
	private SysUserEvaMessageService sysUserEvaMessageService;

	@RequestMapping("doUserMessageUI")
	public String doUserMessageUI() {

		return "pages/personCard";
	}

	@RequestMapping("doUpdate")
	public String doUpdate() {
		return "pages/informationManagement";
	}

	// 获取用户信息
	@RequestMapping("doFindSysUser")
	@ResponseBody
	public ResultVO doFindSysUser(Integer id) {
		SysUser user = userMessageService.findSysUser(id);
		return new ResultVO(user);
	}

	// 更改信息查询
	@RequestMapping("doFindObject")
	@ResponseBody
	public ResultVO doFindObject(Integer id) {
		System.out.println(id);
		SysUserMessage user = userMessageService.findObject(id);
		return new ResultVO(user);
	}

	// 跳转到更新用户信息界面，需要更新
	@RequestMapping("doChangeUserMessageUI")
	public String doChangeUserMessage() {
		return "UpdatUser_List";
	}

	@RequestMapping("doUpdateUserMessage")
	@ResponseBody
	public ResultVO doUpdateUserMessage(SysUser entity) {
		userMessageService.updateUserMessage(entity);
		return new ResultVO("更新成功");
	}

	@RequestMapping("doUserGradeListUI")
	public String doUserGradeListUI() {
		return "pages/scoreInquiry";
	}

	@RequestMapping("doUserGradeList")
	@ResponseBody
	public ResultVO doUserGradeList(Integer user_id) {
		List<SysGradeList> list = userMessageService.findUserGradeList(user_id);
		return new ResultVO(list);
	}

	// 教师评价信息的呈现
	@RequestMapping("doUserEvaMassege")
	public String doUserEvaMassege() {
		return "pages/doUserEvaMassege_List";
	}

	// 根据课程编码查询课程评价信息
	@RequestMapping("doUserEvaMassegeList")
	@ResponseBody
	public ResultVO doUserEvaMassegeList(Integer nunm) {
		List<SysUserEvaMessage> massege = sysUserEvaMessageService.findUserEvaMassege(nunm);
		System.out.println(massege);
		return new ResultVO(massege);
	}

}
