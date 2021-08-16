package webtable_calendars;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utitlity.BrowserConfig;

import java.util.List;

public class WebTableDemo2 extends BrowserConfig {

    public static void main(String[] args) {
        String companyCode = "TCSVinay sair ";
        boolean isCompNotListed = true;
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://www.bseindia.com/markets/Equity/equitysensexstream.html");
        sleep(2000);

        // locate table body
        WebElement tbody = driver.findElement(By.cssSelector(".largetable>table table>tbody"));
        // locate all the rows with in the table body
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        // iterate over every row
        for(WebElement row : rows){
            // locate all the cells inside every row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // second cell contains company code and seventh cell contains share price
            String code = cells.get(1).getText().trim();
            if(code.equalsIgnoreCase(companyCode)){
                System.out.printf("Share price of %s is %s\n", companyCode, cells.get(2).getText());
                cells.get(1).findElement(By.xpath(String.format("//a/span[contains(text(), '%s')]", code))).click();
//                cells.get(1).click();
                sleep(3000);
                isCompNotListed = false;
                break; // terminate rows loop
            }
        }

        if(isCompNotListed){
            System.out.printf("%s company is not listed in Nifty 50", companyCode);
        }

        closeBrowser();

    }
}
