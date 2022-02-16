package pages;

import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.Text;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    // проверка открытия главной
    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }


    // locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement resultsTable = $(".table-responsive");
    SelenideElement resultTableHeader =  $(".modal-header");

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
    public void checkOpenTable(String header) {
        resultTableHeader.$(byText (header));
    }
    public void checkTable(String fieldName, String value) {
        resultsTable.$(byText (fieldName))
                .parent().shouldHave(text(value));
    }




}