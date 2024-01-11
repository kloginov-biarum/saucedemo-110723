import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
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

    public void tearDown(){
        driver.quit();
    }

    User standardUser = new User("standard_user", "secret_sauce");

    @Rule
    public TestWatcher screenShotOnFailure = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            driver.quit();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenShot();
            driver.quit();
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            driver.quit();
        }
        @Attachment
        public byte[] makeScreenShot(){
            return driver.getScreenshotAs(OutputType.BYTES);
        }
    };

}
