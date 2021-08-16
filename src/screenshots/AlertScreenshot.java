package screenshots;

import actions.BrowserName;
import org.openqa.selenium.By;
import utitlity.BrowserConfig;
import utitlity.DriverConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AlertScreenshot extends BrowserConfig {
    public static void main(String[] args) {
        launchBrowser(BrowserName.CHROME, "https://courses.letskodeit.com/practice");
        click(By.id("alertbtn"), "Alert button");
        sleep(2000);

        // capture the screenshot of alert using Java Robot class
        try {
            Robot r = new Robot();
            BufferedImage img = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File desImg = new File(DriverConfig.getFolderPath("screenshots")+File.separator+"alertImage.png");
            ImageIO.write(img, "png", desImg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeBrowser();
    }
}
