package com.jx.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CourseVO implements Serializable{

	private static final long serialVersionUID = -7720878892503107893L;

	private int id;

	private int nunm;
	
	private String name;
	
	private int goal;
	
	private String way;
	
	private String note;
	
	private String tx;
	
	private double grade;
	
}
