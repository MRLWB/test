package com.jx.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageVO<T> implements Serializable{

	private static final long serialVersionUID = 1087965777216167110L;
	
	private Integer pageCurrent=1;
	private Integer pageSize=10;
	private Integer rowCount=0;
	private Integer pageCount=0;
	private List<T> records;
	
	public Integer getPageCount() {
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		return pageCount;
	}
}
