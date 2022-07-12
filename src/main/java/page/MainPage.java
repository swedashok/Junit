package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MainPage extends BasePage {
WebDriver driver;



	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")
	WebElement DataCategoryField;

	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement AddCategoryButton;
	String enteredData;


	public void AddCategory(String data) {
		enteredData = data + randomGenerator(999);
		DataCategoryField.sendKeys(enteredData);
	}
	public void ClickAddCategory() {
		AddCategoryButton.click();
	}

	String before_xpath = "//html/body/div[3]/a[";
	String after_xpath = "]/span";

    public void verifyEnteredCategory() {

		for(int i = 2; i <= 1000; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			 if(name.contains(enteredData)) {
				System.out.println("Entered name exist!!!");

			}
			break;
		}
	}
    public void AddDublicateCategory(String data) {
    	DataCategoryField.sendKeys(data);

}

    @FindBy(how=How.XPATH, using = "/html/body/text()[1]")
    WebElement CategoryExist;
    @FindBy(how=How.XPATH, using = " /html/body/a[2]")
    WebElement NeverMindButton; 


    public void clickAddCategoryDublicate() {

		   	NeverMindButton.click();			

		}
    @FindBy(how = How.XPATH, using = "//select[@name='due_month']")
    WebElement MonthDropDown;

 
	public void DateFormatValidation() {


    	String arr[]= {"None", "Jan", "Feb","Mar","Apr", "May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

		Select sel = new Select (MonthDropDown);
		List<WebElement> dropDownValues = sel.getOptions();

		for(int i=0; i<dropDownValues.size(); i++ ) {
			Assert.assertEquals(arr[i], dropDownValues.get(i).getText() );
		}

    }


	}