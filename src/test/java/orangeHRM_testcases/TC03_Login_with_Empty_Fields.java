package orangeHRM_testcases;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_loginPageStep;

public class TC03_Login_with_Empty_Fields {

    SHAFT.GUI.WebDriver driver; // SHAFT WebDriver instance
    SHAFT.TestData.JSON testData; // SHAFT TestData instance for JSON

    // Test method to add and delete a user
    @Test
    public void login_With_Empty_Fields(){
        new P01_loginPageStep(driver).loginSteps("",
                                                 "").validateThatDidNotLoginDueToEmptyFields();
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