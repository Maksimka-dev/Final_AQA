package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.ConfProperties;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userNameField = $(byXpath("//input[@id='txtUsername']"));
    private SelenideElement passwordField = $(byXpath("//input[@id='txtPassword']"));
    private SelenideElement loginBtn = $(byXpath("//input[@id='btnLogin']"));

    @Step("Enter 'User name' in login page")
    private void setUserNameField(String text) { userNameField.sendKeys(text); }

    @Step("Enter 'Password' in login page")
    private void setPasswordField(String text) { passwordField.sendKeys(text); }

    @Step("Click 'Login' button to login")
    private void clickLoginBtn() { loginBtn.click(); }

    @Step("Login")
    public void login(){
        loginBtn.shouldBe(Condition.visible);
        setUserNameField(ConfProperties.getProperty("username"));
        setPasswordField(ConfProperties.getProperty("password"));
        clickLoginBtn();
    }
}
