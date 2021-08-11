package basics;

import actions.BrowserName;
import utitlity.BrowserConfig;

public class TestBrowserConfig extends BrowserConfig{

    public static void main(String[] args) {
//        BrowserConfig.launchBrowser(BrowserName.CHROME, "http://www.google.com");
//        BrowserConfig.sleep(3000);
//        BrowserConfig.closeBrowser();
        launchBrowser(BrowserName.CHROME, "http://www.google.com");
        sleep(3000);
        closeBrowser();
    }
}
