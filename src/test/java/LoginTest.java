import helpers.keepit.LoginPageHelper;
import helpers.keepit.MainPageHelper;
import helpers.keepit.microsoft.MicrosoftPageHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    WebDriver driver;
    LoginPageHelper keepitLoginPageHelper;
    MainPageHelper keepitMainPageHelper;
    MicrosoftPageHelper microsoftMicrosoftPageHelper;

    protected static final String login = "automation@keepitqa.com";
    protected static final String password = "E#*b2wGIbFHz";
    protected static final String MICROSOFT_EMAIL = System.getenv("MICROSOFT_EMAIL");
    protected static final String MICROSOFT_PASSWORD = System.getenv("MICROSOFT_PASSWORD");

    @BeforeAll
    void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        keepitLoginPageHelper = new LoginPageHelper(driver);
        keepitMainPageHelper = new MainPageHelper(driver);
        microsoftMicrosoftPageHelper = new MicrosoftPageHelper(driver);
    }

    @Test
    @Order(1)
    void visitMainKeepitPageAndVerifyIfLoginPAgeOpens() {
        driver.get("https://ws-test.keepit.com");
        assertTrue(keepitLoginPageHelper.isLoginPageOpen(), "Login page didn't open after visiting main page");
    }

    @Test
    @Order(2)
    void loginUserToKeepitAndVerifyMainPage() {
        keepitLoginPageHelper.loginUserToKeepit(login, password);
        assertTrue(keepitMainPageHelper.verifyIfDashboardHeaderIsDisplayed(), "Main page didn't open after user login");
    }

    @Test
    @Order(3)
    void verifyIfMicrosoftAuthPageWillOpenAfterAddingNew365OfficeAdmin() {
        keepitMainPageHelper.addNew365OfficeAdmin();
        assertAll(
                () -> assertTrue(microsoftMicrosoftPageHelper.verifyIfMicrosoftPageIsDisplayed(), "Microsot page was not displayed after adding new 365 office admin"),
                () -> assertTrue(driver.getCurrentUrl().contains("login.microsoftonline.com/"), "URL adress doesnt match login.microsoftonline.com/"));
    }

    @Test
    @Order(4)
    void verifyIfPrivateUserCanBeNew365OfficeAdmin() {
        microsoftMicrosoftPageHelper.loginUser(MICROSOFT_EMAIL, MICROSOFT_PASSWORD);
        assertFalse(microsoftMicrosoftPageHelper.isDebugDialogDisplayed(), "Private microsoft user was not able to be added as new 365 office admin");
    }
}
