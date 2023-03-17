package com.aiiet.stepdefinition;

import java.io.IOException;

import com.aiiet.BasePackage.BaseClass;
import com.aiiet.Pagefactory.Depart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepartureStepDefinition extends BaseClass {
	public static String am,pm,am1,pm1;
	@Given("get the text of the departure time")
	public void departureTime() throws InterruptedException {
		Thread.sleep(1000);
		Depart d = new Depart();
		am = d.timeAM.getText();
		pm = d.timePM.getText(); 
		System.out.println("depart am= "+am);
		System.out.println("depart pm= "+pm);
	}
	@When("select the departure ticket price")
	public void departPrice() throws IOException {
		Depart d = new Depart();
		Takescreenshots("depart");
		d.price.click();
	}
	@Then("get the text of the returning time")
	public void returningTime() throws InterruptedException {
		Thread.sleep(2000);
		Depart d = new Depart();
		am1 = d.time1.getText();
		pm1 = d.time2.getText();
		System.out.println("return am= "+am1);
		System.out.println("return pm= "+pm1);
	}
	@Then("select the return ticket price")
	public void returnPrice() throws IOException {
		Depart d = new Depart();
		Takescreenshots("return");
		d.price.click();
	}			
}
