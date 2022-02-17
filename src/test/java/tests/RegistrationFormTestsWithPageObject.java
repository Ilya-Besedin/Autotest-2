package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationFormTestsWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserNumber(phone)
                .setCurrentAddress(address)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies()
                .setGender()
                .attachFile(attach)
                .setStateAndCity(state, city)
                .sendFilledForm()

                .checkOpenTable(tableHeader)
                .checkTable("Student Name", firstName + ' ' + lastName)
                .checkTable("Student Email", email)
                .checkTable("Gender", gender)
                .checkTable("Mobile", phone)
                .checkTable("Date of Birth", day + ' ' + month + ',' + year)
                .checkTable("Subjects", subject)
                .checkTable("Hobbies", hobbies)
                .checkTable("Picture", attach)
                .checkTable("Address", address)
                .checkTable("State and City", state + ' ' + city);
    }
}