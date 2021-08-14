package utitlity;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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
        System.out.printf("%s browser launched and navigated to %s\n", browserName.toString(), url);
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

    // click on an element
    public static void click(By locator, String eleName) {
        try {
            driver.findElement(locator).click();
            System.out.printf("clicked on element %s\n", eleName);
        } catch (Exception e) {
            System.out.printf("clicking on element %s failed due to exception "+e, eleName);
            System.out.println();
        }
    }

    // locate an element
    public static WebElement getElement(By locator, String eleName){
        try {
            WebElement element = driver.findElement(locator);
            System.out.printf("element %s located successfully\n", eleName);
            return element;
        } catch (Exception e) {
            System.out.println("locating element "+eleName+"  is failed due to exception "+e);
        }
        return null;
    }

    // mouse hover event
    public static void mouseHoverToElement(By locator, String element) {
        try {
            WebElement ele = getElement(locator, element);
            Actions actions = new Actions(driver);
            actions.moveToElement(ele).build().perform();
            System.out.println("Mouse hover to "+element);
        } catch (Exception e) {
            System.out.printf("mouse hover on to the element %s failed due to exception "+e, element);
        }
    }



}
