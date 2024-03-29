package com.springboot.webservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 
 * @author dpedwards
 *
 */
@Component
public class AppProperties {

	@Autowired
	private Environment env;
	
	public String getTokenSecret()
	{
		return env.getProperty("tokenSecret");
	}
}
