package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;

public class RegistrationPage {

    //components
    CalendarComponent calendarComponent = new CalendarComponent();
    StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    // locators
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderInput = $(byText(gender)),
            hobbiesInput = $(byText(hobbies)),
            subjectInput = $("#subjectsInput"),
            fileUpload = $("#uploadPicture"),
            resultsTable = $(".table-responsive"),
            submitButton = $("#submit"),
            practiceFormHeader = $(".practice-form-wrapper"),
            resultsTableHeader = $(".modal-header");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormHeader.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setGender(){
        genderInput.click();
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbiesInput.click();
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage attachFile(String attach) {
        fileUpload.uploadFromClasspath(attach);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateAndCityComponent.setStateAndCity(state, city);
        return this;
    }

    public RegistrationPage sendFilledForm(){
        submitButton.click();
        return this;
    }

    public RegistrationPage checkOpenTable(String tableHeader) {
        resultsTableHeader.$(byText(tableHeader));
        return this;
    }

    public RegistrationPage checkTable(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}