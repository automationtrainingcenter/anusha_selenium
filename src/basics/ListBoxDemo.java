package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utitlity.DriverConfig;

public class ListBoxDemo {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().window().maximize();

        // locate fruits list box
        WebElement fruitsSelect = driver.findElement(By.id("multiple-select-example"));

        // create Select class object
        Select fruitsDropDown = new Select(fruitsSelect);

        // get all the options of the fruits drop down
        fruitsDropDown.getOptions().stream().map(WebElement::getText).forEach(System.out::println);

        // get all selected options
        fruitsDropDown.getAllSelectedOptions().stream().map(WebElement::getText).forEach(System.out::println);

        // select peach using index number
        fruitsDropDown.selectByIndex(2);
        Thread.sleep(2000);

        // select apple based on value attribute
        fruitsDropDown.selectByValue("apple");
        Thread.sleep(2000);

        // select orange based on inner text
        fruitsDropDown.selectByVisibleText("Orange");
        Thread.sleep(2000);

        // get all selected options count
        System.out.println(fruitsDropDown.getAllSelectedOptions().size());

        // deselect apple based on index number
        fruitsDropDown.deselectByIndex(0);
        Thread.sleep(2000);

        // deselect orange based on value attribute value
        fruitsDropDown.deselectByValue("orange");
        Thread.sleep(2000);

        // deselect peach based on inner text
        fruitsDropDown.deselectByVisibleText("Peach");
        Thread.sleep(2000);

        // deselect all the selected options
//        fruitsDropDown.deselectAll();
//        Thread.sleep(2000);

        System.out.println(fruitsDropDown.isMultiple());

        driver.close();



    }
}
