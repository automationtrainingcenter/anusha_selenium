package mouse_events;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

public class MouseHoverDemo extends BrowserConfig {
    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://www.firstcry.com/");
        sleep(4000);
        WebElement all_categories = getElement(By.xpath("//div[@class='menu-container']//a[contains(text(), 'All Categories')]"), "All Categories");
        WebElement girl_fashion = getElement(By.xpath("//div[@class='fc-subMenu']//a[contains(text(), 'GIRL FASHION')]"), "Girl Fashion");
        WebElement party_wear = getElement(By.xpath("//div[@class='fc-subMenu']//a[contains(@href, 'girl-fashion_party-wear_V')]"), "Party Wear");
        // css : .fc-subMenu a[href $= 'girl-fashion_party-wear_V']

        // create Actions class object
        Actions actions = new Actions(driver);
        actions.moveToElement(all_categories).build().perform();
        sleep(2000);
        actions.moveToElement(girl_fashion).build().perform();
        sleep(2000);
        actions.moveToElement(party_wear).click().build().perform();
        sleep(5000);

        closeBrowser();



    }
}
