package FacebookLoginPackage.FacebookLoginProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends FacebookLaunchAndQuit {
	
	@Test(dataProvider="values", retryAnalyzer=FacebookLoginPackage.FacebookLoginProject.IRetryAnalyzerPro.class)
	public void LoginPageTest(String username, String password) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.EnterEmail(username);
		lp.EnterPassword(password);
		lp.ClickLogin();
		Thread.sleep(20000);
		String Title= driver.getTitle();
		System.out.println("Title is "+ Title);
		Assert.assertEquals(Title, "(20+) Facebook");
	}
	
	@DataProvider(name="values")
	public Object[][] dataset() throws IOException
	{
		FileInputStream f1 = new FileInputStream("C:\\Users\\sandeep.kumar\\eclipse-workspace\\FacebookLoginProject\\databook.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
		Sheet s1 = w1.getSheet("creds");
		String username = s1.getRow(1).getCell(0).getStringCellValue();
		String password = s1.getRow(1).getCell(1).getStringCellValue();
		
		Object[][] data = new Object[1][2];
		data[0][0]= username;
		data[0][1]= password;
		
		return data;
	}

}
