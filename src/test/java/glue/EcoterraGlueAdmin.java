package glue;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import pages.Loginpage;

public class EcoterraGlueAdmin
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Homepage hp;
	public Loginpage lp;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method1(Scenario s)throws Exception
	{
		this.s=s;
		FileInputStream fi=new FileInputStream("E:\\leelajava\\ecoterra.com\\src\\test\\resources\\properties\\ecoterra_properties.properties");
		p=new Properties();
		p.load(fi);
	}
	
	@Given("^launch site$")
	public void launch_site()
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("cdpath"));
		driver=new ChromeDriver();
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(lp.logintype));
		driver.manage().window().maximize();
		
	}
	
	@When("^click on dropdown and select admin from dropdown$")
	public void click_on_dropdown_and_select_admin_from_dropdown()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.logintype));
		lp.selectDropDown();
	}
	
	@And("^fill username \"(.*)\"$")
	public void fill_username(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.uid));
		lp.filluid(x);
	}
	
	@And("^fill password \"(.*)\"$")
	public void fill_password(String y)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd(y);
	}
	
	@And("^click login button$")
	public void click_login_button()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.loginbtn));
		lp.clickLogin();
	}
	
	@Then("^validate output for criteria \"(.*)\" for \"(.*)\" and \"(.*)\" for \"(.*)\"$")
	public void validate_output_for_criteria(String uc,String u,String pc,String p)throws Exception
	{
		Thread.sleep(5000);
	    try 
	    {
	    	if(uc.equals("valid") && pc.equals("valid") && hp.welcomemessg.isDisplayed())
	    	{
	    		
	    		wait.until(ExpectedConditions.visibilityOf(hp.welcomemessg));
	    		s.write("valid userid and password test passed");
	    	}
	    	else if(uc.equals("uid_blank") && pc.equals("valid") && lp.blankuidmessg.isDisplayed())
	    	{
	    		s.write("blank userid test passed");
	    	}
	    	else if(uc.equals("valid") && pc.equals("pwd_blank") && lp.blankpwdmessg.isDisplayed())
	    	{
	    		s.write("blank pwd test passed");
	    	}
	    	else if(uc.equals("invalid") && pc.equals("valid") && lp.uiderrmessg.isDisplayed())
	    	{
	    		s.write("invalid uid test passed");
	    	}
	    	else
	    	{
	    		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    		s.embed(ss,"login test failed");
	    		Assert.fail();
	    	}
	    }
	    catch(Exception ex)
	    {
	    	byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		s.embed(ss,ex.getMessage());
    		Assert.fail();
	    }
	
	}
	@And("^close site$")
	public void close_site()
	{
		driver.close();
	}
}
