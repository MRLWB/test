package com.jx.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/*
 * 这个类封装角色权限信息
 */
@Data
public class SysRole implements Serializable{
	private static final long serialVersionUID = -3595558177205560406L;
	private Integer id;//角色id
	private String name;//角色名称
	private String note;//角色说明
	private Date createTime;//创建时间
	private Date modifiedTime;//修改时间
	private String permission;//权限
}
