package com.telran.addressbook.manager;

import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public SessionHelper sessionHelper;
    WebDriver wd;

    public GroupHelper groupHelper;

    public NavigationHelper navigationHelper;

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);

    }



    public void stop() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();
    }

    public void acceptDelete() {
        wd.switchTo().alert().accept();
    }

    public void openAddNewContactPage() {
        groupHelper.click(By.cssSelector("[href='edit.php']"));
    }

    public void fillContactForm(Contact contact) {
        groupHelper.type(By.name("firstname"), contact.getFirstName());
        groupHelper.type(By.name("lastname"), contact.getLastName());
        groupHelper.type(By.name("address"), contact.getCity());
        groupHelper.type(By.name("mobile"), contact.getTelephone());
    }

    public void submitContactCreation() {
        groupHelper.click(By.name("submit"));
    }

    public void selectContact() {
        groupHelper.click(By.name("selected[]"));
    }

    public void editContact() {
        groupHelper.click(By.xpath("//img[@title='Edit']"));
    }

    public void updateContact() {
        groupHelper.click(By.name("update"));
    }

    public void deleteContact() {
        groupHelper.click(By.xpath("//input[@value='Delete']"));

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
        return groupHelper.isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectContactByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
