package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;
/*
 * Frames are used to add a web page within another web page
 *
 * When we launch an application driver instance will point to the body tag of that page
 * if that page contains any frames those frames also contains body tag but our driver
 * instance will not point to that body tag
 *
 * to automate elements which are in frame body tag we have to switch driver focus from main
 * page body tag to frame body tag
 *
 * Once we automated frame, then to automate elements in main page body tag we have to use
 * switch driver focus again back to main page body tag from frame body tag.
 *
 * TargetLocator interface contains method to perform above switch
 *
 * 1. frame(int index) : is used to switch driver focus from main page or
 * outer frame to frame or inner frame using frame index number
 * 2. frame(String id or name) : is used to switch driver focus from main page or
 * outer frame to frame or inner frame using frame name or id attribute of the frame
 * 3. frame(WebElement frameEle) : is used to switch driver focus from main page or
 * outer frame to frame or inner frame using frame element
 * 4. parentFrame() : is used to switch driver focus from inner frame to outer frame
 * 5. defaultContent() : is used to switch driver focus from any frame to main page
 *
 *
 * In WebDriver interface we have switchTo() which will return TargetLocator interface reference
 * we can use this reference to call above methods
 *
 * WebDriver driver = new ChromeDriver();
 * TargetLocator tl = driver.switchTo();
 * tl.frame(0);
 *
 * or
 *
 * driver.switchTo().frame(0);
 *
 */
public class FramesHandling {
    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().window().maximize();


        // driver focus is in main page
        // locate enter your name text box form main page and type some data
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Anusha");
        Thread.sleep(3000);

        // Search Course text box is inside the frame
        // so switch the driver focus from main page to frame
        // switch to frame using index
        WebDriver.TargetLocator targetLocator = driver.switchTo();
        targetLocator.frame(0);

        // after the above line driver focus is switched to frame
        // locate search course text box and type some data
        driver.findElement(By.name("course")).sendKeys("Python");
        Thread.sleep(2000);

        // now the driver focus is in frame
        // so switch the driver focus from frame to main page
        targetLocator.defaultContent();

        // after the above line driver focus is switched back to main page
        // clear the data entered in enter your name text box
        name.clear();
        Thread.sleep(2000);

        driver.close();


    }
}
