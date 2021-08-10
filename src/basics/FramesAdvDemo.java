package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;


public class FramesAdvDemo {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/suryaprakash/Documents/trainings/anusha_selenium/frames/framesDemo.html");
        driver.manage().window().maximize();

        // driver focus is in main page
        // want to automate frame one element
        // switch the driver focus from main page to frame
        WebDriver.TargetLocator targetLocator = driver.switchTo();
        targetLocator.frame(0);
        // locate element enter name and type some data
        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("Anusha");
        Thread.sleep(2000);


        // automate frame 2
        // switch the driver focus from frame 1 to main page
        targetLocator.defaultContent();
//        driver.switchTo().defaultContent();
        // after the above line driver focus switched to main page
        // switch the driver focus to frame 2
        targetLocator.frame("ftwo");
        // after the above line driver focus switched to frame two
        // locate selenium official site link and click on it
        driver.findElement(By.linkText("selenium official site")).click();
        Thread.sleep(2000);


        // automate frame 4 which is inner frame of frame 3
        // now driver focus is in frame 2 so switch back to main page
        targetLocator.defaultContent();
        // now driver focus is in main page switch to frame 3 because frame 4 is inner frame of frame 3
        // locate frame 3 and swith to it
        WebElement frame3 = driver.findElement(By.xpath("//iframe[@src='frameThree.html']"));
        targetLocator.frame(frame3);

        // after the above line driver focus is in frame 3, so switch to frame 4
        targetLocator.frame(0);
        // now driver focus is in frame 4
        driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys("selenium");
        Thread.sleep(2000);


        // automate frame 3
        // now driver focus is in frame 4 and frame 4 is inner frame of frame 3
        // switch to frame 3 from frame 4 using parentFrame()
        targetLocator.parentFrame();
        // after above line driver focus is in frame 3
        driver.findElement(By.id("click")).click();
        Thread.sleep(2000);


        // automate main page
        // driver focus is in frame 3 so switch to main page
        targetLocator.defaultContent();
        driver.findElement(By.id("opentTab")).click();
        Thread.sleep(3000);

        driver.quit();

    }
}
