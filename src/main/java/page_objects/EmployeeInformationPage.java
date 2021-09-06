package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byXpath;

public class EmployeeInformationPage {
    private SelenideElement employeeNameField = $(byXpath("//input[@id='empsearch_employee_name_empName']"));
    private SelenideElement subUnitSelect = $(byXpath("//select[@id='empsearch_sub_unit']"));
    private SelenideElement searchBtn = $(byXpath("//input[@id='searchBtn']"));
    private SelenideElement deleteBtn = $(byXpath("//input[@id='btnDelete']"));
    private ElementsCollection employeeList = $$(byXpath("//table[@id='resultTable']/tbody/tr"));

    public void waitEmployeeInformationPage() { employeeNameField.shouldBe(Condition.visible); }

    private void setEmployeeNameField(String firstName, String secondName){
        employeeNameField.sendKeys(firstName + " " + secondName);
    }

    @Step("Select 'Sub unit' = Sales in employee information page")
    private void setSubUnitSalesSelect() { subUnitSelect.selectOption(7); }

    @Step("Click 'Search' button to search employee")
    private void clickSearchBtn() { searchBtn.click(); }

    @Step("Click 'Delete' button to delete employee")
    public void clickDeleteBtn() { deleteBtn.click(); }

    @Step("Search employee with 'Sub unit' = Sales")
    public void searchEmployeeWithSalesSubUnit(){
        setSubUnitSalesSelect();
        clickSearchBtn();
        employeeList.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(0));
    }

    @Step("Go to first entry in employee table")
    public void toFirstInEmployeeList(){ employeeList.get(0).$(byXpath("descendant::a[1]")).click(); }

    public boolean isEmployeeExist(String firstName){
        boolean result = false;
        for(int i = 0; i < employeeList.size(); i++){
            if(employeeList.get(i).$(byXpath("descendant::a[2]")).text().equals(firstName)){
                result = true;
            }
        }
        return result;
    }

    @Step("Select employee in employee table")
    public void selectEmployee(String firstName){

        for(int i = 0; i < employeeList.size(); i++){
            if(employeeList.get(i).$(byXpath("descendant::a[2]")).text().equals(firstName)){
                employeeList.get(i).$(byXpath("descendant::input")).click();
            }
        }
    }

}
