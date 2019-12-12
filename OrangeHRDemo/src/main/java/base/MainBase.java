package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainBase {

	static WebDriver driver;

	public static void initialize() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ayesha\\eclipse-workspace\\OrangeHRDemo\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		Date d = new Date();
		System.out.println("Start Time: " + d);

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\Ayesha\\eclipse-workspace\\OrangeHRDemo\\src\\main\\java\\configData\\orange.properties");

		prop.load(ip);

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		
		System.out.println(prop.getProperty("message"));
		
		String CURL=driver.getCurrentUrl();
		String TURL=driver.getTitle();
		
		if(CURL.equals(prop.getProperty("URL")) && TURL.contains("OrangeHRM")) {
			System.out.println("Captain, we are good to go!");
				} else {System.out.println(CURL +" "+ TURL);
		}
	}

	public static void shutdown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		Date d = new Date();
		System.out.println("End Time: " + d);

	}
	
}
