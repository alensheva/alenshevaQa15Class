package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGoupCreation() {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm("Qa15", "jjjjj", "ghg");
        submitGroupCreation();
        returnToGroupsPage();

    }


}
