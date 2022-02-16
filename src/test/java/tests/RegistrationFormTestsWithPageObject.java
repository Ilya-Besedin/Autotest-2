package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationFormTestsWithPageObject extends TestBase {

    //первая часть - тип переменной, вторая - переменная, третья - фукнция
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {

        //открываем страницу и заполняем имя (используется вызов RegistrationPage после открытия страницы)
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserNumber(phone)
                .setCurrentAddress(address);

        //отмечаем радиобаттоны и чекбоксы
        $(byText("Male")).click();
        // $(byText("Sports")).click();
        $("#hobbies-checkbox-1").parent().click(); //другой вариант записи строки выше
        $(byText("Music")).click();
        $(byText("Reading")).click();

        //выбираем изучаемый предмет
        $("#subjectsInput").setValue(subject).pressEnter();

        //дата-пикер
        $("#dateOfBirthInput").click();
        //выбираем даты
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__day--014:not(.react-datepicker__day--outside-month)").click(); //исключили повторяющиеся даты вне месяца

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
        registrationPage.checkOpenTable(tableHeader);
        registrationPage.checkTable("Student Name", firstName + ' ' + lastName);
        registrationPage.checkTable("Student Email", email);
        registrationPage.checkTable("Gender", "Male");
        registrationPage.checkTable("Mobile", phone);
        registrationPage.checkTable("Date of Birth", "14 June,1999");
        registrationPage.checkTable("Subjects", "Economics");
        registrationPage.checkTable("Hobbies", "Sports, Music, Reading");
        registrationPage.checkTable("Picture", "JPEG.jpg");
        registrationPage.checkTable("Address", address);
        registrationPage.checkTable("State and City", "Haryana Karnal");

    }
}