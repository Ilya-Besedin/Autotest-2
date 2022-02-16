package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationFormTestsWithPageObject extends TestBase {

    //первая часть - тип переменной, вторая - переменная, третья - фукнция
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {

        //открываем страницу и заполняем текстовые поля
        //используется вызов registrationPage после выполнения метода open page
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserNumber(phone)
                .setCurrentAddress(address);

        //отмечаем радиобаттоны и чекбоксы
        $(byText("Male")).click();
        $(byText("Sports")).click();
        //другой вариант записи строки выше
        //$("#hobbies-checkbox-1").parent().click();
        $(byText("Music")).click();
        $(byText("Reading")).click();

        //выбираем изучаемый предмет
        $("#subjectsInput").setValue(subject).pressEnter();

        registrationPage.setBirthDate("14", "June", "1999");

        //прикрепляем файл
        $("#uploadPicture").uploadFromClasspath("JPEG.jpg");

        //выбираем State and City
        $("#submit").scrollIntoView(true);
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();

        //кликаем Submit
        $("#submit").click();
        //sleep(10000000000000L);

        //проверяем форму с результатом заполнения данных
        registrationPage
                .checkOpenTable(tableHeader)
                .checkTable("Student Name", firstName + ' ' + lastName)
                .checkTable("Student Email", email)
                .checkTable("Gender", "Male")
                .checkTable("Mobile", phone)
                .checkTable("Date of Birth", "14 June,1999")
                .checkTable("Subjects", "Economics")
                .checkTable("Hobbies", "Sports, Music, Reading")
                .checkTable("Picture", "JPEG.jpg")
                .checkTable("Address", address)
                .checkTable("State and City", "Haryana Karnal");
    }
}