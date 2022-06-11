package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LoginTest {
    //What is log? : capturing info/activities at the time of program execution.
    // types of logs:(Level of logs)
    //1. info
    //2. warning
    //3. debug
    //4. fatal

    //how to generate the logs? : use Apache log4j API (log4j jar)
    //How it works? : it reads log 4j configuration from log4j.properties file
    //where to create: create inside resources folder

            Logger log = Logger.getLogger("LoginTest.class");
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\IdeaProjects\\ProjectObjectFramework\\src\\main\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        log.info("launching chrome browser");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/index.html");
        log.info("entering application URL");
        log.warning("Hey this just a warning message");
    }
    @Test(priority=1)
    public void freeCRMTitleTest(){
        log.info("****************************** freeCrmTitleTest *****************************************");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority=2)
    public void freeCRMLogoTest(){
        boolean b= driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
        Assert.assertTrue(b);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
