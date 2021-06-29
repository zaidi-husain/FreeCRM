package com.CRM.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.CRM.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase()  {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/home/abc/Documents/workspace-spring-tool-suite-4-4.10.0.RELEASE/FreeCRMTest/src/main/java/com/CRM/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver();
			driver = new ChromeDriver(); 
		}else if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("URL"));
			
			
			
			
		}
	}

}
