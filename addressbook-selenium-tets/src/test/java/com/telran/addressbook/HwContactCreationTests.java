package com.telran.addressbook;

import org.testng.annotations.Test;

public class HwContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        openAddNewContactPage();
        fillContactForm(new Contact().setFirstName("Elena")
                .setLastName("ShevAchenko")
                .setCity("Holon")
                .setTelephone("0526447204"));
        submitContactCreation();

        //returnContactPage не делаю, ибо страница сама перенаправляется через пару
        //секунд в список контактов.
    }

}
