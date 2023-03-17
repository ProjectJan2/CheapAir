package com.aiiet.Pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiiet.BasePackage.BaseClass;

public class TripDetails extends BaseClass {
	public TripDetails() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[1]")
	public WebElement departureamTime;
	
	@FindBy(xpath="(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[2]")
	public WebElement landingpmTime;
	
	@FindBy(xpath = "(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[3]")
	public WebElement returningamTime;
	
	@FindBy(xpath="(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[4]")
	public WebElement landingpmTime2;
	
	@FindBy(xpath="//table//tr")
	public List<WebElement> table;
	
	@FindBy(xpath="//div[text()='Continue']")
	public WebElement contin;
}
