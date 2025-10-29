package scenario2;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POM_Client {
	public WebDriver driver;
	public Login_Page l1;
	public Admin_Page a1;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		l1 = new Login_Page(driver);
		a1 = new Admin_Page(driver);
	}

	@Test
	public void testLogin_and_AdminPage() {
		l1.login("Admin", "admin123");
		a1.menu_options();
		a1.searchByUserName("Admin");
		a1.searchByUserRole();
		a1.searchByUserStatus();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}