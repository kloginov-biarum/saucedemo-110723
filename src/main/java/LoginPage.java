import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement logo;

    @FindBy(id = "login_credentials")
    private WebElement usernamesSection;

    @FindBy(className = "login_password")
    private WebElement passwordsSection;

    public boolean userNameInputFieldIsDisplayed(){
        return usernameInputField.isDisplayed();
    }
    @Step("Enter username")
    public void enterUsername(User user){
        enterTextToElement(user.getUsername(), usernameInputField);

    }

    @Step("Enter password")
    public void enterPassword(User user){
     enterTextToElement(user.getPassword(), passwordInputField);
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }

    public String getErrorMessageText(){
        return errorMessage.getText();
    }


    public boolean logoIsDisplayed(){
        return logo.isDisplayed();
    }

    public boolean usernamesSectionIsDisplayed(){
        return usernamesSection.isDisplayed();
    }

    public boolean passwordsSectionIsDisplayed(){
        return passwordsSection.isDisplayed();
    }
}
