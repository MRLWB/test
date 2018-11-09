package com.jx.pojo;

import lombok.Data;

@Data
public class SysUserEvaMessage {
	//评价内容
	private String note;
	//课程编码
	private int nunm;
	//课程名称
	private String name;
	//上课总学时
	private int period;
	//上课老师
	private String userName;	
}
