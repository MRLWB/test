package com.jx.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CourseGuideVO implements Serializable {

	private static final long serialVersionUID = 4830882278544434474L;

	private int id;
	
	private int start_time;
	
	private int nunm;
	
	private String name;
	
	private int period;
	
	private int goal;
	
	private String way;
	
	private String tx;
	
	private String deptname;
	

}
