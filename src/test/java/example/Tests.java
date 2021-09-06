package example;

import com.codeborne.selenide.Configuration;
import data.AssignLeaveDataSource;
import data.CandidateDataSource;
import data.UserDataSource;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import page_elements.HeadElement;
import page_elements.MainMenu;
import page_elements.WelcomePanel;
import page_objects.*;
import value_objects.JobTitle;
import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {

    private LoginPage logIn;
    private WelcomePanel welcomePanel;
    private MainMenu mainMenu;
    private HeadElement headElement;
    private AddEmployeePage addEmployeePage;
    private SystemUsersPage systemUsersPage;
    private AddUserPage addUserPage;
    private JobTitlesPage jobTitlesPage;
    private AddJobTitlePage addJobTitlePage;
    private ConfirmationPage confirmationPage;
    private CandidatesPage candidatesPage;
    private AddCandidatePage addCandidatePage;
    private AssignLeavePage assignLeavePage;
    private AssignListPage assignListPage;
    private DashboardPage dashboardPage;
    private EmployeeInformationPage employeeInformationPage;
    private PersonalDetailsPage personalDetailsPage;

    @BeforeEach
    public void setup(){
        Configuration.baseUrl = "https://opensource-demo.orangehrmlive.com/";
        open(Configuration.baseUrl);
        logIn = new LoginPage();
        welcomePanel = new WelcomePanel();
        mainMenu = new MainMenu();
        addEmployeePage = new AddEmployeePage();
        headElement = new HeadElement();
        systemUsersPage = new SystemUsersPage();
        addUserPage = new AddUserPage();
        jobTitlesPage = new JobTitlesPage();
        addJobTitlePage = new AddJobTitlePage();
        confirmationPage = new ConfirmationPage();
        candidatesPage = new CandidatesPage();
        addCandidatePage = new AddCandidatePage();
        assignLeavePage = new AssignLeavePage();
        assignListPage = new AssignListPage();
        dashboardPage = new DashboardPage();
        employeeInformationPage = new EmployeeInformationPage();
        personalDetailsPage = new PersonalDetailsPage();
    }

    @AfterEach
    public void logout(){
        welcomePanel.logout();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test")
    @Feature("Login feature")
    @Test
    @Order(1)
    public void loginTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Add employee test")
    @Feature("PIM feature")
    @Test
    @Order(2)
    public void addEmployeeTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverPimBtn();
        mainMenu.clickAddEmployeeBtn();

        headElement.waitAddEmployeePage();
        addEmployeePage.enterAddEmployeeField(UserDataSource.userSource);

        headElement.waitPersonalDetailsPage();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Delete employee test")
    @Feature("PIM feature")
    @Test
    @Order(3)
    public void deleteEmployeeTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverPimBtn();
        mainMenu.clickEmployeeListBtn();

        employeeInformationPage.waitEmployeeInformationPage();
        employeeInformationPage.selectEmployee(UserDataSource.userSource.getFirstName());
        employeeInformationPage.clickDeleteBtn();

        confirmationPage.waitConfirmationPage();
        confirmationPage.clickOkBtn();

        Assertions.assertFalse(employeeInformationPage.isEmployeeExist(UserDataSource.userSource.getFirstName()));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Add admin user test")
    @Feature("Admin feature")
    @Test
    @Order(4)
    public void addAdminUserTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverPimBtn();
        mainMenu.clickAddEmployeeBtn();

        headElement.waitAddEmployeePage();
        addEmployeePage.enterAddEmployeeField(UserDataSource.userSource);

        headElement.waitPersonalDetailsPage();

        mainMenu.moveToSystemUsersPage();

        systemUsersPage.waitSystemUsersPage();
        systemUsersPage.clickAddBtn();

        headElement.waitAddUserPage();
        addUserPage.enterAddUserFields(UserDataSource.userSource);

        mainMenu.moveToSystemUsersPage();

        systemUsersPage.waitSystemUsersPage();

        Assertions.assertTrue(systemUsersPage.isUsernameInUserTable(UserDataSource.userSource.getUserName()));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Add job titles")
    @Feature("Admin feature")
    @ParameterizedTest
    @MethodSource("data.JobTitlesSource#jobTitlesSourceList")
    @Order(5)
    public void addJobTitlesTest(JobTitle jobTitle){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverAdminBtn();
        mainMenu.hoverJobBtn();
        mainMenu.clickJobTitlesBtn();

        headElement.waitJobTitlesPage();

        jobTitlesPage.clickAddJobTitlesBtn();

        headElement.waitAddJobTitlePage();

        addJobTitlePage.enterJobTitlesField(jobTitle);

        headElement.waitJobTitlesPage();

        Assertions.assertTrue(jobTitlesPage.isTitleExist(jobTitle.getJobTitle()));

    }

    @Severity(SeverityLevel.MINOR)
    @Description("Delete job titles")
    @Feature("Admin feature")
    @ParameterizedTest
    @MethodSource("data.JobTitlesSource#jobTitlesSourceList")
    @Order(6)
    public void deleteJobTitlesTest(JobTitle jobTitle){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverAdminBtn();
        mainMenu.hoverJobBtn();
        mainMenu.clickJobTitlesBtn();

        headElement.waitJobTitlesPage();

        jobTitlesPage.selectJobTitle(jobTitle.getJobTitle());
        jobTitlesPage.clickDeleteJobTitlesBtn();

        confirmationPage.waitConfirmationPage();
        confirmationPage.clickOkBtn();

        Assertions.assertFalse(jobTitlesPage.isTitleExist(jobTitle.getJobTitle()));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Add candidate test")
    @Feature("Recruitment feature")
    @Test
    @Order(7)
    public void addCandidateTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverRecruitmentBtn();
        mainMenu.clickCandidatesBtn();

        candidatesPage.waitCandidatePage();
        candidatesPage.clickAddCandidateBtn();

        headElement.waitAddCandidatePage();

        addCandidatePage.enterCandidateField(CandidateDataSource.candidate);

        mainMenu.hoverRecruitmentBtn();
        mainMenu.clickCandidatesBtn();

        candidatesPage.waitCandidatePage();

        Assertions.assertTrue(candidatesPage.isCandidateInCandidateTable(CandidateDataSource.candidate.getFirstName(),
                CandidateDataSource.candidate.getLastName()));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Add assign leve test")
    @Feature("Assign feature")
    @Test
    @Order(8)
    public void addAssignLeaveTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverLeaveBtn();
        mainMenu.clickAssignLeaveBtn();

        headElement.waitAssignLeavePage();

        assignLeavePage.enterAssignLeaveField(AssignLeaveDataSource.assignLeaveSource);

        mainMenu.hoverLeaveBtn();
        mainMenu.clickLeaveList();

        assignListPage.waitAssignLeavePage();

        Assertions.assertTrue(assignListPage.isAssignInAssignTable(AssignLeaveDataSource.assignLeaveSource));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Visibility dashboard panels")
    @Feature("Dashboard feature")
    @Test
    @Order(9)
    public void dashboardVisiblePanelsTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.clickDashboardBtn();

        headElement.waitDashboardPage();

        Assertions.assertTrue(dashboardPage.isVisibleDashboardPanels());
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Field sales employee")
    @Feature("PiM feature")
    @Test
    @Order(10)
    public void fieldSalesEmployeeTest(){
        logIn.login();
        welcomePanel.waitWelcomePanel();

        mainMenu.hoverPimBtn();
        mainMenu.clickEmployeeListBtn();

        employeeInformationPage.waitEmployeeInformationPage();
        employeeInformationPage.searchEmployeeWithSalesSubUnit();
        employeeInformationPage.toFirstInEmployeeList();

        headElement.waitPersonalDetailsPage();

        personalDetailsPage.shouldBeVisibleAllField();
    }

}
