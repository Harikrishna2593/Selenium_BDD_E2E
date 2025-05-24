package stepdefinitions;

import com.pages.CompaniesPage;
import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CompaniesPageSteps {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private CompaniesPage newCompanyPage;
	private String exp_comapnyname;

	@When("user moves to menu list and select add new company")
	public void user_moves_to_menu_list_and_select_add_new_company() {

		newCompanyPage = homePage.clickOnNewCompanyBtn();
	}

	@Then("user is on company page and verifies page title {string}")
	public void user_is_on_company_page_and_verifies_page_title(String exp_cmpyTitle) {

		String act_cmpyTitle = newCompanyPage.getNewCompyPageTitle();

		Assert.assertEquals(exp_cmpyTitle, act_cmpyTitle);

	}

	@Then("user fills the form comapany name {string} and website {string} and email {string}")
	public void user_fills_the_form_comapany_name_and_website_and_email(String cmpyName, String website, String email) {
		exp_comapnyname = cmpyName;
		newCompanyPage.companyDetails(cmpyName, website, email);

	}

	@Then("user enters data for description {string} and no.of employees {string}")
	public void user_enters_data_for_description_and_no_of_employees(String descp, String no_emps) {

		newCompanyPage.companyDetails2(descp, no_emps);

	}

	@Then("user verifies company name and quits")
	public void user_verifies_company_name() {

		String act_cmpyName = newCompanyPage.getRegisteredCompanyName();
		Assert.assertEquals(exp_comapnyname, act_cmpyName);
		System.out.println(act_cmpyName);
		System.out.println(act_cmpyName);

	}

	@Then("user selects access as private and select username {string} from dropdown")
	public void user_selects_access_as_private_and_select_username_from_dropdown(String exp_user) {

		newCompanyPage.clickOnPublicAccess();
		String act_user = newCompanyPage.selectPrivateAllowedAcessUser();
		Assert.assertEquals(exp_user, act_user);

	}

	@Then("user enters Address {string} {string} {string} {string}")
	public void user_enters_address(String street, String city, String state, String pincode) {

		newCompanyPage.enterAddressDetails(street, city, state, pincode);

	}

	@Then("user enters personal email {string} and Industry {string}")
	public void user_enters_personal_email_and_industry(String pEmail, String industry) {
		
		newCompanyPage.enterEmailandIndustry(pEmail, industry);
		
	}

}
