package page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class DashboardPage {
    private SelenideElement quickLaunchPanel = $(byXpath("//div[@id='panel_draggable_0_0']"));
    private SelenideElement employeeDistributionPanel = $(byXpath("//div[@id='panel_draggable_1_0']"));
    private SelenideElement legendPanel = $(byXpath("//div[@id='panel_draggable_1_1']"));
    private SelenideElement pendingLeavePanel = $(byXpath("//div[@id='panel_draggable_1_2']"));

    @Step("Check Quick launch panel in dashboard page is visible")
    private boolean isVisibleQuickLaunchPanel(){ return quickLaunchPanel.isDisplayed(); }

    @Step("Check Employee distribution panel in dashboard page is visible")
    private boolean isVisibleEmployeeDistributionPanel() { return employeeDistributionPanel.isDisplayed(); }

    @Step("Check Legend panel in dashboard page is visible")
    private boolean isVisibleLegendPanel() { return legendPanel.isDisplayed(); }

    @Step("Check Pending leave panel in dashboard page is visible")
    private boolean isVisiblePendingLeavePanel() { return pendingLeavePanel.isDisplayed(); }

    public boolean isVisibleDashboardPanels() {
        boolean result = false;
        if(isVisibleQuickLaunchPanel()){
            if(isVisibleEmployeeDistributionPanel()){
                if(isVisibleLegendPanel()){
                    if(isVisiblePendingLeavePanel()){
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
