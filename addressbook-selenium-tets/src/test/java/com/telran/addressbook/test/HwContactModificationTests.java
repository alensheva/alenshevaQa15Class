package com.telran.addressbook.test;

import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwContactModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact();
        }
    }

    @Test
    public void testContactModification() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContactByIndex(before - 1);
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new Contact()
                .setFirstName("Petr")
                .setLastName("Bah")
                .setTelephone("05264454")
                .setCity("TA"));
        app.getContactHelper().updateContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }


}
