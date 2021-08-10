package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiWindowDemo {

    public static void automateWindow(WebDriver driver, String title) throws InterruptedException {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowIds = new ArrayList<>(windowHandles);
        for(String windowID : windowIds) {
            driver.switchTo().window(windowID);
            if(driver.getTitle().toLowerCase().contains(title) && title.equals("google")){
                // automate that window
                driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER);
                Thread.sleep(5000);
                break;
            } else if(driver.getTitle().toLowerCase().contains(title) && title.equals("facebook")){
                // after above line driver focus is in facebook page
                driver.findElement(By.id("email")).sendKeys("Anusha");
                break;
            } else if(driver.getTitle().toLowerCase().contains(title) && title.equals("youtube")){
                // automate that window
                driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("Selenium Architecture");
                driver.findElement(By.xpath("//input[@name='search_query']")).submit();
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/suryaprakash/Documents/trainings/anusha_selenium/frames/framesDemo.html#");
        driver.manage().window().maximize();

        // locate open windows and click on it
        driver.findElement(By.id("opentTab")).click();

        // the above click will open 3 new windows
        // retrieve all the window handles and convert to list
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowIds = new ArrayList<>(windowHandles);

        // switch to every window and get the title of the window
//        for(String windowID : windowIds) {
//            driver.switchTo().window(windowID);
//            System.out.println(driver.getTitle());
//        }

        // automate facebook page
        driver.switchTo().window(windowIds.get(1));
        // after above line driver focus is in facebook page
        driver.findElement(By.id("email")).sendKeys("Anusha");
        Thread.sleep(2000);


        // automate google
        driver.switchTo().window(windowIds.get(3));
        // after above line driver focus is in google page
        driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER);
        Thread.sleep(5000);


        // automate youtube page
        driver.switchTo().window(windowIds.get(2));
        // after above line driver focus is in youtube page
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("Selenium Architecture");
        driver.findElement(By.xpath("//input[@name='search_query']")).submit();
        Thread.sleep(5000);

        // automate a given window
//        automateWindow(driver, "youtube");

        // automate main window
        driver.switchTo().window(windowIds.get(0));
        // after above line driver focus is in main page
        driver.findElement(By.id("opentWin")).click();

        driver.quit();

    }
}
