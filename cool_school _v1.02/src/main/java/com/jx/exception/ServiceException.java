package com.jx.exception;
/**
 * 业务异常类
 * @author Administrator
 *
 */
public class ServiceException extends RuntimeException{

	public ServiceException (){
		super();
	}
	
    public ServiceException(String message) {
        super(message);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }

}
