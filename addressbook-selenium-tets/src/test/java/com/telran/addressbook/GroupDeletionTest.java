package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        openGroupsPage();
        int before = getGroupsCount();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before - 1);
    }

}
