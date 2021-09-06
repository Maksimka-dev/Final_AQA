package page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JobTitlesPage {
    private SelenideElement addJobTitlesBtn = $(byXpath("//input[@id='btnAdd']"));
    private SelenideElement deleteJobTitlesBtn = $(byXpath("//input[@id='btnDelete']"));
    private ElementsCollection jobTitlesList = $$(byXpath("//table[@id='resultTable']/tbody/tr"));

    @Step("Click 'Add' button to add job title")
    public void clickAddJobTitlesBtn(){ addJobTitlesBtn.click(); }

    @Step("Click 'Delete' button to delete job title")
    public void clickDeleteJobTitlesBtn(){ deleteJobTitlesBtn.click(); }

    @Step("Check title in job title table is")
    public boolean isTitleExist(String title){
        boolean result = false;
        for(int i = 0; i < jobTitlesList.size(); i++){
            if(jobTitlesList.get(i).$(byXpath("descendant::a")).text().equals(title)){
                result = true;
            }
        }
        return result;
    }

    @Step("Select title in job title table")
    public void selectJobTitle(String title){

        for(int i = 0; i < jobTitlesList.size(); i++){
            if(jobTitlesList.get(i).$(byXpath("descendant::a")).text().equals(title)){
                jobTitlesList.get(i).$(byXpath("descendant::input")).click();
            }
        }
    }
}
