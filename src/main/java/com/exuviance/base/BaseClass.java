package com.exuviance.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.exuviance.actiondriver.Action;
import com.exuviance.pageobjects.*;
import com.exuviance.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Properties;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 24 May 2022
 **/

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentTest test;
	public String defaultFlag = "Yes";
	public static String baseURI;
	public static String runOn;
	public ExtentReports exprep = ExtentManager.setExtent();
	
	public static final String UserName = "vaibhavnagvekar_eOIwvK";
	public static final String AutomateKey = "ytp4SxZp4Hd9K1jGArhj";
	public static final String URL = "https://" + UserName + ":" + AutomateKey + "@hub-cloud.browserstack.com/wd/hub";
	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
	static LocalDateTime now = LocalDateTime.now();
	static String format = dtf.format(now);

	public static HomePage home;
	public static HeaderPage header;
	public static FooterPage footer;
	public static IndexPage index;
	public static ProductListingPage PLP;
	public static ProductDisplayPage PDP;
	public static CartPage cart;
	public static ShippingPage shipping;
	public static ForgotPasswordPage forgotpassword;
	public static HolidayPage holiday;
	public static OurStoryPage ourStory;
	public static RegistrationPage registration;
	public static QuizPage quiz;

	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApplication() {
		String browserName = prop.getProperty("browser");
		runOn = prop.getProperty("runOn");
		String headlessChrome = prop.getProperty("headlessChrome");
		String runOnBrowserstack = prop.getProperty("runOnBrowserstack");
		String remoteWinBrowserVersion = prop.getProperty("remoteWinBrowserVersion");
		String remoteWinVersion = prop.getProperty("remoteWinVersion");
		String remoteOS = prop.getProperty("remoteOS");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		MutableCapabilities caps = new MutableCapabilities();

		if (runOnBrowserstack.contains("No")) {
			switch(browserName) {
			case "Chrome":
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--remote-allow-origins=*");
				//If condition to run the code in headless chrome mode
				if(headlessChrome.equals("yes")) {
					co.addArguments("--headless");  // Ensure GUI is off
					co.addArguments("--window-size=1920,1080");
				}
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(co);
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "Safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			default:
				driver = new ChromeDriver();
				break;
			}
		} else {
			if (remoteOS.contains("Windows")) {
				caps.setCapability("os", remoteOS);
				caps.setCapability("os_version", remoteWinVersion);
				caps.setCapability("browser", browserName);
				caps.setCapability("browser_version", remoteWinBrowserVersion);
				browserstackOptions.put("buildName", "win_" + format);
			} else if (remoteOS.contains("OS X")) {
				caps.setCapability("browserName", prop.getProperty("macBrowserName"));
				caps.setCapability("browserVersion", prop.getProperty("macBrowserVersion"));
				browserstackOptions.put("os", remoteOS);
				browserstackOptions.put("osVersion", prop.getProperty("macOsVersion"));
				//browserstackOptions.put("local", "false");
				//browserstackOptions.put("seleniumVersion", "3.14.0");
				browserstackOptions.put("buildName", "mac_" + format);
			}
			browserstackOptions.put("projectName", prop.getProperty("projectName"));
			browserstackOptions.put("buildTag", prop.getProperty("buildTag"));
			caps.setCapability("name", prop.getProperty("name"));
			caps.setCapability("browserstack.idleTimeout", prop.getProperty("browserstackIdleTimeout"));
			caps.setCapability("newCommandTimeout", prop.getProperty("newCommandTimeout"));
			caps.setCapability("bstack:options", browserstackOptions);

			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		home = new HomePage();
		header = new HeaderPage();
		footer = new FooterPage();
		index = new IndexPage();
		PLP = new ProductListingPage();
		PDP = new ProductDisplayPage();
		cart = new CartPage();
		shipping = new ShippingPage();
		forgotpassword = new ForgotPasswordPage();
		holiday = new HolidayPage();
		ourStory = new OurStoryPage();
		registration = new RegistrationPage();
		quiz = new QuizPage();

		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
	}

	public static void extentMarkupLog(Markup markup) {
		test.log(Status.INFO, markup);
	}

	public static void extentInfoLog(String text, Object object) {
		test.log(Status.INFO, text + "" + object);
	}

	public static void extentPassLog(String text, Object object) {
		test.log(Status.PASS, text + "" + object);
	}

	public static void extentFailLog(String text, Object object) {
		test.log(Status.FAIL, text + "" + object);
	}

	public static void extentSkipLog(String text, Object object) {
		test.log(Status.SKIP, text + "" + object);
	}
	
	public void assertTrueBS(Boolean actualFlag, String positiveMsg, String negMsg) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		if (actualFlag.equals(true)) {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+positiveMsg+"\"}}");
		}
		else {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+negMsg+"\"}}");
		}
	}
	
	public void assertFalseBS(Boolean actualFlag, String positiveMsg, String negMsg) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		if (actualFlag.equals(false)) {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+positiveMsg+"\"}}");
		}
		else {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+negMsg+"\"}}");
		}
	}
	
	public void assertEqualsBS(Object expectedString, Object actualString, String positiveMsg, String negMsg) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		if (actualString.equals(expectedString)) {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+positiveMsg+"\"}}");
		}
		else {
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \""+negMsg+"\"}}");
		}
	}

	/**
	 * Select environment to run tests on
	 *
	 * @param runOn pass environment as a String
	 */
	public static void selectEnv(String runOn) {
		if (runOn.equalsIgnoreCase("staging")) {
			baseURI = prop.getProperty("stage_url");
		} else if (runOn.equalsIgnoreCase("live")) {
			baseURI = prop.getProperty("live_url");
		}
		driver.get(baseURI);
	}



}
