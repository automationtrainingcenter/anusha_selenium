package screenshots;

import actions.BrowserName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import utitlity.BrowserConfig;
import utitlity.DriverConfig;

import java.io.File;
import java.io.IOException;

/*
 * Selenium provides TakesScreenshot interface which contains
 * getScreenshotAs() to capture the screenshot of the current web page.
 *
 * TakesScreenshot interface is implemented by all our browser driver classes
 *
 * to call TakesScreenshot interface methods we have to type cast existing
 * driver object to the TakesScreenshot interface object
 *
 */
public class ScreenshotsDemo extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "http://www.facebook.com");
        sleep(2000);

        // capture the screenshot
        // typecast WebDriver object reference to TakesScreenshot interface reference
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcImage = ts.getScreenshotAs(OutputType.FILE);
        String filePath = DriverConfig.getFolderPath("screenshots")+File.separator+"image.png";
        File desImg = new File(filePath);
        try {
            FileHandler.copy(srcImage, desImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // close the browser
        closeBrowser();

    }
}
