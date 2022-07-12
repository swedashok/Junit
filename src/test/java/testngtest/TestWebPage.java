package testngtest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.MainPage;
import util.BrowserFactory;

public class TestWebPage {


WebDriver driver;

@Test
		public void addCategoryButton() throws InterruptedException {

		driver = BrowserFactory.init();

		//adding items
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.AddCategory("Ashok");
		mainPage.ClickAddCategory();
		mainPage.verifyEnteredCategory();
		Thread.sleep(5000);

		mainPage.AddDublicateCategory("Sharma");
		mainPage.ClickAddCategory();
		mainPage.AddDublicateCategory("Sharma");
		mainPage.ClickAddCategory();
		Thread.sleep(5000);
		mainPage.clickAddCategoryDublicate();
		mainPage.DateFormatValidation();
		//BrowserFactory.tearDown();

}


}