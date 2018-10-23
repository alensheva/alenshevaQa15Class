package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwContactModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!isContactPresent()) {
            createContact();
        }
    }

    @Test
    public void testContactModification() {
        selectContact();
        editContact();
        fillContactForm(new Contact()
                .setFirstName("Petr")
                .setLastName("Bah")
                .setTelephone("05264454")
                .setCity("TA"));
        updateContact();
        //returnContactPage не делаю, ибо страница сама перенаправляется через пару
        //секунд в список контактов.
    }

}
