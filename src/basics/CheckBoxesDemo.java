package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

import java.util.List;

public class CheckBoxesDemo {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://courses.letskodeit.com/practice");

        // select BMW
        driver.findElement(By.id("bmwcheck")).click();
        Thread.sleep(2000);

        // select Honda
        driver.findElement(By.id("hondacheck")).click();
        Thread.sleep(2000);

        // select Benz
//        driver.findElement(By.id("benzcheck")).click();
        Thread.sleep(2000);

        // unselect the check boxes which were already selected
        List<WebElement> cars = driver.findElements(By.name("cars"));
        for(WebElement car : cars) {
            if(car.isSelected()){
                car.click();
                Thread.sleep(2000);
            }
        }


        driver.close();

    }
}
