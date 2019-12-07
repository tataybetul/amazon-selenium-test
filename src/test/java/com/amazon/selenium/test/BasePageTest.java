package com.amazon.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BasePageTest {
	
	protected WebDriver driver;
	protected final Properties properties;
	
	public BasePageTest() {
		try {
			this.properties =new Properties();
			InputStream inputStream = ClassLoader.getSystemResourceAsStream("data.properties");
			this.properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException("Properties file not found", e);
		}
	}
	
	@BeforeTest
	public void setUp(){
		initializeDriver();
		driver.manage().window().maximize();
	}
	
	public void initializeDriver() {
		String browserName =properties.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",properties.getProperty("driverPath"));
			driver =new ChromeDriver();
		} else if(browserName.equals("IE")){
			System.setProperty("webdriver.geckho.driver", properties.getProperty("driverPath"));
			driver =new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Driver type not found");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
