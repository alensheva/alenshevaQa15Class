package com.telran.addressbook.test;

import com.telran.addressbook.manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    public static class MyListener extends AbstractWebDriverEventListener{
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println("search:"+by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by+"found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);        }
    }

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.start();
    }

    @AfterSuite(alwaysRun = true)

    public void tearDown() throws InterruptedException {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start test" + m.getName());
    }

    @AfterMethod
    public void logTestStop(Method m) {
        logger.info("Stop test" + m.getName());
    }
}
