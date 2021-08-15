package webtable_calendars;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utitlity.BrowserConfig;

import java.util.List;

/**
 * to handle webtables
 * 1. locate table tbody tag and store in a variable
 * 2. locate all the rows inside the tbody tag using tr tag
 * 3. iterate over every row then locate all the columns in every row using td tag
 * 4. iterate over the columns and automate them
 */
public class WebTableDemo extends BrowserConfig {

    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://courses.letskodeit.com/practice");
        sleep(2000);

        // locate table body i.e. tbody tag
        WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));
        // locate all the rows inside the table body
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        // iterate over every row and locate the cells
        for (WebElement row: rows) {
            // within every row locate cells or columns
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // iterate over every cell and print the inner text on the console
            for(WebElement cell : cells) {
                System.out.print(cell.getText() +"\t");
            }
            System.out.println();
        }


        closeBrowser();

    }
}
