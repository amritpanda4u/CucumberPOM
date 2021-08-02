package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private ConfigReader reader;
	private DriverFactory driverFactory;
	private WebDriver driver;
	public Properties prop;
	public String browserName = "";
	public String url = "";

	@Before()
	public void readProperties() {
		System.out.println("App hooks : Init properties");
		reader = new ConfigReader();
		prop = reader.initProp();
		browserName = prop.getProperty("browser");
		url = (String) prop.get("url");
	}

	@Before("@browser")
	public void initilize() {
		System.out.println("App hooks : driverfactory.initDriver()"); // String
		browserName = prop.getProperty("browser");
		browserName = "chrome";
		System.out.println("App hooks : Initialize : browserName : " + browserName);
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);
	}

	@After("@browser")
	public void tearDown() {
		driver.quit();
	}

	@After()
	public void takescreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			String filename = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", filename);
		}
	}

}
