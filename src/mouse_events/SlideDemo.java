package mouse_events;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

public class SlideDemo extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://jqueryui.com/slider/");
        sleep(2000);

        // slider element is in frame so switch to frame
        driver.switchTo().frame(0);

        // locate slider element
        WebElement slider = getElement(By.id("slider"), "Slider");
        // locate the slider head element
        WebElement slider_head = getElement(By.cssSelector("#slider>span"), "Slider Head");

        // get slider width (slider is horizontal scroller)
        int width = slider.getSize().getWidth();

        int moveByPixels = (int) (width * 0.75);
        // Create actions class object
        Actions actions = new Actions(driver);

        // slide in forward direction
        actions.dragAndDropBy(slider_head, moveByPixels, 0).build().perform();
        sleep(3000);

        moveByPixels = (int) (width * 0.5) * -1;

        // slide in reverse direction by giving negative offset values
        actions.dragAndDropBy(slider_head, moveByPixels, 0).build().perform();
        sleep(3000);
        closeBrowser();

    }
}
