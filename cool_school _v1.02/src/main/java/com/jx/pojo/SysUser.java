package com.jx.pojo;

import lombok.Data;

@Data
public class SysUser {

	private int id;
	
	private String userName;
	
	private String passWord;
	
	private String salt;
	
	private String email;
	
	private String mobile;
	
	private int role_id;
	
	private int eva_id;
	
	private int class_id;
	
	private int number;
}
