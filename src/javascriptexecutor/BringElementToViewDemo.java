package javascriptexecutor;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utitlity.BrowserConfig;

public class BringElementToViewDemo extends BrowserConfig {
    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.amazon.in");
        sleep(3000);

        WebElement navBackToTop = driver.findElement(By.id("navBackToTop"));
        // create an object reference JavaScriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scrollIntoView(true) is available in Chrome browser only: brings element to middle of the view
//        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true)", navBackToTop);
        // scrollIntoView() is available in every browser: brings element to top of the view
        js.executeScript("arguments[0].scrollIntoView()", navBackToTop);
        sleep(3000);
        js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", 0, -300);

        sleep(3000);
        closeBrowser();
    }
}
