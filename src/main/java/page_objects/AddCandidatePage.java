package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.Candidate;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddCandidatePage {
    private SelenideElement firstNameField = $(byXpath("//input[@id='addCandidate_firstName']"));
    private SelenideElement lastNameField = $(byXpath("//input[@id='addCandidate_lastName']"));
    private SelenideElement emailField = $(byXpath("//input[@id='addCandidate_email']"));
    private SelenideElement saveBtn = $(byXpath("//input[@id='btnSave']"));

    @Step("Enter 'First Name' in add candidate page")
    private void setFirstNameField(String text) { firstNameField.sendKeys(text); }

    @Step("Enter 'Last Name' in add candidate page")
    private void setLastNameField(String text) { lastNameField.sendKeys(text); }

    @Step("Enter 'Email' in add candidate page")
    private void setEmailField(String text) { emailField.sendKeys(text); }

    @Step("Click 'Save' button to save candidate")
    private void clickSaveBtn() { saveBtn.click(); }

    @Step("Enter candidate fields and save")
    public void enterCandidateField(Candidate candidate){
        setFirstNameField(candidate.getFirstName());
        setLastNameField(candidate.getLastName());
        setEmailField(candidate.getEmail());
        clickSaveBtn();
    }
}
