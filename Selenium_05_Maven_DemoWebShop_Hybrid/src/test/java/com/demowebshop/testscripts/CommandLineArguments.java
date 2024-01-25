package com.demowebshop.testscripts;

import org.testng.annotations.Test;

public class CommandLineArguments {

	@Test
	public void cmdArgs() 
	{
		String url = System.getProperty("URL") ;
		String email = System.getProperty("EMAIL") ;
		String password = System.getProperty("PASSWORD") ;
		System.out.println( "Url :: "+ url );
		System.out.println( "Email :: "+ email );
		System.out.println( "Password :: "+ password );
	}

}
