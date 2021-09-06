package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.AssignLeave;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class AssignLeavePage {
    private SelenideElement employeeFullNameField = $(byXpath("//input[@id='assignleave_txtEmployee_empName']"));
    private SelenideElement leaveTypeSelect = $(byXpath("//select[@id='assignleave_txtLeaveType']"));
    private SelenideElement fromDateField = $(byXpath("//input[@id='assignleave_txtFromDate']"));
    private SelenideElement toDateField = $(byXpath("//input[@id='assignleave_txtToDate']"));
    private SelenideElement assignBtn = $(byXpath("//input[@id='assignBtn']"));

    @Step("Enter 'Full name' in Assign leave page")
    private void setEmployeeFullNameField(String text) { employeeFullNameField.sendKeys(text); }

    @Step("Select 'Leave type' in Assign leave page")
    private void setLeaveTypeSelect(String text) { leaveTypeSelect.sendKeys(text); }

    @Step("Enter 'From date' in Assign leave page")
    private void setFromDateField(String text) {
        fromDateField.click();
        fromDateField.sendKeys(text);
        fromDateField.pressEnter();
    }

    @Step("Enter 'To date' in Assign leave page")
    private void setToDateField(String text) {
        toDateField.click();
        toDateField.clear();
        toDateField.sendKeys(text);
        toDateField.pressEnter();
    }

    @Step("Click 'Assign' button to assign Leave")
    private void clickAssignBtn() { assignBtn.click(); }

    @Step("Enter Leave fields and save")
    public void enterAssignLeaveField(AssignLeave assignLeave){
        setEmployeeFullNameField(assignLeave.getEmployeeFullName());
        setLeaveTypeSelect(assignLeave.getLeaveType());
        setFromDateField(assignLeave.getFromDate());
        setToDateField(assignLeave.getToDate());
        clickAssignBtn();
    }
}
