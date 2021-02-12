package dev.patten.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestDriver {
	public WebDriver driver;
	
	@FindBy(id = "username1")
	public WebElement login;
	
	@FindBy(id = "password1")
	public WebElement password;
	
	public TestDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
}
