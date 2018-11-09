package com.jx.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CourseTeacherVO implements Serializable {

	private static final long serialVersionUID = -2758618583144082067L;

	private String courseName;
	
	private String teacherName;
	
	private String phone;
	
	private String email;
	
	private String deptName;
	
	private String note;
}
