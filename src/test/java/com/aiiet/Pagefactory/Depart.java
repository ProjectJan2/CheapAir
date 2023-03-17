package com.aiiet.Pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiiet.BasePackage.BaseClass;

public class Depart extends BaseClass{
	public Depart() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//span[@class='sc-iaFMSK iVWAkA'])[1]")
	public WebElement price;
	
	@FindBy(xpath="(//span[@class='sc-cNYriL iMFOwb'])[1]")
	public WebElement timeAM;
	
	@FindBy(xpath="(//span[@class='sc-cNYriL iMFOwb'])[2]")
	public WebElement timePM;
	
	@FindBy(xpath = "(//span[@class='sc-cNYriL iMFOwb'])[1]")
	public WebElement time1;

	@FindBy(xpath = "(//span[@class='sc-cNYriL iMFOwb'])[2]")
	public WebElement time2;
	
}
