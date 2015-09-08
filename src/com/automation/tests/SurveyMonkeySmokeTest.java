package com.automation.tests;

import java.io.IOException;

import com.thoughtworks.selenium.SeleneseTestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SurveyMonkeySmokeTest {

	WebDriver driver;

	@BeforeClass
	public void setUP() throws ClassNotFoundException {
		driver = new FirefoxDriver();
	}

	@Test
	public void launchApplicationTest() {

		String url = "https://www.surveymonkey.com/";
		String appTitle;
		Exception exception = null;
		try {
			driver.get(url);
			appTitle = driver.getTitle();

			if (appTitle.endsWith("available") || appTitle.endsWith("page")
					|| appTitle.contains("cannot"))
				throw exception;
			Assert.assertEquals("SurveyMonkey: Free online survey software & questionnaire tool", appTitle);
			System.out.println("Application launched successfully, Testcase is passed!!");
		} catch (Exception exp) {

			System.out.println("Unable to open the test url, please check the url is correct and it is running.");
			Assert.fail(
					"Unable to open the test url, please check the url is correct and it is running.",
					exp);
		}
	}


	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}