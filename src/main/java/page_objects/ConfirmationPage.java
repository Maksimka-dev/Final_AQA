package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {
    private SelenideElement markerConfirmationPage = $(byXpath("//div[@id='deleteConfModal']"));
    private SelenideElement okBtn = $(byXpath("//input[@id='dialogDeleteBtn']"));

    @Step("Click 'Ok' button in confirmation page")
    public void clickOkBtn() { okBtn.click(); }

    public void waitConfirmationPage(){
        markerConfirmationPage.shouldBe(visible);
    }
}
