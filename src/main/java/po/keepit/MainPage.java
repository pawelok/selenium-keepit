package po.keepit;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class MainPage {

    WebDriver driver;

    @FindBy(css = "button.primary.icon-left")
    WebElement addConnectorBtn;
    @FindBy(css = "div.react-dropdown-menu-item")
    WebElement addConnectionMenuItem;
    @FindBy(css = ".react-modal-container button.primary")
    WebElement signInBtn;
    @FindBy(css = ".ng-binding")
    WebElement dashboardHeader;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

