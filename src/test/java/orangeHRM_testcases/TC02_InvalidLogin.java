package orangeHRM_testcases;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_loginPageStep;

public class TC02_InvalidLogin {

    SHAFT.GUI.WebDriver driver; // SHAFT WebDriver instance
    SHAFT.TestData.JSON testData; // SHAFT TestData instance for JSON

    // Test method to add and delete a user
    @Test
    public void login_With_Invalid_Username_Password(){
        new P01_loginPageStep(driver).loginSteps(testData.getTestData("username_invalid"),
                                                 testData.getTestData("password_invalid")).
                validateThatDidNotLoginDueToInvalidCredentials();
    }

    // Setup method to initialize the driver and load test data
    @BeforeClass
    public void setup() {
        // Initialize the SHAFT WebDriver
        driver = new SHAFT.GUI.WebDriver();
        // Navigate to the OrangeHRM application URL
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/");

        // Load test data from the JSON file
        testData = new SHAFT.TestData.JSON("D:\\automation testing\\Test cases for OrangeHrm from deepseek\\src\\test\\resources\\testDataFiles\\orangeHRMtestdata.json");
    }


    // Teardown method to close the browser after the test
    @AfterMethod
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}