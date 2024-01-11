import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{



    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShirtAddToCartButton;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(css = "[value=\"az\"]")
    private WebElement sortOptionNameAtoZ;

    @FindBy(css = "[value=\"za\"]")
    private WebElement sortOptionNameZtoA;

    @FindBy(css = "[value=\"lohi\"]")
    private WebElement sortOptionPriceLowToHigh;
    @FindBy(css = "[value=\"hilo\"]")
    private WebElement sortOptionPriceHighToLow;

    public boolean inventoryListIsDisplayed(){
         return inventoryList.isDisplayed();
    }

    public int getInventoryItemSize(){
        return items.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean allDisplayed = true;
        for (WebElement item :items) {
           if (!item.isDisplayed()){
               allDisplayed=false;
               break;
           }
        }
        return allDisplayed;
    }


    public boolean allNamesAreNotEmpty(){
        boolean allNamesAreNotEmpty = true;
        for (WebElement name :itemNames) {
            if(name.getText().isEmpty()){
                allNamesAreNotEmpty=false;
                break;
            }
        }
        return allNamesAreNotEmpty;
    }

    public void backPackAddToCart(){
        backpackAddToCartButton.click();
    }

    public void bikeLightAddToCart(){
        bikeLightAddToCartButton.click();
    }

    public void tShirtAddToCart(){
        tShirtAddToCartButton.click();
    }

    public void choseSortByNameAtoZ(){
        sortDropdown.click();
        sortOptionNameAtoZ.click();
    }
    public void choseSortByNameZtoA(){
        sortDropdown.click();
        sortOptionNameZtoA.click();
    }

    public void choseSortByPriceLowToHigh(){
        sortDropdown.click();
        sortOptionPriceLowToHigh.click();
    }

    public void choseSortByPriceHighToLow(){
        sortDropdown.click();
        sortOptionPriceHighToLow.click();
    }

    public boolean checkSortingByNameAtoZ(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name: itemNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames);
        return actualNames.equals(expectedNames);
    }

    public boolean checkSortingByNameZtoA(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name: itemNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(reverseOrder());
        return actualNames.equals(expectedNames);
    }

    public boolean checkSortingByPriceLowToHigh(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price: itemPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);
        return actualPrices.equals(expectedPrices);
    }


    public boolean checkSortingByPriceHighToLow(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price: itemPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);
        System.out.println("Act: ");
        for (Double el:
             actualPrices) {
            System.out.println(el);
        }
        System.out.println("Exp: ");
        for (Double el:
                expectedPrices) {
            System.out.println(el);
        }
        return actualPrices.equals(expectedPrices);
    }



}
