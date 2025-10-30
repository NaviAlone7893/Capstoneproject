package SeleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;

public class AmazonGridTest {

    @Parameters("browser")
    @Test
    public void openAmazon(String browser) throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browser);

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("https://www.amazon.in");
        System.out.println(browser + " - Title: " + driver.getTitle());
        driver.quit();
    }
}
