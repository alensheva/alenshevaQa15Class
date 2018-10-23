package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
    @BeforeMethod
    public void preconditions() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup();
        }
    }

    @Test
    public void testGroupModification(){
        openGroupsPage();
        int before =getGroupsCount();
        selectGroupByIndex(before-1);
        initGroupModification();
        fillGroupForm(new Group()
                .setGroupHeader("modifyed")
                .setGroupName("new")
                .setGroupFooter("changed"));
        submitGroupModification();
        returnToGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before);
    }

}
