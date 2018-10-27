package com.telran.addressbook.test;

import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        int before = app.getContactCount();
        app.openAddNewContactPage();
        app.fillContactForm(new Contact().setFirstName("Elena")
                .setLastName("ShevAchenko")
                .setCity("Holon")
                .setTelephone("0526447204"));
        app.submitContactCreation();
        int after = app.getContactCount();
        Assert.assertEquals(after,before+1);

        //returnContactPage не делаю, ибо страница сама перенаправляется через пару
        //секунд в список контактов.
    }


}
