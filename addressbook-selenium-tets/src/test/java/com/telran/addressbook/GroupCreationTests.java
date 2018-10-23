package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        int before = getGroupsCount();

        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("jjjjj")
                .setGroupFooter("ghg"));
        submitGroupCreation();
        returnToGroupsPage();


        int after = getGroupsCount();
        Assert.assertEquals(after,before+1);

    }


}
