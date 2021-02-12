package dev.patten.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.patten.pages.TestDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.patten.steps")
public class Runner {
	
	public static WebDriver driver;
	public static TestDriver runner;

	@BeforeClass
	public static void setup() {
		File file = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		runner = new TestDriver(driver); 
	}
	
	@AfterClass
	public static void close() {
		driver.quit();
	}
}
