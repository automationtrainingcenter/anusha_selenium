package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

public class TextBoxesDemo {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();

        // locate create new account and click on it
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);
        // locate first name type some data
        driver.findElement(By.name("firstname")).sendKeys("Surya");
        Thread.sleep(2000);
        // locate surname and type some data
        driver.findElement(By.name("lastname")).sendKeys("Prakash");
        Thread.sleep(2000);
        // locate email of phone number and type some data
        driver.findElement(By.name("reg_email__")).sendKeys("suryap@gmail.com");
        Thread.sleep(2000);
    // locate re enter email address and type some data
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("suryap@gmail.com");
        Thread.sleep(2000);
        // locate password and type some data
        driver.findElement(By.name("reg_passwd__")).sendKeys("somepassword");
        Thread.sleep(2000);

        driver.close();

    }
}
