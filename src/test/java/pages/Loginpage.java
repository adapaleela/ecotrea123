package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Loginpage 
{
//	public WebDriver driver;
	
	@FindBy(name="LoginType")
	public WebElement logintype;
	
	@FindBy(name="UserName")
	public WebElement uid;
	
	@FindBy(name="Password")
	public WebElement pwd;
	
	@FindBy(xpath="//*[text()='Login']")
	public WebElement loginbtn;
	
	@FindBy(xpath="//*[text()='Invalid username or password.']")
	public WebElement uiderrmessg;
	
	@FindBy(xpath="//*[text()='The Password field is required.']")
	public WebElement blankpwdmessg;
	
	@FindBy(xpath="//*[text()='The User name field is required.']")
	public WebElement blankuidmessg;
	
	
	public Loginpage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void selectDropDown()
	{
		logintype.click();
		Select s=new Select(logintype);
		s.selectByVisibleText("Admin");
	}
	public void selectDropDown1()
	{
		logintype.click();
		Select s=new Select(logintype);
		s.selectByVisibleText("Employee");
	}
	public void selectDropDown2()
	{
		logintype.click();
		Select s=new Select(logintype);
		s.selectByVisibleText("Customer");
	}
	public void filluid(String x)
	{
		uid.sendKeys(x);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
}
