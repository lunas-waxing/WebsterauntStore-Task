package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Paul Bova 5/17/2020
 * Contains data for page objects on webstaurantstore.com
 */
public class WebstaurantStorePage {

    @FindBy(how = How.CLASS_NAME,using = "home")
    public static WebElement body;
    @FindBy(how = How.NAME, using = "searchval")
    public static WebElement searchBox;

    public static void search(String searchText) {
        body.click();
        searchBox.click();
        searchBox.sendKeys(searchText);
    }
}
