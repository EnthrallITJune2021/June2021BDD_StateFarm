package stepDefs;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.LogClass;
import utils.ReadProperties;

public class BasePage {

	public static WebDriver driver;
	
	@Before
	public WebDriver setUpDriver() {
		//loadDriver();
		loadWebDriverManager();
		driver = new ChromeDriver();
		String url = ReadProperties.instanceOFProp().getURL();
		driver.get(url);
		driver.manage().window().maximize();
		int pageLoadTtime = ReadProperties.instanceOFProp().getPageLoadTime();
		int implicitLoadTime = ReadProperties.instanceOFProp().getImplicitLoadTime();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitLoadTime, TimeUnit.SECONDS);
		LogClass.logger.log(Level.INFO, "Driver is initiating....");
		return driver;
	}
	
	public void loadDriver() {
		String currentOS = System.getProperty("os.name");
		if(currentOS.startsWith("Win")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		} else if(currentOS.startsWith("Mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		}
	}
	
	public void loadWebDriverManager() {
		WebDriverManager.chromedriver().setup();
	}
	
	@After
	public void tearDown() {
		driver.quit();
		LogClass.logger.log(Level.INFO, "Driver is closing...");
	}
	
}
