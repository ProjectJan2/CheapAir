package com.aiiet.Pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aiiet.BasePackage.BaseClass;

public class Register extends BaseClass {
	public Register() {
		PageFactory.initElements(driver,this);
	}
	
}
