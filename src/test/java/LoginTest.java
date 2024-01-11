import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class LoginTest extends BaseTest{


/*    @Test
    public void successfulLoginWithoutPO() {
        WebElement usernameInputField =
                driver.findElement(By.cssSelector("[name=\"user-name\"]"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField =
                driver.findElement(By.cssSelector("[name=\"password\"]"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton =
                driver.findElement(By.id("login-button"));
        loginButton.click();
        //Check that auth is successful
       //assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inventoryList =
               driver.findElement(By.className("inventory_list"));
       assertTrue(inventoryList.isDisplayed());
    }*/
    @Feature("Login")
    @DisplayName("Success login")
    @Test @Description("Successful Authorization with standard_user")
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(standardUser);
        loginPage.enterPassword(standardUser);
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
    }


    @Test
    public void invalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("23432432");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                .contains("Username and password do not match any user in this service"));
    }

    //@Test
    public void lockedOutUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                .contains("Sorry, this user has been locked out."));
    }


    //check that logo, username section and password section are displayed
   // @Test
    public void elementsAreDisplayed(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logoIsDisplayed();
        loginPage.usernamesSectionIsDisplayed();
        loginPage.passwordsSectionIsDisplayed();
       }

      // @Test
       public void successLogout(){
        //Login with valid data
           LoginPage loginPage = new LoginPage(driver);
           loginPage.enterUsername("standard_user");
           loginPage.enterPassword("secret_sauce");
           loginPage.clickOnLoginButton();
           InventoryPage inventoryPage = new InventoryPage(driver);
           assertTrue(inventoryPage.inventoryListIsDisplayed());
           //Navigate to burger menu
            Header header = new Header(driver);
            header.clickOnBurgerMenu();
           //Follow the link Logout
            SideBar sideBar = new SideBar(driver);
            sideBar.followTheLogoutLink();
            //Assert that logout is successful
           assertTrue(loginPage.userNameInputFieldIsDisplayed());

       }

}
