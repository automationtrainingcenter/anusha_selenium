package webtable_calendars;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utitlity.BrowserConfig;

import java.util.List;

public class CalendarDemo2 extends BrowserConfig {
    public static void main(String[] args) {
        String startDate = "25";
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://www.makemytrip.com/");
        sleep(4000);

        // click manually somewhere
        // locate departure and click on it
        driver.findElement(By.xpath("//label[@for='departure']")).click();
        sleep(1000);
        boolean isDateFound = false;
        // locate element which contains all dates (calendar element)
        WebElement calendar = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]//div[contains(@class, 'Body')]"));
        // locate date rows
        List<WebElement> rows = calendar.findElements(By.className("DayPicker-Week"));
        // iterate over every row
        for(WebElement row : rows) {
            // located dates in every row
            List<WebElement> dates = row.findElements(By.className("DayPicker-Day"));
            // iterate every date
            for(WebElement date : dates) {
                if(date.getText().equals(startDate)) {
                    date.findElement(By.tagName("div")).click();
                    isDateFound = true;
                    break;
                }
            }
            if(isDateFound){
                break;
            }
        }
        sleep(3000);
        closeBrowser();
    }
}
