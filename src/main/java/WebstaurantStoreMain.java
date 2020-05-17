import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import pages.WebstaurantStorePage;


/**
 * Paul Bova 5/15/2020
 * Instantiates chromedriver, opens browser to webstaurantstore.com,
 * calls methods for test's steps, and closes the window.
 **/
class WebstaurantStoreMain {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Programming/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.webstaurantstore.com/");
        Thread.sleep(20000);
        WebstaurantStorePage.search("stainless work table");
    }
}

