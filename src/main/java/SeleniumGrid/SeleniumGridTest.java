package SeleniumGrid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class SeleniumGridTest {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome"); // or "firefox" / "MicrosoftEdge"

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
