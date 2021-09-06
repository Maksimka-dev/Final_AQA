package page_elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePanel {
    private SelenideElement welcomeBtn = $(byXpath("//a[@id='welcome']"));
    private SelenideElement aboutBtn = $(byXpath("//a[@id='aboutDisplayLink']"));
    private SelenideElement supportBtn = $(byXpath("//a[text()='Support']"));
    private SelenideElement logoutBtn = $(byXpath("//a[text()='Logout']"));

    public void waitWelcomePanel(){ welcomeBtn.shouldBe(Condition.visible); }

    public void clickWelcomeBtn() { welcomeBtn.click(); }

    public void clickLogoutBtn(){ logoutBtn.click(); }

    @Step("Logout")
    public void logout(){
        clickWelcomeBtn();
        clickLogoutBtn();
    }

}
