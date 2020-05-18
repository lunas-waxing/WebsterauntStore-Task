package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Paul Bova 5/17/2020
 * Contains data for page objects on webstaurantstore.com and Methods that interact with them
 */
public class WebstaurantStorePage {

    //String values of locators used in program sorted by type
    static String searchBoxID = "searchval";

    static String searchBtnClass = "banner-search-btn";
    static String productGridClass = "gtm-product";
    static String accessoriesMenuClass = "modal--accessories";
    static String cartClass = "btn-glass-cart";
    static String deleteCartItemBtnClass = "deleteCartItemButton";

    static String nextPageCss = ".icon-right-open";
    static String accessoriesCartBtnCss = ".modal--accessories .btn-cart";
    static String endOfResultsCss = ".disabled .icon-right-open";

    static String addToCartBtnName = "addToCartButton";

    public static void search(String searchText, WebDriver driver) {
        WebElement searchBox = driver.findElement(By.id(searchBoxID));
        WebElement searchBtn = driver.findElement(By.className(searchBtnClass));
        searchBox.click();
        searchBox.sendKeys(searchText);
        searchBtn.click();
        System.out.println("Search Complete");
    }

    public static void checkTitlesContain(String matchTitle, WebDriver driver) throws InterruptedException {

        do {
            WebElement nextPageBtn = driver.findElement(By.cssSelector(nextPageCss));
            List<WebElement> products = driver.findElements(By.className(productGridClass));
            for (WebElement product : products) {
                if (!product.getText().contains(matchTitle)) {
                    System.out.println("Entry without desired keyword found.");
                    System.out.println(product.getAttribute("data-description"));
                }
            }
            nextPageBtn.click();
            Thread.sleep(2000);
            System.out.println("Loading next page of results.");
        } while (driver.findElements(By.cssSelector(endOfResultsCss)).size() == 0);
        System.out.println("Reached end of results successfully.");
    }

    public static void addItemToCart(WebDriver driver) throws InterruptedException {
        List<WebElement> addToCartBtns = driver.findElements(By.name(addToCartBtnName));
        addToCartBtns.get(0).click();
        Thread.sleep(2000);
        if (!(driver.findElements(By.className(accessoriesMenuClass)).size() == 0)) {
            WebElement accessoriesMenu = driver.findElement(By.className(accessoriesMenuClass));
            accessoriesMenu.click();
            WebElement addToCartAccessoriesBtn = driver.findElement(By.cssSelector(accessoriesCartBtnCss));
            addToCartAccessoriesBtn.click();
            System.out.println("Bypassed accessories menu.");
        }
        System.out.println("Product added to cart.");
    }

    public static void openCartPage(WebDriver driver) {
        WebElement cartBtn = driver.findElement(By.className(cartClass));
        cartBtn.click();
        System.out.println("Cart page loading...");
    }

    public static void removeItemsFromCart(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        WebElement deleteCartItembtn = driver.findElement(By.className(deleteCartItemBtnClass));
        deleteCartItembtn.click();
        System.out.println("Cart Emptied.");
    }
}
