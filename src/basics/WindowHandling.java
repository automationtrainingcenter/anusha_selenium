package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import utitlity.DriverConfig;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandling {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().window().maximize();


        // locate open window button in main window and click on it
        driver.findElement(By.id("opentab")).click();
        Thread.sleep(2000);

        // Now above click will open a new child window
        // driver focus is in main window, switch the driver focus from main window to child window
        WebDriver.TargetLocator targetLocator = driver.switchTo();
        // window(String windowID) is used to switch the driver focus to the given window id
        // now get the window ids of all the browser windows using getWindowHandles()
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowIDs = new ArrayList<>(windowHandles);

        // The above list contains window ids of all opened windows
        // in index 0 parent window ID, in index 1, first child window ID, in index 2 Second child window id ..etc
        targetLocator.window(windowIDs.get(1)); // now driver focus switched to child window

        // locate ALL COURSES link and cilck on it
        driver.findElement(By.linkText("ALL COURSES")).click();
        Thread.sleep(2000);

        // locate search course and type some data
        driver.findElement(By.name("course")).sendKeys("aws");
        Thread.sleep(2000);

        // now driver focus is in child window and switch driver focus to main window
        targetLocator.window(windowIDs.get(0)); // now driver focus is in parent window

        // locate enter your name text box and type some data
        driver.findElement(By.id("name")).sendKeys("Anusha");
        Thread.sleep(2000);

        driver.quit();
    }
}
