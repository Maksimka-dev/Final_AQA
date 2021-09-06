package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class PersonalDetailsPage {
    private SelenideElement firstNameField = $(byXpath("//input[@id='personal_txtEmpFirstName']"));
    private SelenideElement middleNameField = $(byXpath("//input[@id='personal_txtEmpMiddleName']"));
    private SelenideElement lastNameField = $(byXpath("//input[@id='personal_txtEmpLastName']"));
    private SelenideElement employeeIdField = $(byXpath("//input[@id='personal_txtEmployeeId']"));
    private SelenideElement driverLicenseNumberField = $(byXpath("//input[@id='personal_txtLicenNo']"));
    private SelenideElement ssnNumberField = $(byXpath("//input[@id='personal_txtNICNo']"));
    private SelenideElement otherIdField = $(byXpath("//input[@id='personal_txtOtherID']"));
    private SelenideElement licenseExpiryDateField = $(byXpath("//input[@id='personal_txtLicExpDate']"));
    private SelenideElement sinNumberField = $(byXpath("//input[@id='personal_txtSINNo']"));
    private SelenideElement genderMaleRadioBtn = $(byXpath("//input[@id='personal_optGender_1']"));
    private SelenideElement genderFemaleRadioBtn = $(byXpath("//input[@id='personal_optGender_2']"));
    private SelenideElement nationalitySelect = $(byXpath("//select[@id='personal_cmbNation']"));
    private SelenideElement maritalStatusSelect = $(byXpath("//select[@id='personal_cmbMarital']"));
    private SelenideElement dateOfBirthField = $(byXpath("//input[@id='personal_DOB']"));
    private SelenideElement editBtn = $(byXpath("//input[@id='btnSave']"));

    @Step("Check personal details elements is visible")
    public void shouldBeVisibleAllField(){

        firstNameField.shouldBe(Condition.visible);
        middleNameField.shouldBe(Condition.visible);
        lastNameField.shouldBe(Condition.visible);
        employeeIdField.shouldBe(Condition.visible);
        driverLicenseNumberField.shouldBe(Condition.visible);
        ssnNumberField.shouldBe(Condition.visible);
        otherIdField.shouldBe(Condition.visible);
        licenseExpiryDateField.shouldBe(Condition.visible);
        sinNumberField.shouldBe(Condition.visible);
        genderMaleRadioBtn.shouldBe(Condition.visible);
        genderFemaleRadioBtn.shouldBe(Condition.visible);
        nationalitySelect.shouldBe(Condition.visible);
        maritalStatusSelect.shouldBe(Condition.visible);
        dateOfBirthField.shouldBe(Condition.visible);
        editBtn.shouldBe(Condition.visible);
    }
}
