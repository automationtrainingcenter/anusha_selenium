package basics;
/*WebElement interface methods
This interface contains methods to perform common actions on the element

1. click() is used to click on an element

2. sendKeys(CharSequence... arg) is used to type some data in a text field and text
area. This method will send data character by character.

3. clear() is used to clear existing data in the text field or text area.

4. getText() returns String value which is an inner text of the given element if any

5. submit() is used to submit a form to the server if that form submit button is
implemented using <input> tag

6. getAttribute(String att_name) returns a String which is attribute value of the given
attribute name

7. getCssValue(String css_property_name) returns a String which is value of the
given css property name

8. getSize() returns Dimension class object which is height and width of the given element

9. getLocation() returns Point class object which is x and y coordinate values of the element
in the web page from top left cornor


10. getTagName() returns name of the tag of given element

11. findElement(By arg) returns WebElement interface reference this method will
locate an element in the GIVEN ELEMENT based on the locating technique we
specified using 'By' class and stores in a WebElement reference. If no
element is present in the page with locating technique then this method will
throw NoSuchElementException

12. findElements(By arg) returns a java.util.List of WebElement type this method
will locate either zero or more elements in the GIVEN ELEMENT based on the
locating technique we specified using 'By' class and store in
List<WebElement>. if no element is present in the page with locating
technique then this method will return a List of size 0.

13. isDisplayed() returns true if given element is displayed in the web page

14. isEnabled() returns true if given element is in active mode or enabled mode

15. isSelected() returns true if given option of either dropdown list or list box or
radio button or check box is selected.
*/

import actions.BrowserName;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

public class WebElementMethods {

    public static void main(String[] args) throws Exception{
        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();

        // submit()
        driver.findElement(By.id("pass")).submit();
        Thread.sleep(2000);
        // clicking back button to go back to the facebook home page
        driver.navigate().back();
        Thread.sleep(2000);

        // click
        WebElement create_new_account_link = driver.findElement(By.linkText("Create New Account"));
        create_new_account_link.click();

        Thread.sleep(2000);

        // sendKeys(CharSequence input)
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Surya");
        Thread.sleep(2000);

        // clear
        firstname.clear();
        Thread.sleep(2000);

        //getText() returns innertext of given element
        String btnText = driver.findElement(By.name("websubmit")).getText();
        System.out.println("button text is "+btnText);

        // getAttribute(String attName) returns value of the given attribute
        String lnameAriaLabel = driver.findElement(By.name("lastname")).getAttribute("aria-label");
        System.out.println("last name aria label attribute value is "+lnameAriaLabel);

//        firstname.sendKeys("Anusha");
//        System.out.println(firstname.getAttribute("value"));

        // getCssValue(String cssPropertyName) returns value of given CSS Property
        String cssValue = create_new_account_link.getCssValue("font-size");
        System.out.println(cssValue);

        // getTagName() returns tag name of the given element
        String tagName = firstname.getTagName();
        System.out.println("first name tag name is "+tagName);
        String tagName1 = create_new_account_link.getTagName();
        System.out.println("create new account tag name is "+tagName1);

        // getSize() returns size of given element as Dimension class object
        Dimension size = create_new_account_link.getSize();
        System.out.println("create new account link width is "+size.getWidth()+" and height is "+size.getHeight());

        // getLocation() returns location of the given element as Point class object
        Point location = create_new_account_link.getLocation();
        System.out.println("create new account link is at x = "+location.getX()+" and at y = "+location.getY());

        // isDisplayed() returns true if given element is present is HTML source code and displayed in web page also
        System.out.println(driver.findElement(By.name("reg_email_confirmation__")).isDisplayed()); // false

        // isEnabled() return true if given element is in active state
        System.out.println(firstname.isEnabled()); // true

        // isSelected() return true if given dropdown options, list box options, radio buttons or check boxes
        WebElement femaleRadio = driver.findElement(By.cssSelector("input[value='1']"));
        System.out.println(femaleRadio.isSelected()); // false
        femaleRadio.click();
        System.out.println(femaleRadio.isSelected()); // true



        driver.close();


    }

}
