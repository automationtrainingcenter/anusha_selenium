package javascriptexecutor;

import actions.BrowserName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utitlity.BrowserConfig;

public class GetPageHeights extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.amazon.in");
        sleep(2000);

        // create JavascriptExecutor reference
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // retrieve the scroll height
        long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
        // retrieve the client height
        long clientHeight = (long) js.executeScript("return document.documentElement.clientHeight");

        System.out.println("scroll height is "+scrollHeight+" and client height is "+clientHeight);
        closeBrowser();
    }

}
