package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationFormTestsWithPageObject extends TestBase {

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //заполняем текстовые формы
        new RegistrationPages().setFirstName(firstName);
        new RegistrationPages().setLastName(lastName);
        new RegistrationPages().setUserEmail(email);
        new RegistrationPages().setUserNumber(phone);
        new RegistrationPages().setCurrentAddress(address);

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
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        new RegistrationPages().checkForm("Student Name", firstName + ' ' + lastName);
        new RegistrationPages().checkForm("Student Email", email);
        new RegistrationPages().checkForm("Gender", "Male");
        new RegistrationPages().checkForm("Mobile", phone);
        new RegistrationPages().checkForm("Date of Birth", "14 June,1999");
        new RegistrationPages().checkForm("Subjects", "Economics");
        new RegistrationPages().checkForm("Hobbies", "Sports, Music, Reading");
        new RegistrationPages().checkForm("Picture", "JPEG.jpg");
        new RegistrationPages().checkForm("Address", address);
        new RegistrationPages().checkForm("State and City", "Haryana Karnal");

    }
}