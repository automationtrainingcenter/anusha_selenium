package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utitlity.DriverConfig;

import java.util.List;

/*
Select class methdos
	Select is a class in Selenium which is used to automate drop down list
or list boxes which are implemented using <select> tag
<select name="cars">
	<option value="car1">Audi</option>  index = 0
	<option value="car2">Benz</option>  index = 1
	<option value="car3">BMW</option>  index =2
	<option value="car4">Suziki</option>  index = 3
	<option value="car5">Honda</option>  index = 4
</select>

1. selectByIndex(int index): is used to select an option based on index number
of the option tag and this index starts from 0

2. selectByValue(String valueAttrValue): is used to select an option based on the
value of the value attribute of the option tag

3. selectByVisibleText(String innerTextOptionTag): is used to select an option based
on the inner text of the option tag

4. getOptions() returns a List<WebElement>: this method returns all option tags of
the select tag as List of type web element

5. getFirstSelectedOption() returns WebElement: this is returns an option tag which
was selected by default.

6. isMultiple() returns true if given select class object is a list box i.e. which
allows multiple option selection

7. getAllSelectedOptions() returns a List<WebElement>: this method returns all option tags
which are selected

8. deselectByIndex(int index) is used to deselect an option based on index number

9. deselectByValue(String valueAttrValue) is used to deselect an option based on value
of the value attribute

10. deselectByVisibleText(String innerTextOptionTag) is used to deselect an
option based on the inner text of the option tag

11. deselectAll() is used to deselect all the selected options of a list box

All these are instance methods so we have create an object of the Select class to call these
methods

Syntax to create an object of Select class
	Select selectObj = new Select(WebElemnet select_tag_ele)
by above syntax first we have to locate Select tag and store in a WebElement reference
then pass that reference to the Select class constructor.

In above methods first 7 methods we can use on both list box and drop down list
but remaining 4 methods we can only use for list box.
 */
public class DropdownDemo {

    public static void main(String[] args) throws InterruptedException {
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().window().maximize();

        // locate dropdown select tag
        WebElement carselect = driver.findElement(By.id("carselect"));

        // create an object of Select class by passing above element as an argument
        Select carsDropDown = new Select(carselect);

        // get default option of the drop down
        WebElement firstSelectedOption = carsDropDown.getFirstSelectedOption();
        System.out.println("default option is "+firstSelectedOption.getText());

        // select Honda option by using index number
        carsDropDown.selectByIndex(2);
        Thread.sleep(2000);

        // select Benz option using value attribute value
        carsDropDown.selectByValue("benz");
        Thread.sleep(2000);

        // select BMW option suing inner text
        carsDropDown.selectByVisibleText("BMW");
        Thread.sleep(2000);


        // retrieve all the options of the drop downs
        List<WebElement> options = carsDropDown.getOptions();
        options.stream().map(WebElement::getText).forEach(System.out::println);

        // get all selected options
        carsDropDown.getAllSelectedOptions().stream().map(WebElement::getText).forEach(System.out::println);

        // verify select tag is drop down -- false or list box -- true
        System.out.println(carsDropDown.isMultiple());

        driver.close();
    }
}
