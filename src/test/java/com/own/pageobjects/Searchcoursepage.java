package com.own.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Searchcoursepage {

	WebDriver driver;
	
	public Searchcoursepage(WebDriver ibdriver)
	{
		this.driver=ibdriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[contains(text(),'SEE COURSES')]") WebElement courses;
	@FindBy(id="form1") WebElement searchbox;
	@FindBy(xpath="//div[@class='form-outline search']//button[@type='button']") WebElement searchicon;
	@FindBy(xpath="//h3[contains(text(), 'Java for Testers: Essential Skills for Automation Testing')]") WebElement coursename;
	
	public void searchcourse()
	
	{
		courses.click();
		searchbox.sendKeys("Automation");
		searchicon.click();
		
		
	}
	public void Retrivetext()
	{
		String javacoursename=coursename.getText();
		 Assert.assertEquals(javacoursename,"Java for Testers: Essential Skills for Automation Testing");
	}
}
