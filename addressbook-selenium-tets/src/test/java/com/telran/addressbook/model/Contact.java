package com.telran.addressbook.model;

public class Contact {
    private String firstName;
    private String lastName;
    private String city;
    private String telephone;
    private String group;

    public String getGroup() {
        return group;
    }

    public Contact setGroup(String group) {
        this.group = group;
        return this;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setCity(String city) {
        this.city = city;
        return this;
    }

    public Contact setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }
}
