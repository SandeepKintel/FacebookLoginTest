package FacebookLoginPackage.FacebookLoginProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ItestLisntenerPro.class)
public class FacebookLaunchAndQuit extends ItestLisntenerPro{
	
	@BeforeMethod
	public void LaunchFb()
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void QuitFb()
	{
		driver.quit();
	}
	

}
