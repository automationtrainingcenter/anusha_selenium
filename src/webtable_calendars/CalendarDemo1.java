package webtable_calendars;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utitlity.BrowserConfig;

import java.util.List;

public class CalendarDemo1 extends BrowserConfig {

    private static void selectDate(WebDriver driver, By calendar, String date){
        boolean isDateFound = false;
        // locate table body of the calendar
        WebElement tbody = driver.findElement(calendar);
        // locate all rows inside the table
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        // iterate over every row and locate cells
        for(WebElement row: rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell : cells) {
                if(cell.getText().equals(date)) {
                    cell.findElement(By.tagName("a")).click();
                    isDateFound = true;
                    break; // terminate cells loop
                }
            }
            if(isDateFound) {
                break; // terminate rows loop
            }
        }
    }

    public static void main(String[] args) {
        String startDate = "25";
        String returnDate = "5";
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://www.abhibus.com/");
        sleep(2000);

        // locate Date of journey and click on it
        click(By.id("datepicker1"), "Date of Journey");
        selectDate(driver, By.cssSelector(".ui-datepicker-group-first tbody"), startDate);
        sleep(3000);
        click(By.id("datepicker2"), "Date of Return");
        selectDate(driver, By.cssSelector(".ui-datepicker-group-last tbody"), returnDate);

        sleep(3000);
        closeBrowser();
    }

}
