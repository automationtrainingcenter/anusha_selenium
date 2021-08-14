package test_utility;

import actions.BrowserName;
import org.openqa.selenium.By;
import utitlity.BrowserConfig;

public class TestClick extends BrowserConfig {

    public static void main(String[] args) {
        launchBrowser(BrowserName.CHROME, "http://facebook.com");
        sleep(2000);
        click(By.name("login"), "Sing in button");
        sleep(2000);
        closeBrowser();
    }

}
