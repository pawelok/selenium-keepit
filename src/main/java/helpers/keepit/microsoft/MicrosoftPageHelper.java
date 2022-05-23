package helpers.keepit.microsoft;

import org.awaitility.Awaitility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import po.microsoft.MicrosoftPage;

import java.util.concurrent.TimeUnit;

public class MicrosoftPageHelper {

    MicrosoftPage microsoftMicrosoftPage;

    public MicrosoftPageHelper(WebDriver driver) {
        microsoftMicrosoftPage = new MicrosoftPage(driver);
    }

    public boolean verifyIfMicrosoftPageIsDisplayed() {
        return microsoftMicrosoftPage.getMicrosoftLogo().isDisplayed();
    }

    public void loginUser(String username, String password) {
        microsoftMicrosoftPage.getEmailTxtField().sendKeys(username);
        microsoftMicrosoftPage.getSubmitBtn().click();
        Awaitility.await().atMost(5000, TimeUnit.MILLISECONDS).until(() -> microsoftMicrosoftPage.getPasswordTxtField().isDisplayed());
        microsoftMicrosoftPage.getPasswordTxtField().sendKeys(password);
        microsoftMicrosoftPage.getPasswordTxtField().sendKeys(Keys.ENTER);
        microsoftMicrosoftPage.getStaySignInBtn().click();
    }

    public boolean isDebugDialogDisplayed() {
        return microsoftMicrosoftPage.getDebugBanner().isDisplayed();
    }
}
