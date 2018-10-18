package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {
    @Test
    public void testGroupDeletion(){
        openGroupsPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
    }

}
