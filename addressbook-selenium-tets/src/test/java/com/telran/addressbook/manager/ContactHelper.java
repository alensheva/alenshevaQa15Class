package com.telran.addressbook.manager;

import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void openAddNewContactPage() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getCity());
        type(By.name("mobile"), contact.getTelephone());
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void editContact() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        openAddNewContactPage();
        fillContactForm(new Contact().setFirstName("Elena")
                .setLastName("ShevEchenko")
                .setCity("Holon")
                .setTelephone("0526447204"));
        submitContactCreation();
    }

    public void acceptDelete() {
        wd.switchTo().alert().accept();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectContactByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
