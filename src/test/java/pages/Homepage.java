package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	//public WebDriver driver;
	
	@FindBy(xpath="//*[text()='Welcome Back, admin admin of EcoTerra Consulting LLC']")
	public WebElement welcomemessg;
	
	public Homepage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
