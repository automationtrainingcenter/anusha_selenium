package basics;
/*
 * Window interface methods or Browser management
 *
 * public interface WebDriver{
 * 		void close();
 * 		void quit();
 *
 * 		Options manage();
 *
 *
 * 		interface Options{
 *
 *			Window window();
 *
 * 		}
 *
 * 		interface Window{
 *
 * 			void maximize();
 * 			void fullScreen();
 *
 * 		}
 * }
 *
 *
 * WebDriver driver = new ChromeDriver();
 * Options opt = driver.manage();
 * Window win = opt.window();
 * win.maximize();
 *
 *
 * driver.manage().window().maximize(); // object chaining
 *
 *
 * 1. maximize(): is used to maximize the browser window
 * 2. fullScreen(): is used to full screen mode(F11 mode) the browser window.
 * 3. getSize(): is used to retrieve the size of the browser window as a Dimension class object
 * 	  Note: Dimension class contains getWidth() and getHeight() which will return width and height as integers
 * 4. getPosition(): is used to retrieve the position of the browser window from top left corner the screen
 * as a Point class object
 * 	  Note: Point class contains getX() and getY() methods which will return x and y coordinate values of the
 * 		browser window
 * 5. setSize(Dimension arg): is used to set the browser width and height to the given width and height using
 * Dimension class object
 * 6. setPosition(Point arg): is used to set the position of the browser window from the top left corner using
 * Point class object
 *
 */

import actions.BrowserName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utitlity.DriverConfig;

public class WindowMethods {

    public static void main(String[] args) throws InterruptedException {

        DriverConfig.setDriverPath(BrowserName.CHROME);
        WebDriver driver = new ChromeDriver();

        // create an object reference to the Window interface
        WebDriver.Options opts = driver.manage();
        WebDriver.Window window = opts.window();
//        WebDriver.Window window1 = driver.manage().window();

        // getSize(): Dimension class object which contains getWidth() getHeight() methods
        Dimension size = window.getSize();
        System.out.println("width of the browser window is "+size.getWidth());
        System.out.println("height of the browser window is "+size.getHeight());


        // getPosition(): Point class object which Contains getX() and getY() methods
        Point pos = window.getPosition();
        System.out.println("window is at x = "+pos.getX());
        System.out.println("window is at y = "+pos.getY());

        // maximize()
        window.maximize();
        Thread.sleep(3000);

        // fullscreen()
        window.fullscreen();
        Thread.sleep(3000);

        // setSize(Dimension d)
        Dimension dim = new Dimension(600, 373);
        window.setSize(dim);
//        window.setSize(new Dimension(600, 300));
        Thread.sleep(3000);


        // setPosition(Point p)
        Point p = new Point(400, 350);
        window.setPosition(p);
        Thread.sleep(3000);


        driver.close();

    }
}
