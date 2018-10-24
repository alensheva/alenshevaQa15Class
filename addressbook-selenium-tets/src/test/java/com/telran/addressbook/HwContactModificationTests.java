package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwContactModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.isContactPresent()) {
            app.createContact();
        }
    }

    @Test
    public void testContactModification() {
        int before = app.getContactCount();
        app.selectContactByIndex(before-1);
        app.selectContact();
        app.editContact();
        app.fillContactForm(new Contact()
                .setFirstName("Petr")
                .setLastName("Bah")
                .setTelephone("05264454")
                .setCity("TA"));
        app.updateContact();
        int after = app.getContactCount();
        Assert.assertEquals(after,before);
    }


}
