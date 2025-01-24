package FacebookLoginPackage.FacebookLoginProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ItestLisntenerPro implements ITestListener {

	static WebDriver driver;
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		Reporter.log("This Test Case is Passed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\sandeep.kumar\\eclipse-workspace\\FacebookLoginProject\\Screenshots\\Passed\\Screenshot "+ Math.random() + ".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		Reporter.log("This Test Case is Faild");
	}
	

}
