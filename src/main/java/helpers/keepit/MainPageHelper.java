package helpers.keepit;

import org.openqa.selenium.WebDriver;
import po.keepit.MainPage;

public class MainPageHelper {

    MainPage keepitMainPage;

    public MainPageHelper(WebDriver driver){
        keepitMainPage = new MainPage(driver);
    }

    public boolean verifyIfDashboardHeaderIsDisplayed(){
        return keepitMainPage.getDashboardHeader().isDisplayed();
    }

    public void addNew365OfficeAdmin(){
        keepitMainPage.getAddConnectorBtn().click();
        keepitMainPage.getAddConnectionMenuItem().click();
        keepitMainPage.getSignInBtn().click();
    }
}
