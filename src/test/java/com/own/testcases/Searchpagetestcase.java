package com.own.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.own.pageobjects.Searchcoursepage;

public class Searchpagetestcase extends BaseTest{
	Searchcoursepage sp;
	
	@Test
	public void search222() throws InterruptedException{
		
		lt.loginuser(username, password);
		
		Thread.sleep(5000);
	sp=new Searchcoursepage(driver);
	 sp.searchcourse();
	 Thread.sleep(9000);
	sp.Retrivetext();
	}
	
	
	
	
	
}
