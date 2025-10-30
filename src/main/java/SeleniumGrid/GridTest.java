package SeleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class GridTest {

    WebDriver driver;
    String hubURL = "http://localhost:4444/wd/hub";

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(new URL(hubURL), new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(new URL(hubURL), new FirefoxOptions());
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new RemoteWebDriver(new URL(hubURL), new EdgeOptions());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void amazonSearchTest() throws Exception {
        driver.get("https://www.amazon.in/");
        String title = driver.getTitle();
        System.out.println("Browser: " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() +
                " | Title: " + title);

        // Perform a simple search
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Print search result title
        System.out.println("Search Results Page Title: " + driver.getTitle());
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
