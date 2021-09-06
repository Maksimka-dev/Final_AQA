package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CandidatesPage {
    private SelenideElement candidateNameField = $(byXpath("//input[@id='candidateSearch_candidateName']"));
    private SelenideElement addCandidateBtn = $(byXpath("//input[@id='btnAdd']"));
    private SelenideElement searchCandidateBtn = $(byXpath("//input[@id='btnSrch']"));
    private ElementsCollection candidatesList = $$(byXpath("//table[@id='resultTable']/tbody/tr"));

    public void waitCandidatePage(){ candidateNameField.shouldBe(Condition.visible); }

    @Step("Enter 'Full name' in candidate page")
    public void setCandidateNameField(String firstNameCandidate, String lastNameCandidate){
        candidateNameField.sendKeys(firstNameCandidate + " " + lastNameCandidate);
    }

    @Step("Click 'Add' button to add candidate")
    public void clickAddCandidateBtn(){ addCandidateBtn.click(); }

    @Step("Click 'Search' button to search candidate")
    public void clickSearchCandidateBtn(){ searchCandidateBtn.click(); }

    @Step("Check candidate in candidate table is")
    public boolean isCandidateInCandidateTable(String firstNameCandidate, String lastNameCandidate){
        boolean result = false;
        setCandidateNameField(firstNameCandidate, lastNameCandidate);
        clickSearchCandidateBtn();
        candidatesList.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(0));

        if(candidatesList.size() > 0){
            for (int i = 0; i < candidatesList.size(); i++){
                if(candidatesList.get(i).$(byXpath("descendant::a")).text().equals(firstNameCandidate + " " + lastNameCandidate)){
                    result = true;
                }
            }
        }

        return result;
    }
}
