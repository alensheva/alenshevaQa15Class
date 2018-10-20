package com.telran.addressbook;

import org.testng.annotations.Test;

public class HwContactModificationTests extends TestBase {

    @Test
    public void testContactMofication() {
        selectContact();
        editContact();
        fillContactForm("Petr", "Bah", "TA", "0526654");
        updateContact();
        //returnContactPage не делаю, ибо страница сама перенаправляется через пару
        //секунд в список контактов.
    }


}
