package com.telran.addressbook.test;

import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().openAddNewContactPage();
        app.getContactHelper().fillContactForm(new Contact().setFirstName("Elena")
                .setLastName("ShevAchenko")
                .setCity("Holon")
                .setTelephone("0526447204"));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after, before + 1);

    }


}
