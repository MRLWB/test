package com.jx.vo;

import java.io.Serializable;

import lombok.Data;
/**
 *  JSON数据返回类
 * @author Administrator
 *
 */
@Data
public class ResultVO implements Serializable {

	private static final long serialVersionUID = 7271615952445909757L;
	//状态码
	int state=1; 
	//信息
	String message="OK"; 
	//数据
	Object data;
	
	public ResultVO(String message){
		this.message = message;
	}
	
	public ResultVO(Object data){
		this.data = data;
	}
	
	public void error(String e){
		this.state = 0;
		this.message = e;
	}
	
	public ResultVO(){
		
	}
}
