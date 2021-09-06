package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import value_objects.JobTitle;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddJobTitlePage {
    private SelenideElement jobTitleField = $(byXpath("//input[@id='jobTitle_jobTitle']"));
    private SelenideElement jobDescriptionTextArea = $(byXpath("//textarea[@id='jobTitle_jobDescription']"));
    private SelenideElement noteTextArea = $(byXpath("//textarea[@id='jobTitle_note']"));
    private SelenideElement saveBtn = $(byXpath("//input[@id='btnSave']"));

    @Step("Enter 'Job title' in add Job title page")
    private void setJobTitleField(String text) { jobTitleField.sendKeys(text); }

    @Step("Enter 'Job description' in add Job title page")
    private void setJobDescriptionTextArea(String text) { jobDescriptionTextArea.sendKeys(text); }

    @Step("Enter 'Note' in add Job title page")
    private void setNoteTextArea(String text) { noteTextArea.sendKeys(text); }

    @Step("Click 'Save' button to save Job title")
    private void clickSaveBtn() { saveBtn.click(); }

    @Step("Enter job title fields and save")
    public void enterJobTitlesField(JobTitle jobTitle) {
        setJobTitleField(jobTitle.getJobTitle());
        if(jobTitle.getJobDescription() != null){ setJobDescriptionTextArea(jobTitle.getJobDescription()); }
        if(jobTitle.getNote() != null){ setNoteTextArea(jobTitle.getNote()); }
        clickSaveBtn();
    }
}
