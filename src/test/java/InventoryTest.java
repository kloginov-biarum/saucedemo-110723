import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{

    @Test
    public void itemsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //Quantity of items is 6
        int expectedItemsQuantity = 6;
        assertEquals("Quantity of inventory items is NOT "+ expectedItemsQuantity
                ,expectedItemsQuantity,
                inventoryPage.getInventoryItemSize());
        //all inventory items are displayed
        assertTrue("Not all items are displayed", inventoryPage.allItemsAreDisplayed());
        //all items name are not empty
        assertTrue(inventoryPage.allNamesAreNotEmpty());
        //all items' names are started from "Sauce Labs"
    }
}
