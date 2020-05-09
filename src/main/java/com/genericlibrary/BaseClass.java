package com.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    PropertiesFileReaderWriter pReader = new PropertiesFileReaderWriter();
    Properties prt = pReader.getPropertiesFileReader();

    @BeforeClass
    public void driverSetUp() {
        String BrowserType = prt.getProperty("Browser");
        switch (BrowserType) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
    }

    @BeforeMethod
    public void initializeUrl() {
        prt.setProperty("Url", "http://automationpractice.com/index.php");
        driver.get(prt.getProperty("Url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
