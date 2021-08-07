package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

public class RadioCheckButtonsLinksDemo {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();

        // locate create new account and click on it
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);

        // locate female radio button and click on it
        driver.findElement(By.cssSelector("input[value='1']")).click();
        Thread.sleep(2000);

        // locate signup button and click on it
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);

        driver.close();
    }

}
