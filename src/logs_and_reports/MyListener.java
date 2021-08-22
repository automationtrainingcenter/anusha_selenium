package logs_and_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import utitlity.DriverConfig;

import java.io.File;

public class MyListener implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println(driver.switchTo().alert().getText());
        Reporter.test.info(driver.switchTo().alert().getText());
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("clicked on OK button of the alert");
        Reporter.test.info("clicked on OK button of the alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigating to "+url);
        Reporter.test.info("Navigating to "+url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Browser navigated to "+driver.getCurrentUrl());
        Reporter.test.info("Browser navigated to "+driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Located element successfully "+by.toString());
        Reporter.test.info("Located element successfully "+by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("clicked on element");
        Reporter.test.info("clicked on element");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Entered text "+element.getAttribute("value")+" in element");
        Reporter.test.info("Entered test "+element.getAttribute("value")+ " in element");
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
