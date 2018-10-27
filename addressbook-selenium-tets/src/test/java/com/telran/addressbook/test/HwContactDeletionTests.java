package com.telran.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!app.isContactPresent()) {
            app.createContact();
        }
    }

    @Test
    public void testDeleteContact() {
        int before = app.getContactCount();
        app.selectContact();
        app.deleteContact();
        app.acceptDelete();
      int after = app.getContactCount();
        Assert.assertEquals(after,before-1);
    }

}
