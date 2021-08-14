package mouse_events;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utitlity.BrowserConfig;

public class TooltipDemo extends BrowserConfig {
    public static void main(String[] args) {
        WebDriver driver = launchBrowser(BrowserName.CHROME, "https://jqueryui.com/tooltip/");
        sleep(2000);

        // all elements inside the frame so switch to frame
        driver.switchTo().frame(0);
        // now driver focus is in frame locate required elements
        WebElement linkTooltips = getElement(By.linkText("Tooltips"), "ToolTips link");
        WebElement linkThemeRoller = getElement(By.linkText("ThemeRoller"), "ThemeRoller link");
        WebElement txtBoxAge = getElement(By.id("age"), "Age Textbox");

        // NOTE: To locate the tooltip pause the javascript execution by pressing Control + \ or F8 key from sources menu tab of developer tools
        //Create Actions class object
        Actions actions = new Actions(driver);

        // move mouse to ToolTips link and get the tooltip text and print on the console
        actions.moveToElement(linkTooltips).build().perform();
        sleep(2000);
        String tooltip_content = getElement(By.cssSelector(".ui-tooltip-content"), "Tooltip content").getText();
        System.out.println("ToolTips link tooltip content is "+tooltip_content);

        // move mouse to ThemeRoller link and get the tool tip text and print on the console
        actions.moveToElement(linkThemeRoller).build().perform();
        sleep(2000);
        tooltip_content = getElement(By.cssSelector(".ui-tooltip-content"), "Tooltip content").getText();
        System.out.println("Theme Roller link tooltip content is "+tooltip_content);


        // move mouse to Age text box and get the tool tip text and print on the console
        actions.moveToElement(txtBoxAge).build().perform();
        sleep(2000);
        tooltip_content = getElement(By.cssSelector(".ui-tooltip-content"), "Tooltip content").getText();
        System.out.println("Age Text box tooltip content is "+tooltip_content);

        /*
         actions.contextClick() -- automate right click event where ever the mouse is
         actions.doubleClick() -- automate double click event where ever the mouse is
         actions.contextClick(WebElement element) -- automate right click event on the given element
         actions.doubleClick(WebElement element) -- automate double click event on the given element
         */


        closeBrowser();
    }
}
