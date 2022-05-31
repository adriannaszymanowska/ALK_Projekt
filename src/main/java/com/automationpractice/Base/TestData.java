package com.automationpractice.Base;

import com.github.javafaker.Faker;

import java.util.Date;

public class TestData {
    Faker faker = new Faker();
    public String gender = faker.demographic().sex();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String emailAddress = faker.internet().emailAddress();
    public Date dateOfBirth = faker.date().birthday();
    public String streetAddress = faker.address().streetAddress();
    public String city = faker.address().city();
    public String state = faker.address().state();
    public String zipCode = faker.numerify("#####");
    public String mobilePhoneNumber = faker.phoneNumber().cellPhone();
    public String password = faker.internet().password(5, 10);
}
