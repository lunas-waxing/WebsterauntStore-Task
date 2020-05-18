import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static pages.WebstaurantStorePage.*;


/**
 * Paul Bova 5/15/2020
 * Instantiates chromedriver, opens browser to webstaurantstore.com,
 * calls methods for test's steps, and closes the window.
 **/
class WebstaurantStoreMain {
    public static void main(String[] args) throws Exception {
        //TODO change to properly reflect your own system settings
        System.setProperty("webdriver.chrome.driver", "C:/Programming/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.webstaurantstore.com/");
        Thread.sleep(5000);

        search("stainless work table", driver);
        Thread.sleep(2000);
        checkTitlesContain("Table", driver);

        Thread.sleep(2000);
        addItemToCart(driver);

        Thread.sleep(5000);
        openCartPage(driver);

        Thread.sleep(2000);
        removeItemsFromCart(driver);

        Thread.sleep(5000);
        driver.quit();
    }
}

