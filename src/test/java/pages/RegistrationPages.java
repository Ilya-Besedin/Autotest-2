package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPages {

    // locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement currentAddressInput = $("#currentAddress");

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
}