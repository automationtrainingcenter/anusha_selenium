package screenshots;

import actions.BrowserName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import utitlity.BrowserConfig;
import utitlity.DriverConfig;

import java.io.File;
import java.io.IOException;

public class MultipleScreenshots extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.amazon.in");
        sleep(3000);

        // create JavascriptExecutor reference and Takesscreenshot reference
        TakesScreenshot ts = (TakesScreenshot) driver;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // get scroll height and client height
        long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
        long clientHeight = (long) js.executeScript("return document.documentElement.clientHeight");
        int i = 1;
        while(scrollHeight > 0) {
            File srcImg = ts.getScreenshotAs(OutputType.FILE);
            File destImg = new File(DriverConfig.getFolderPath("screenshots")+File.separator+"image"+i+".png");
            try {
                FileHandler.copy(srcImg, destImg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            js.executeScript("document.documentElement.scrollBy(0, arguments[0])", clientHeight);
            scrollHeight -= clientHeight;
            i++;
            sleep(2000);
        }

        closeBrowser();
    }
}
