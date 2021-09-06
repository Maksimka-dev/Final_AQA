package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.AssignLeave;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class AssignListPage {
    private SelenideElement markerAssignListPage = $(byXpath("//label[@for='leaveList_chkSearchFilter']"));
    private SelenideElement dataFromField = $(byXpath("//input[@id='calFromDate']"));
    private SelenideElement dataToField = $(byXpath("//input[@id='calToDate']"));
    private SelenideElement employeeNameField = $(byXpath("//input[@id='leaveList_txtEmployee_empName']"));
    private SelenideElement showAllStatusLeaveCheckbox = $(byXpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']"));
    private SelenideElement searchAssignBtn = $(byXpath("//input[@id='btnSearch']"));
    private ElementsCollection assignList = $$(byXpath("//table[@id='resultTable']/tbody/tr"));

    public void waitAssignLeavePage(){ markerAssignListPage.shouldBe(Condition.visible); }

    @Step("Enter 'From date' in Assign list page")
    private void setDataFromField(String text) {
        dataFromField.click();
        dataFromField.clear();
        dataFromField.sendKeys(text);
        dataFromField.pressEnter();
    }

    @Step("Enter 'To date' in Assign list page")
    private void setDataToField(String text) {
        dataToField.click();
        dataToField.clear();
        dataToField.sendKeys(text);
        dataToField.pressEnter();
    }

    @Step("Enter 'Name' in Assign list page")
    private void setEmployeeNameField(String text) { employeeNameField.sendKeys(text); }

    @Step("Click checkbox show status 'All' in Assign list page")
    private void clickShowAllStatusLeaveCheckbox() { showAllStatusLeaveCheckbox.click(); }

    @Step("Click 'Search' button in Assign list page")
    private void clickSearchAssignBtn() { searchAssignBtn.click(); }

    @Step("Enter search assign fields and save")
    private void enterSearchAssignLeave(AssignLeave assignLeave) {
        setDataFromField(assignLeave.getFromDate());
        setDataToField(assignLeave.getToDate());
        setEmployeeNameField(assignLeave.getEmployeeFullName());
        clickShowAllStatusLeaveCheckbox();
        clickSearchAssignBtn();
    }

    @Step("Check assign in assign table is")
    public boolean isAssignInAssignTable(AssignLeave assignLeave){
        boolean result = false;
        enterSearchAssignLeave(assignLeave);

        assignList.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(0));

        if(assignList.size() > 0){
            result = true;
        }

        return result;
    }



}
