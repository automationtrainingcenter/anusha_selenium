package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

import java.util.List;

public class AutoSuggestionsDemo {
    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();

        String suggestionToClick = "selenium ide";
        // locate search box and type something
        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(3000);

        // locate suggestion list
        WebElement suggestionsList = driver.findElement(By.className("erkvQe"));
        List<WebElement> suggestions = suggestionsList.findElements(By.tagName("li"));
        suggestions.stream().forEach(suggestion -> System.out.println(suggestion.getText()));

        for(WebElement suggestion : suggestions){
            if(suggestion.getText().equalsIgnoreCase(suggestionToClick)){
                suggestion.click();
                Thread.sleep(3000);
                break;
            }
        }

        driver.close();


    }
}
