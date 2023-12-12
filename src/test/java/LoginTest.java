import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class LoginTest {

    ChromeDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-2/chromedriver");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void successfulLogin() throws InterruptedException {
        WebElement usernameInputField =
                driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        sleep(5000);
    }

}
