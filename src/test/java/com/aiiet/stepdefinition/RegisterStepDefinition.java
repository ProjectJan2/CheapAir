package com.aiiet.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aiiet.BasePackage.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition extends BaseClass{
	@When("Enter the details for registration")
	public void details(DataTable dataTable) throws IOException {
		for (int i = 1; i <= 8; i++) {
				findElementBy("id","firstName" + i).sendKeys(dataTable.cell(1, i));
				findElementBy("id","middleName"+i).sendKeys(dataTable.cell(2, i));
				findElementBy("id","lastName"+i).sendKeys(dataTable.cell(3, i));
				selectByValue(findElementBy("id","suffix"+i),dataTable.cell(4, i));
				selectByValue(findElementBy("id","gender"+i),dataTable.cell(5, i));
				selectByText(findElementBy("id","dobMonth"+i),dataTable.cell(6, i));
				driver.findElement(By.id("dobDay"+i)).sendKeys(dataTable.cell(7, i));
				driver.findElement(By.id("dobYear"+i)).sendKeys(dataTable.cell(8, i));
				Takescreenshots("details");
		}
	}
	@Then("Enter the card details")
	public void card(DataTable dataTable) throws IOException {
		findElementBy("id","ccNum1").sendKeys(dataTable.cell(1, 1));
		selectByValue(findElementBy("id","expMonth1"),dataTable.cell(2,1));
		selectByText(findElementBy("id","expYear1"),dataTable.cell(3,1));
		findElementBy("id","cvv1").sendKeys(dataTable.cell(4,1));
		findElementBy("id","paymentName1").sendKeys(dataTable.cell(5,1));
		selectByText(findElementBy("id","paymentCountry1"),dataTable.cell(6,1));
		findElementBy("id","paymentAddress1").sendKeys(dataTable.cell(7,1));
		findElementBy("id","paymentAddress21").sendKeys(dataTable.cell(8,1));
		findElementBy("id","paymanetCity1").sendKeys(dataTable.cell(9,1));
		findElementBy("id","paymentPhone1").sendKeys(dataTable.cell(10,1));
		findElementBy("id","email").sendKeys(dataTable.cell(11,1));
		findElementBy("id","password").sendKeys(dataTable.cell(12,1));
		findElementBy("id","confirmPassword").sendKeys(dataTable.cell(13,1));
		Takescreenshots("card");
	}
}
