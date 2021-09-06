package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SystemUsersPage {
    private SelenideElement searchBtn = $(byXpath("//input[@id='searchBtn']"));
    private SelenideElement searchUsernameField = $(byXpath("//input[@id='searchSystemUser_userName']"));
    private SelenideElement addBtn = $(byXpath("//input[@id='btnAdd']"));
    private ElementsCollection usersList = $$(byXpath("//table[@id='resultTable']/tbody/tr"));

    public void waitSystemUsersPage(){ searchUsernameField.shouldBe(Condition.visible); }

    @Step("Enter 'User name' in system user page")
    public void setSearchUsernameField(String username){ searchUsernameField.sendKeys(username); }

    @Step("Click 'Search' button to search user")
    public void clickSearchBtn(){ searchBtn.click(); }

    @Step("Click 'Add' button to add user")
    public void clickAddBtn(){ addBtn.click(); }

    @Step("Check user name in user table is")
    public boolean isUsernameInUserTable(String username){
        boolean result = false;
        setSearchUsernameField(username);
        clickSearchBtn();
        usersList.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(0));

        if(usersList.size() > 0){
            for (int i = 0; i < usersList.size(); i++){
                if(usersList.get(i).$(byXpath("descendant::a")).text().equals(username)){
                    result = true;
                }
            }
        }

        return result;
    }
}
