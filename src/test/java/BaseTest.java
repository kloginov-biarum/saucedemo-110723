import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    ChromeDriver driver;

    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-2/chromedriver");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
