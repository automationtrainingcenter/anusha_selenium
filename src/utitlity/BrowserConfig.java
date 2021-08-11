package utitlity;

import actions.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

    static WebDriver driver;

    public static WebDriver launchBrowser(BrowserName browserName, String url) {
        DriverConfig.setDriverPath(browserName);
        switch (browserName){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void closeBrowser(){
        if(driver != null) {
            driver.quit();
        } else {
            throw new RuntimeException("driver is null.");
        }
    }

}
