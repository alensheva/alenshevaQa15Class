package com.telran.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact();
        }
    }

    @Test
    public void testDeleteContact() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptDelete();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}
