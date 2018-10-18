package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupModioficationTests extends TestBase{
    @Test
    public void testGroupModification(){
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(new Group()
                .setGroupHeader("modifyed")
                .setGroupName("new")
                .setGroupFooter("changed"));
        submitGroupModification();
        returnToGroupsPage();
    }

}
