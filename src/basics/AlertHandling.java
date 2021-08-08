package basics;

import actions.BrowserName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

/*
 * Alert is also know as a Javascript popup
 * we have 3 types of alerts in javascript
 * 1. alert with only OK button
 * 2. alert with OK and Cancel buttons
 * 3. alert with OK, Cancel buttons and some text box
 *
 * These alerts are browser specific.
 *
 * To handle alerts Selenium provides an Alert interface.
 * Alert interface methods
 * 1. accept() is used to click OK button of the alert.
 * 2. dismiss() is used to click Cancel button of the alert if it contains else it will click Ok button.
 * 3. getText() is used to retrieve the alert text.
 * 4. sendKeys(String arg) is used to type some data inside alert text box.
 *
 *
 * WebDriver interface contains switchTo() which will return TargetLocator interface reference.
 * In TargetLocator interface we have alert(), which will return Alert interface reference.
 * TargetLocator tl = driver.switchTo();
 * Alert alert = tl.alert();
 * or
 * Alert alert = driver.switchTo().alert();
 *
 * Note: Until and unless we handle the alerts we can not automate anything on the browser. If you try to
 * do anything on the browser it will throw UnhandledAlertException
 *
 */
public class AlertHandling {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://courses.letskodeit.com/practice");

        // locate alert button and click on it
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);

        // the above click event will open an alert in the page with OK button
        // handle the alert
        // switch the driver focus to the alert from browser window using switchTo() of WebDriver interface
        WebDriver.TargetLocator targetLocator = driver.switchTo();
        Alert alert = targetLocator.alert();

        // get the alert text and print on the console
        System.out.println("Alert message is "+alert.getText());

        // click OK button of the alert
        alert.accept();
        Thread.sleep(2000);


        // locate enter your name text box
        driver.findElement(By.id("name")).sendKeys("Anusha");
        Thread.sleep(2000);

        // locate confirm button and click on it
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);

        // the above click will open an alert with OK and Cancel buttons
        // handle the alert
        // switch driver focus from browser window to alert using switchTo()
        Alert confirmAlert = driver.switchTo().alert();

        // get the alert text and print on the console
        System.out.println(confirmAlert.getText());

        // click on Cancel button
        confirmAlert.dismiss();

        Thread.sleep(2000);

        driver.close();
    }
}
