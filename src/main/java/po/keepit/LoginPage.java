package po.keepit;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage {

    WebDriver driver;
    @FindBy(css = "#email input.md-primary")
    WebElement email;
    @FindBy(css = "#password input.md-primary")
    WebElement password;
    @FindBy(css = "button.submit-button")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

