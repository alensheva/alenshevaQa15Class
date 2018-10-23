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

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();

    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("[type=submit"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void acceptDelete() {
        wd.switchTo().alert().accept();
    }

    //----------------Group--------------------------
    public void openGroupsPage() {
        click(By.cssSelector("[href=\"group.php\"]"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i a[href=\"group.php\"]"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));

    }

    public void initGroupModification() {
        click(By.cssSelector("[name=edit]:last-child"));
    }

    public void submitGroupModification() {

        click(By.name("update"));
    }

    public void deleteGroup() {
        click(By.xpath("//input[@name='delete'][2]"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("jjjjj")
                .setGroupFooter("ghg"));
        submitGroupCreation();
        returnToGroupsPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    protected void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }
    //-------------Contacts----------------------------------------

    public void openAddNewContactPage() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getCity());
        type(By.name("mobile"), contact.getTelephone());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
        //этот селект вообще нужен?ведь и без нажатия на него можно сделать Edit
    }

    public void editContact() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));

    }

    public void createContact() {
        openAddNewContactPage();
        fillContactForm(new Contact().setFirstName("Elena")
                .setLastName("ShevEchenko")
                .setCity("Holon")
                .setTelephone("0526447204"));
        submitContactCreation();
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }


}
