package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //заполняем текстовые формы
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phone);
        $("#currentAddress").setValue(address);

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

        //проверяем форму с результатом заполнения данных
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name Petr Leonov"), text("Student Email test@mail.com"),
                text("Gender Male"), text("Mobile 0123456789"), text("Date of Birth 14 June,1999"),
                text("Subjects Economics"), text("Hobbies Sports, Music, Reading"), text("Picture JPEG.jpg"),
                text("Address New York, NY 10004, USA, 17 Broadway"), text("State and City Haryana Karnal"));

    }
}