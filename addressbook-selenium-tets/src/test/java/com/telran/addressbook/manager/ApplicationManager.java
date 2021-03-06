package com.telran.addressbook.manager;

import com.telran.addressbook.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public SessionHelper sessionHelper;
    public GroupHelper groupHelper;
    public ContactHelper contactHelper;
    public NavigationHelper navigationHelper;
    EventFiringWebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            wd =new EventFiringWebDriver(new ChromeDriver());

        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd =new EventFiringWebDriver(new FirefoxDriver());

        } else if (browser.equals(BrowserType.IE)) {
            wd =new EventFiringWebDriver(new InternetExplorerDriver());
        }
        wd.register(new TestBase.MyListener());


        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navigationHelper = new NavigationHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook/");
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void stop() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();
    }

    public void submitModification() {
        groupHelper.click(By.name("update"));
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

}
