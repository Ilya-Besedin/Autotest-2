package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.firstName;
import static tests.TestData.lastName;

public class RegistrationPages {

    // locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement resultsTable = $(".table-responsive");

    // actions
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }
    public void setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
    }

    public void checkForm(String fieldName, String value) {
        resultsTable.$(byText (fieldName))
                .parent().shouldHave(text(value));
    }




}