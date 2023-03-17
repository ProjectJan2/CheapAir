package com.aiiet.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aiiet.BasePackage.BaseClass;
import com.aiiet.Pagefactory.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition extends BaseClass{
	public static int adults=5;
	public static int senior=2;
	public static int child=1;
	public static int infant=1;
	@Given("Browser Launch")
	public void browser_launch() {
		browserLaunch("chrome");
		url("https://www.cheapair.com/");
	}

	@When("Enter the Details")
	public void enter_the_details() throws AWTException, IOException {
		HomePage hp = new HomePage();
		Robot r = new Robot();
		wait(20);
		input(hp.from,"Madras, India");
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		input(hp.to,"Delhi, India");
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		hp.departs.clear();
		int size=hp.departs.size();
		System.out.println("size of depart calender = "+size);
		for(int i=0;i<=size;i++)
		{
			String date1=hp.departs.get(i).getText();
			if(date1.equals("20")) {
				hp.departs.get(i).click();
				break;
			}
		}
		int size1=hp.return1.size();
		System.out.println("size of return calender = "+size1);
		for(int i=0;i<=size1;i++)
		{
			String date12=hp.return1.get(i).getText();
			if(date12.equals("27")) {
				hp.return1.get(i).click();
				break;
			}
		}
		
		// Number of Adults
		//waitE(20,hp.adults);
		for(int i=1;i<adults;i++) {
			//waitE(20,hp.adults);
			hp.adults.click();
		}
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Object no_of_adults = js.executeScript("return arguments[0].getAttribute('value')",hp.Nadults);
		System.out.println("adults="+no_of_adults);
		
		//Number of Seniors
		for(int i=1;i<=senior;i++) {
			//waitE(20,hp.senior);
			hp.senior.click();
		}
		Object no_of_senior = js.executeScript("return arguments[0].getAttribute('value')",hp.Nsenior);
		System.out.println("senior="+no_of_senior);
		
		//Number of Children
		for(int i=1;i<=child;i++) {
			//waitE(20,hp.children);
			hp.children.click();
		}
		Object no_of_children = js.executeScript("return arguments[0].getAttribute('value')",hp.Nchildren);
		System.out.println("children="+no_of_children);
		
		//Number of Infants
		for(int i=1;i<=infant;i++) {
			//waitE(20,hp.infants);
			hp.infants.click();
		}
		Object no_of_infants = js.executeScript("return arguments[0].getAttribute('value')",hp.Ninfants);
		System.out.println("Infants="+no_of_infants);
		
		selectByText(hp.economy,"Economy");
		scrollToView(By.xpath("//button[text()='Search Flights']"));
		hp.search.click();//table//td[text()='TOTAL']
		Takescreenshots("home_page");
	}
	@Then("Validating the Details")
	public void validating_the_details() {
		wait(30);
		HomePage hp = new HomePage();
		window();
		hp.close.click();
	}
}
