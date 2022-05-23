package helpers.keepit;

import org.openqa.selenium.WebDriver;
import po.keepit.LoginPage;

public class LoginPageHelper {

    LoginPage keepitLoginPage;

    public LoginPageHelper(WebDriver driver){
        keepitLoginPage = new LoginPage(driver);
    }

    public void loginUserToKeepit(String username, String password){
        keepitLoginPage.getEmail().sendKeys(username);
        keepitLoginPage.getPassword().sendKeys(password);
        keepitLoginPage.getSubmitButton().click();
    }

    public boolean isLoginPageOpen(){
        return keepitLoginPage.getPassword().isDisplayed();
    }

}
