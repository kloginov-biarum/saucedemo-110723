import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Integer.parseInt;

public class Header extends BasePage{

    public Header(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public void clickOnBurgerMenu(){
        burgerMenu.click();
    }

    public int getQuantityOfCartBadge(){
        return parseInt(cartBadge.getText());
    }

}
