package mouse_events;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

/*
 * To perform any mouse event, selenium provides Actions class
 * These Actions class contains several methods to perform mouse events, to call these
 * methods we have to create an object of Actions class.
 * whatever the event we are performing we have to call build() and perform() methods
 * of Actions class after the event related method.
 */
public class MouseHoverEvent extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://courses.letskodeit.com/practice");
        sleep(2000);
        mouseHoverToElement(By.id("mousehover"), "Mouse Hover");
        sleep(2000);
        click(By.linkText("Reload"), "Reload link");
        sleep(3000);
        closeBrowser();
    }
}
