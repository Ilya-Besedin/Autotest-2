package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    // locators
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            resultsTable = $(".table-responsive"),
            practiceFormHeader = $(".practice-form-wrapper"),
            resultTableHeader = $(".modal-header");

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

    public void setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

    }

    public void checkOpenTable(String tableHeader) {
        resultTableHeader.$(byText(tableHeader));
    }

    public void checkTable(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
    }


}