package page_elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainMenu {
    /////////////////////ADMIN/////////////////////////////////////////////////
    private SelenideElement adminBtn = $(byXpath("//a[@id='menu_admin_viewAdminModule']"));

    private SelenideElement userManagementBtn = $(byXpath("//a[@id='menu_admin_UserManagement']"));
    private SelenideElement usersBtn = $(byXpath("//a[@id='menu_admin_viewSystemUsers']"));

    private SelenideElement jobBtn = $(byXpath("//a[@id='menu_admin_Job']"));
    private SelenideElement jobTitles = $(byXpath("//a[@id='menu_admin_viewJobTitleList']"));
    ////////////////////////////////////////////////////////////////////////////

    //////////////////////PIM////////////////////////////////////////////////////
    private SelenideElement pimBtn = $(byXpath("//a[@id='menu_pim_viewPimModule']"));

    private SelenideElement employeeListBtn = $(byXpath("//a[@id='menu_pim_viewEmployeeList']"));
    private SelenideElement addEmployeeBtn = $(byXpath("//a[@id='menu_pim_addEmployee']"));
    /////////////////////////////////////////////////////////////////////////////

    private SelenideElement recruitmentBtn = $(byXpath("//a[@id='menu_recruitment_viewRecruitmentModule']"));
    private SelenideElement candidatesBtn = $(byXpath("//a[@id='menu_recruitment_viewCandidates']"));

    private SelenideElement leaveBtn = $(byXpath("//a[@id='menu_leave_viewLeaveModule']"));
    private SelenideElement assignLeaveBtn = $(byXpath("//a[@id='menu_leave_assignLeave']"));
    private SelenideElement leaveList = $(byXpath("//a[@id='menu_leave_viewLeaveList']"));

    private SelenideElement dashboardBtn = $(byXpath("//a[@id='menu_dashboard_index']"));

    @Step("Hover 'Admin' button on main menu")
    public void hoverAdminBtn(){ adminBtn.hover(); }

    @Step("Hover 'User Management' button on main menu")
    public void hoverUserManagementBtn(){ userManagementBtn.hover(); }

    @Step("Click 'User' button on main menu")
    public void clickUserBtn(){ usersBtn.click(); }

    @Step("Hover 'Job' button on main menu")
    public void hoverJobBtn(){ jobBtn.hover(); }

    @Step("Click 'Job Titles' button on main menu")
    public void clickJobTitlesBtn(){ jobTitles.click(); }

    @Step("Hover 'PIM' button on main menu")
    public void hoverPimBtn(){ pimBtn.hover(); }

    @Step("Click 'Employee List' button on main menu")
    public void clickEmployeeListBtn(){ employeeListBtn.click(); }

    @Step("Click 'Add Employee' button on main menu")
    public void clickAddEmployeeBtn(){ addEmployeeBtn.click(); }

    @Step("Move to System User Page")
    public void moveToSystemUsersPage(){
        hoverAdminBtn();
        hoverUserManagementBtn();
        clickUserBtn();
    }

    @Step("Hover 'Recruitment' button on main menu")
    public void hoverRecruitmentBtn(){ recruitmentBtn.hover(); }

    @Step("Click 'Candidate' button on main menu")
    public void clickCandidatesBtn(){ candidatesBtn.click(); }

    @Step("Hover 'Leave' button on main menu")
    public void hoverLeaveBtn(){ leaveBtn.hover(); }

    @Step("Click 'Assign Leave' button on main menu")
    public void clickAssignLeaveBtn(){ assignLeaveBtn.click(); }

    @Step("Click 'Leave List' button on main menu")
    public void clickLeaveList(){ leaveList.click(); }

    @Step("Click 'Dashboard' button on main menu")
    public void clickDashboardBtn() { dashboardBtn.click(); }
}
