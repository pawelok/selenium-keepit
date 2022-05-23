package po.microsoft;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class MicrosoftPage {

    WebDriver driver;

    @FindBy(className = "logo")
    WebElement microsoftLogo;
    @FindBy(css = "[type=email]")
    WebElement emailTxtField;
    @FindBy(css = "[type=submit]")
    WebElement submitBtn;
    @FindBy(css = "input[type=password]")
    WebElement passwordTxtField;
    @FindBy(id = "debugDetailsBanner")
    WebElement debugBanner;
    @FindBy(css = "[type=submit]")
    WebElement staySignInBtn;

    public MicrosoftPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

