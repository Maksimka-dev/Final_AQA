package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.User;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class AddEmployeePage {
    private SelenideElement firstNameField = $(byXpath("//input[@id='firstName']"));
    private SelenideElement middleNameField = $(byXpath("//input[@id='middleName']"));
    private SelenideElement lastNameField = $(byXpath("//input[@id='lastName']"));
    private SelenideElement saveBtn = $(byXpath("//input[@id='btnSave']"));

    @Step("Enter 'First Name' in add employee page")
    private void setFirstNameField(String name) { firstNameField.sendKeys(name); }

    @Step("Enter 'Middle Name' in add employee page")
    private void setMiddleNameField(String name) { middleNameField.sendKeys(name); }

    @Step("Enter 'Last Name' in add employee page")
    private void setLastNameField(String name) { lastNameField.sendKeys(name); }

    @Step("Click 'Save' button to save employee")
    private void clickSaveBtn() { saveBtn.click(); }

    @Step("Enter employee fields and save")
    public void enterAddEmployeeField(User user){
        setFirstNameField(user.getFirstName());
        if(user.getMiddleName() != null) { setMiddleNameField(user.getMiddleName()); }
        setLastNameField(user.getLastName());
        clickSaveBtn();
    }
}
