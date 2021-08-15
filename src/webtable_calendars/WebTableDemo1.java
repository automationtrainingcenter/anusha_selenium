package webtable_calendars;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

import java.util.List;

public class WebTableDemo1 extends BrowserConfig {

    public static void main(String[] args) {
        String companyCode = "HDFC";
        boolean isCompNotListed = true;
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://www1.nseindia.com/index_nse.htm");
        sleep(3000);

        // locate live market and mousehover on it then click pre open market
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#main_livemkt"))).build().perform();
        actions.moveToElement(driver.findElement(By.cssSelector("#main_livewth_preopenmkt"))).click().build().perform();
        sleep(4000);



        // locate table body
        WebElement tbody = driver.findElement(By.cssSelector("#livePreTable>tbody"));
        // locate all the rows with in the table body
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        // iterate over every row
        for(WebElement row : rows){
            // locate all the cells inside every row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // second cell contains company code and seventh cell contains share price
            if(cells.get(1).getText().equalsIgnoreCase(companyCode)){
                System.out.printf("Share price of %s is %s\n", companyCode, cells.get(6).getText());
                isCompNotListed = false;
                break; // terminate rows loop
            }
        }

        if(isCompNotListed){
            System.out.printf("%s company is not listed in Nifty 50");
        }

        closeBrowser();
    }
}
