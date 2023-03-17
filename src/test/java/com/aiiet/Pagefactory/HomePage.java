package com.aiiet.Pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiiet.BasePackage.BaseClass;

public class HomePage extends BaseClass{
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="from1")
	public WebElement from;

	@FindBy(id="to1")
	public WebElement to;

	@FindBy(xpath="//div[@id='datePickerContainer']//table[1]//td")
	public List<WebElement> departs;

	@FindBy(xpath="(//div[@id='datePickerContainer']//table)[2]//td")
	public List<WebElement> return1;
	
	@FindBy(xpath="//input[@id='adults']/following-sibling::button[2]")
	public WebElement adults;
	
	@FindBy(id="adults")
	public WebElement Nadults;
	
	@FindBy(xpath="//input[@id='seniors']/following-sibling::button[2]")
	public WebElement senior;
	
	@FindBy(id="seniors")
	public WebElement Nsenior;
	
	@FindBy(xpath="//input[@id='children']/following-sibling::button[2]")
	public WebElement children;
	
	@FindBy(id="children")
	public WebElement Nchildren;
	
	@FindBy(xpath="//input[@id='infants']/following-sibling::button[2]")
	public WebElement infants;
	
	@FindBy(id="infants")
	public WebElement Ninfants;
	
	@FindBy(id="cabin")
	public WebElement economy;
	
	@FindBy(xpath="//button[text()='Search Flights']")
	public WebElement search;
	
	//popup close
	@FindBy(xpath="//div[@class='sc-fnGiBr kCVmbb']")
	public WebElement close;
	
	@FindBy(xpath="(//span[@class='sc-iaFMSK iVWAkA'])[1]")
	public WebElement price;
	@FindBy(xpath="(//span[text()='Eco Standard'])[1]")
	public WebElement eco;
	
	@FindBy(xpath="(//div[@class='sc-gikAfH exQzre']//button)[2]")
	public WebElement button;
}
