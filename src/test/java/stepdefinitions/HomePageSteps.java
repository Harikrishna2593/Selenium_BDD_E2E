package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		
		List<Map<String, String>> creds = credTable.asMaps();
		String userName = creds.get(0).get("username");
		String password = creds.get(0).get("password");
		
		DriverFactory.getDriver().get("https://ui.cogmento.com/");
		homepage = loginpage.doLogin(userName, password);
	 
	}

	@Given("user is on Home page")
	public void user_is_on_home_page() {
	  
		String title = homepage.getHomePageTitle();
		System.out.println("Home Page title is : "+title);
	}


	@Then("user gets home menu section")
	public void user_gets_home_menu_section(DataTable menuTable) {
		
		List<String> expMenuSectionList = menuTable.asList();
		System.out.println("Expected menu section list: "+expMenuSectionList);
		
		List<String> actualMenuSectionList = homepage.getHomeMenuList();
		System.out.println("Actual menu section list: "+actualMenuSectionList);
		
		Assert.assertTrue(expMenuSectionList.containsAll(actualMenuSectionList));
	   
	}

	@Then("menu section count should be {int}")
	public void menu_section_count_should_be(Integer expectedMenuListCount) {
	   
		Assert.assertTrue(homepage.getHomeMenuListCount() == expectedMenuListCount);
	}
	
	@Given("user is on home page and verifies account name {string} and account user {string}")
	public void user_is_on_home_page_and_verifies_account_name_and_account_user(String Exp_Acc_Name, String Exp_Acc_UserName) {
		
		String actual_AccName = homepage.getAccountName();
		String actual_AccUserName = homepage.getAccountUserName();
		
		Assert.assertEquals(Exp_Acc_Name, actual_AccName);
		Assert.assertEquals(Exp_Acc_UserName, actual_AccUserName);
	   
	}
	
}
