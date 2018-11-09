package com.jx.pojo;

import lombok.Data;

/**
 * 用户成绩列表
 * @author Administrator
 *
 */
@Data
public class SysGradeList {

	private int nunm;//课程编码
	private String name;//课程名称
	private int goal;//学分
	private String tx_name;//体系名称
	private String way;//考核方式
	private String note;//备注
	private String dept_name;//院系名
	private String pro_name;//专业名
	private int start_time;//开课时间
	private int period;//总学时
	private double grade;//成绩
	private int user_id;//用户id
	
	
	
	
}
