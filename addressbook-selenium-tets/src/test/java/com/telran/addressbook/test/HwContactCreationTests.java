package com.telran.addressbook.test;

import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HwContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]>validContacts() throws IOException {
        List<Object[]>list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while(line!=null){
            String [] split = line.split(";");
            list.add(new Object[]{new Contact()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setCity(split[2])
                    .setTelephone(split[3])});
             line = reader.readLine();
        }
//        list.add(new Object[] {"testName1","lastName1","city1","tel1"});
//        list.add(new Object[] {"testName2","lastName2","city2","tel2"});
//        list.add(new Object[] {"testName3","lastName3","city3","tel3"});
//        list.add(new Object[] {"testName4","lastName4","city4","tel4"});

        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(Contact contact) {

        int before = app.getContactHelper().getContactCount();

        app.getContactHelper().openAddNewContactPage();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after, before + 1);

    }


}
