package com.telran.addressbook;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!isContactPresent()) {
            createContact();
        }
    }

    @Test
    public void testDeleteContact() {
        selectContact();
        deleteContact();
        acceptDelete();
        //returnContactPage не делаю, ибо страница сама перенаправляется через пару
        //секунд в список контактов.
    }

}
