package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice form"));

        //заполняем текстовые формы
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Leonov");
        $("#userEmail").setValue("test@mail.com");
        $("#userNumber").setValue("0123456789");
        $("#currentAddress").setValue("New York, NY 10004, USA, 17 Broadway");

        //отмечаем радиобаттоны и чекбоксы
        $(byText("Male")).click();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $(byText("Reading")).click();

        //выбираем изучаемый предмет
        $("#subjectsInput").setValue("Economics").pressEnter();

        //дата-пикер
        $("#dateOfBirthInput").click();
        //выбираем даты
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__day--014").click();

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
        $(".table-responsive").shouldHave(text("Student Name Ivan Leonov"), text("Student Email test@mail.com"),
                text("Gender Male"), text("Mobile 0123456789"), text("Date of Birth 14 June,1999"),
                text("Subjects Economics"), text("Hobbies Sports, Music, Reading"), text("Picture JPEG.jpg"),
                text("Address New York, NY 10004, USA, 17 Broadway"), text("State and City Haryana Karnal"));

    }
}