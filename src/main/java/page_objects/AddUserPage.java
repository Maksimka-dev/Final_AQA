package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.User;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddUserPage {
    private SelenideElement userRoleSelect = $(byXpath("//select[@id='systemUser_userType']"));
    private SelenideElement employeeNameField = $(byXpath("//input[@id='systemUser_employeeName_empName']"));
    private SelenideElement userNameField = $(byXpath("//input[@id='systemUser_userName']"));
    private SelenideElement statusSelect = $(byXpath("//select[@id='systemUser_status']"));
    private SelenideElement passwordField = $(byXpath("//input[@id='systemUser_password']"));
    private SelenideElement confirmPasswordField = $(byXpath("//input[@id='systemUser_confirmPassword']"));
    private SelenideElement saveBtn = $(byXpath("//input[@id='btnSave']"));

    @Step("Select 'User role' in add User page")
    private void selectUserRole(String role){ userRoleSelect.sendKeys(role); }

    @Step("Enter 'Employee name' in add User page")
    private void setEmployeeNameField(String fullName){ employeeNameField.sendKeys(fullName); }

    @Step("Enter 'User name' in add User page")
    private void setUserNameField(String userName){ userNameField.sendKeys(userName); }

    @Step("Select 'Status' in add User page")
    private void selectStatus(String status){ statusSelect.sendKeys(status); }

    @Step("Enter 'Password' in add User page")
    private void setPasswordField(Integer password){ passwordField.sendKeys(password.toString()); }

    @Step("Enter 'Confirm password' in add User page")
    private void setConfirmPasswordField(Integer confirmPassword){ confirmPasswordField.sendKeys(confirmPassword.toString()); }

    @Step("Click 'Save' button to save User")
    private void clickSaveBtn(){ saveBtn.click(); }

    @Step("Enter user fields and save")
    public void enterAddUserFields(User user){
        selectUserRole(user.getRole());
        setEmployeeNameField(user.getFirstName() + " " + user.getLastName());
        setUserNameField(user.getUserName());
        selectStatus(user.getStatus());
        setPasswordField(user.getPassword());
        setConfirmPasswordField(user.getPassword());
        clickSaveBtn();
    }
}
