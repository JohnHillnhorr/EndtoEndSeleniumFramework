package browserInitalize;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitialize {
	 
	public WebDriver driver;
	public LandingPage lp;
	
	
	public WebDriver startBrowser() throws IOException {
	Properties obj = new Properties();
	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
	obj.load(objfile);
	String browser = System.getProperty("browser") != null ? System.getProperty("browser") : obj.getProperty("browser_name");
	//String browser = obj.getProperty("browser_name");
	
	if(browser.contains("chrome")) {
		ChromeOptions option= new ChromeOptions();
		WebDriverManager.chromedriver().browserVersion("104").setup();
		if(browser.contains("headless")) {
		option.addArguments("headless");	
		}
		driver = new ChromeDriver(option);
		
		
	}
	
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	}
	
	else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();;
		driver = new EdgeDriver();
		
	}
	
	
	return driver;
	
	
	
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage GoToSite() throws IOException {
		driver = startBrowser();
		lp = new LandingPage(driver);
		lp.GotoSite();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return lp;
		}
	
	@AfterMethod(alwaysRun=true)
	public void CloseSite() throws IOException {
		
		driver.quit();
		}
	
	
	public List<HashMap<String, String>> getDataToPurchase(String filepath) throws IOException {
	
		
		String json = FileUtils.readFileToString(new File (filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String,String>>>() {});
		
		
		
		return data;
	}
	
	public String getScreenshot(String screenshotName, WebDriver driver) throws IOException {
		File scrShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File DestFile=new File(System.getProperty("user.dir")+ "\\src\\main\\java\\Screenshots\\" + screenshotName + ".png");
		  FileUtils.copyFile(scrShot, DestFile);
		  return System.getProperty("user.dir")+ "\\src\\main\\java\\Screenshots\\" + screenshotName + ".png";

	}
	
	
}
