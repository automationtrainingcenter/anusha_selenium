package javascriptexecutor;

import actions.BrowserName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utitlity.BrowserConfig;

public class ScrollDemo extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.amazon.in");
        sleep(3000);
        int x = 0;
        int y = 800; // scroll down

        // create JavascriptExecutor reference
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);

        sleep(3000);
        y = -600; // scroll up
        js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);
        sleep(3000);
        closeBrowser();

    }
}
