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

        //Часть 1. Проверка заполнения обязательных форм
        //заполняем текстовые формы
        $("#firstName").setValue("IvAn");
        $("#lastName").setValue("123456");
        $("#userEmail").setValue("test@mail.com");
        $("#userNumber").setValue("0123456789");
        $("#currentAddress").setValue("New York, NY 10004, USA, 17 Broadway");

        //отмечаем радиобаттоны и чекбоксы
        $(byText("Male")).click();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $(byText("Reading")).click();

        //открываем дата-пикер
        $("#dateOfBirthInput").click();
        //выбираем даты
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__day--014").click();

        //кликаем Submit
        $("#submit").click();

    }
}
