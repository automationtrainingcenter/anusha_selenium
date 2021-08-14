package mouse_events;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

public class DragEvent extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://jqueryui.com/draggable/");
        sleep(2000);
        // drag me element is inside a frame so switch frame
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        // after the above driver focus switched to frame

        // locate drag me around element
        WebElement dragMe = getElement(By.id("draggable"), "drag me around box");

        // create an Actions class object
        Actions actions = new Actions(driver);

        // way1: using clickAndHold(), moveByOffset() and release()
//        actions.clickAndHold(dragMe).moveByOffset(50, 50).release().build().perform();

        // way2: using dragAndDropBy()
        actions.dragAndDropBy(dragMe, 150, 0).build().perform();

        sleep(4000);
        closeBrowser();


    }
}
