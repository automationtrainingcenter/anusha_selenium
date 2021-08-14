package mouse_events;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

public class DragAndDropDemo extends BrowserConfig {
    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://jqueryui.com/droppable/");
        sleep(2000);

        // drag and drop elements are inside the frame so switch to frame
        driver.switchTo().frame(0);
        // after the above line driver focus is in frame
        // locate drag and drop elements
        WebElement drag_me_box = getElement(By.id("draggable"), "Drag me box");
        WebElement drop_me_box = getElement(By.id("droppable"), "Drop me box");

        // create Actions class object
        Actions actions = new Actions(driver);
        // way1: clickAndHold(), moveToElement() and release()
//        actions.clickAndHold(drag_me_box).moveToElement(drop_me_box).release().build().perform();

        // way2: dragAndDrop(sourceEle, targetEle)
        actions.dragAndDrop(drag_me_box, drop_me_box).build().perform();

        sleep(3000);
        closeBrowser();
    }

}
