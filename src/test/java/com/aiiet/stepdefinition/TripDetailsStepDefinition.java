package com.aiiet.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aiiet.BasePackage.BaseClass;
import com.aiiet.Pagefactory.TripDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TripDetailsStepDefinition extends BaseClass {
	@Given("Verify text of the departure time")
	public void verifyDepartureTime() {
		TripDetails td = new TripDetails();
		String text = td.departureamTime.getText();
		System.out.println("first Text = "+text);
		String text1 = td.landingpmTime.getText();
		System.out.println("first Text1 = "+text1);
		if(DepartureStepDefinition.am.equalsIgnoreCase(text) && DepartureStepDefinition.pm.equalsIgnoreCase(text1)) {
			System.out.println("the time is equal");
		}
		else
			System.out.println("the time is not equal");
	}

	@When("Verify text of the returning time")
	public static void verifyReturningTime() {
		TripDetails td = new TripDetails();
		String text = td.returningamTime.getText();
		System.out.println("Text = "+text);
		String text1 = td.landingpmTime2.getText();
		System.out.println("text1 = " + text1);
		if(DepartureStepDefinition.am1.equalsIgnoreCase(text) && DepartureStepDefinition.pm1.equalsIgnoreCase(text1)) {
			System.out.println("the time1 is equal");
		}
		else
			System.out.println("the time1 is not equal");
	}

	@Then("Verify the selected Members")
	public void members() throws IOException {
		TripDetails t = new TripDetails();
		int size = t.table.size();
		int adult = 0,senior = 0,child = 0,infant = 0;
		scrollToView(By.xpath("//table//td[text()='TOTAL']"));
		for (int i = 2; i <= size; i++) {
			String members = text(findElementBy("xpath", "(//table//tr)[" + i + "]//td[1]"));
			if (members.contains("Adult")) {
				adult++;
			}
			else if(members.contains("Senior")) {
				senior++;
			}
			else if(members.contains("Child")) {
				child++;
			}
			else if(members.contains("Infant")) {
				infant++;
			}
		}
		System.out.println("adult = "+adult);
		System.out.println("senior = "+senior);
		System.out.println("child = "+child);
		System.out.println("infant = "+infant);
		scrollToView(By.xpath("//div[text()='Continue']"));
		Takescreenshots("validation");
		if ((adult == HomePageStepDefinition.adults) && (senior == HomePageStepDefinition.senior) && (child == HomePageStepDefinition.child) && (infant == HomePageStepDefinition.infant)) 
			{
			//	click(t.contin);
			}
		click(t.contin);
	}
	}
