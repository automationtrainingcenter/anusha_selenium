package basics;

import actions.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

import java.util.List;

/*
By class methods or Locating Techniques of selenium
Note 1: To locate any element in the webpage right click on that
element and click inspect, then that element will be highlighted
in the html source code
Note 2: Every html element is implemented using a tag and every
element contains multiple attributes with values
eg:
	<input id="fname"
	name = "firstName"
	class = "inputtext _58mg _2ph-"
	aria-label="Enter first name"
	aria-required = "true"></input>
Here <input ....> opening tag and </input> is closing tag.
id, name, class, aria-lable, aria-required are the attribute name
fname, firstName, inputtext _58mg _2ph- and true are the attribute values
Note 3: we can locate an element using any of the attribute and it's value
The following are the methods of By class as per the priority of locating
an element. All these methods are static methods so we can call them using
class name itself. All these methods accepts string arg and returns By class
reference
1. id(String arg) : returns a By class reference
it is used to locate an element using it's id attribute value.
2. name(String arg) : it is used to locate an element using it's name
attribute value.
Note: if an element contains a dynamic id or does not contains an id or
duplicate name attribute then we can't locate those elements using id
or name. so we have to use below techniques.
Dynamic ids are id attribute values which will change when ever we refresh
a web page.
If we are locating a link and that link does not contains unique id or name
attribute then we can locate those links using following techniques
3. linkText(String arg): is used to locate a link using link text
link text is the inner text of the <a> tag
inner text means the text in between opening and closing tag
linktext means the text in between <a> and </a>
4. partialLinkText(String arg): is used to locate a link using part of
the link text instead of complete link text
To locate any element other than links which does not contains unique id
or name attribute we can use following techniques
5. cssSelector(String arg): is used to locate any element using any
attribute value
syntax:
	"tagName[att_name = 'att_value']"
6. xpath(String arg): is also used to locate any element using any attribute
value
syntax:
	"//tagName[@att_name = 'att_value']"
The below two methods are generally used to locate multiple elements
7. className(String arg) : is used to locate either single or multiple elements using
class name of the element.
Note: there is a probability a class attribute can have multiple class names
eg: in above element class attribute value is class = "inputtext _58mg _2ph-"
in above class attribute value we have 3 classes and we have to use any one class name
in className() argument, we are not allowed to use multiple class names in
className() argument

	By.className("inputtext") is valid
	By.className("_58mg") is also valid
	By.className("_2ph-") is also valid
	By.className("inputtext _58mg _2ph-") is invalid because the argument contains three class names
8. tagName(String arg): is used to locate either single or multiple elements using
name of the tag.
 */
public class LocatingTechniques {
    public static void main(String[] args) {

        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();
        // maximize the browser window
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");

        // locate an element using id attribute
        WebElement email = driver.findElement(By.id("email"));

        // locate an element using name attribute
        WebElement pass = driver.findElement(By.name("pass"));

        // locate an element using linkText
        WebElement forgotPassword = driver.findElement(By.linkText("Forgotten password?"));

        // locate an element using partialLinkText
        WebElement createAPage = driver.findElement(By.partialLinkText("Create a"));

        // locate an element using css selector
        WebElement loginButton = driver.findElement(By.cssSelector("button[name='login']"));

        // locate an element using xpath
        WebElement createNewAccount = driver.findElement(By.xpath("//a[@href='#']"));

        // locate an element using className
        List<WebElement> inputs = driver.findElements(By.className("inputtext"));
        System.out.println(inputs.size());

        // locate element using tagName
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println(buttons.size());

        driver.close();
    }
}
