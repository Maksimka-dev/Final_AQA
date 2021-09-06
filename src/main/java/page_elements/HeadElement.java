package page_elements;

import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class HeadElement {

    private SelenideElement markerPage = $(byXpath("//div[@class='head']/h1"));

    public void waitAddEmployeePage(){ markerPage.shouldHave(text(ConfProperties.getProperty("marker_add_employee_page"))); }

    public void waitPersonalDetailsPage(){ markerPage.shouldHave(text(ConfProperties.getProperty("marker_personal_details_page"))); }

    public void waitAddUserPage(){ markerPage.shouldHave(text(ConfProperties.getProperty("marker_add_user_page"))); }

    public void waitJobTitlesPage(){ markerPage.shouldHave(text(ConfProperties.getProperty("marker_job_titles_page"))); }

    public void waitAddJobTitlePage() { markerPage.shouldHave(text(ConfProperties.getProperty("marker_add_job_title_page"))); }

    public void waitAddCandidatePage() { markerPage.shouldHave(text(ConfProperties.getProperty("marker_add_candidate_page"))); }

    public void waitAssignLeavePage() { markerPage.shouldHave(text(ConfProperties.getProperty("marker_assign_leave_page"))); }

    public void waitDashboardPage() { markerPage.shouldHave(text(ConfProperties.getProperty("marker_dashboard_page"))); }
}
