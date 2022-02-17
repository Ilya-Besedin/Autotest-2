package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {
    public void setStateAndCity(String state, String city){
        $("#submit").scrollIntoView(true);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
    }
}
