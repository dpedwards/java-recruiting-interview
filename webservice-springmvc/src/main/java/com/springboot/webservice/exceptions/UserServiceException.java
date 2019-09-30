package com.springboot.webservice.exceptions;

/**
 * 
 * @author dpedwards
 *
 */
public class UserServiceException extends RuntimeException{
 
	private static final long serialVersionUID = 1348771109171435607L;

	public UserServiceException(String message)
	{
		super(message);
	}
}
