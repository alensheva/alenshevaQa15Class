package com.telran.addressbook.manager;

import com.telran.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

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

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }
}
