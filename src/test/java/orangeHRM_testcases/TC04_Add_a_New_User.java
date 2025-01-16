package orangeHRM_testcases;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P02_homePage;
import pages.P03_adminPage;

public class TC04_Add_a_New_User {
    SHAFT.GUI.WebDriver driver; // SHAFT WebDriver instance
    SHAFT.TestData.JSON testData; // SHAFT TestData instance for JSON
    @Test
    public void addANewUser(){
        new TC01_ValidLogin().login_With_Valid_Username_Password(driver,testData);

    new P02_homePage(driver).selectAdminFromPanel();
    new P03_adminPage(driver).clickOnAdd().fillData(testData.getTestData("employee_Username"),
                                                    testData.getTestData("new_employee_password"),
                                                    testData.getTestData("confirm_employee_password"))
                              .userSavedSuccessfully();

    }

    @BeforeClass
    public void setup() {
        // Initialize the SHAFT WebDriver
        driver = new SHAFT.GUI.WebDriver();
        // Navigate to the OrangeHRM application URL
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/");

        // Load test data from the JSON file
        testData = new SHAFT.TestData.JSON("D:\\automation testing\\Test cases for OrangeHrm from deepseek\\src\\test\\resources\\testDataFiles\\orangeHRMtestdata.json");
    }

    @AfterClass
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}
