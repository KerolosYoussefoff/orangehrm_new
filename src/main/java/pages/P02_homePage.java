package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class P02_homePage {
    private static final Logger logger = LogManager.getLogger(P02_homePage.class);
//    private static final int TIMEOUT = 10; // Timeout in seconds

    private final SHAFT.GUI.WebDriver driver;

    // Locators
    private final By adminTab = By.xpath("//*[@href=\"/web/index.php/admin/viewAdminModule\"]");
    private final By invalidCredentialTxt = By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]");
    private final By dashboardTxt = By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    private final By requiredFieldForUsername = By.xpath("//div[@class=\"oxd-form-row\" and contains(.,\"Username\")]//*[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");
    private final By requiredFieldForPassword = By.xpath("//div[@class=\"oxd-form-row\" and contains(.,\"Password\")]//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");

    // Constructor
    public P02_homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void selectAdminFromPanel() {
        logger.info("Clicking on Admin tab...");
        driver.element().click(adminTab);
    }

    public void validateThatLoginSuccessfully() {
        logger.info("Validating successful login...");
        driver.assertThat().element(dashboardTxt).exists().perform();
    }

    public void validateThatDidNotLoginDueToInvalidCredentials() {
        logger.info("Validating failed login due to invalid credentials...");
        driver.assertThat().element(invalidCredentialTxt).exists().perform();
    }

    public void validateThatDidNotLoginDueToEmptyFields() {
        logger.info("Validating failed login due to empty fields...");
        driver.assertThat().element(requiredFieldForUsername).exists().perform();
        driver.assertThat().element(requiredFieldForPassword).exists().perform();
    }
}