package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.interactions.Action;

import com.pages.ContactsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsPageSteps {
	
	ContactsPage contactsPage = new ContactsPage(DriverFactory.getDriver());
	String expectedname;
	
	@Given("user moves to create new contact page and verify label")
	public void user_moves_to_create_new_contact_page() {
		
		//DriverFactory.getDriver().get("https://ui.cogmento.com/");
		
		contactsPage.moveToNewContactsPage();
		
	   
	}

	@When("user fills the new contact form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws Exception, IOException {
		
		ExcelReader reader = new ExcelReader();
	
			List<Map<String, String>> testData = 
					reader.getData("C:\\Users\\Hari\\eclipse-workspace\\CucumberHybrid_selenium_2025\\src\\test\\resources\\testdata\\cogmento.xlsx", sheetName);
	
		String firstName = testData.get(rowNumber).get("firstname");
		String lastName = testData.get(rowNumber).get("lastname");
		String middleName = testData.get(rowNumber).get("middlename");
		String description = testData.get(rowNumber).get("description");
		expectedname = firstName+" "+lastName;
	   contactsPage.fillNewContactForm(firstName, lastName, middleName, description);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		
		contactsPage.clickOnSaveBtn();
	    
	}

	@Then("verify the contact profile name")
	public void verify_the_contact_profile_name() {
	   
		String actualName = contactsPage.getContactProfileName();
		System.out.println(actualName);
		Assert.assertEquals(expectedname,actualName);
		
	}
	
	


}
