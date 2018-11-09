package com.jx.pojo;
/**
 * 存储用户卡片信息
 */
import lombok.Data;

@Data
public class SysUserMessage {

	private int id;//用户id
	private String userName;//用户名
	private String email;//邮箱
	private String mobile;//手机
	private String dept_name;//院系名称
	private String pro_name;//专业名称
	private String class_name;//班级
}
