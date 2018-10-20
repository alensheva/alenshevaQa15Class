package com.telran.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");

        login("admin", "secret");

    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        wd.findElement(By.cssSelector("[type=submit")).click();
    }

    public void returnToGroupsPage() {
        wd.findElement(By.cssSelector("i a[href=\"group.php\"]")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void openGroupsPage() {
        wd.findElement(By.cssSelector("[href=\"group.php\"]")).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();

    }

    public void submitGroupModification() {

        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification() {
        wd.findElement(By.cssSelector("[name=edit]:last-child")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();

    }

    public void deleteGroup() {
        wd.findElement(By.xpath("//input[@name='delete'][2]")).click();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }


    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillContactForm(String firstName, String lastName, String City, String telephone) {
        type(By.name("firstname"), firstName);
        type(By.name("lastname"), lastName);
        type(By.name("address"), City);
        type(By.name("mobile"), telephone);
    }

    public void openAddNewContactPage() {
        wd.findElement(By.cssSelector("[href='edit.php']")).click();
    }

    public void updateContact() {
        wd.findElement(By.name("update")).click();
    }

    public void editContact() {
        wd.findElement(By.xpath("//a[@href='edit.php?id=3']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
        //этот селект вообще нужен?ведь и без нажатия на него можно сделать Edit
    }

    public void deleteContact() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();

    }

    protected void acceptDelete() {
        wd.switchTo().alert().accept();
    }
}
