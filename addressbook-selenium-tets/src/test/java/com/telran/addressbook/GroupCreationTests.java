package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGoupCreation() {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("jjjjj")
                .setGroupFooter("ghg"));
        submitGroupCreation();
        returnToGroupsPage();

    }


}
