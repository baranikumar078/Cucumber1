package org.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.utility.BaseClass;
import org.utility.FbLogin;

import io.cucumber.java.en.*;

public class FacebookLoginStepDefinition extends BaseClass{


@Given("The User should launch the Chrome Browser")
public void the_User_should_launch_the_Chrome_Browser() {
    launchChrome();
}

@When("The User should type the Url")
public void the_User_should_type_the_Url() {
   loadUrl("https://www.facebook.com/");
}

@When("The User should maximize the windows")
public void the_User_should_maximize_the_windows() {
  maxWindow();
}

@When("The User should type the Invalid Username Invalid Password")
public void the_User_should_type_the_Invalid_Username_Invalid_Password() throws IOException {
   FbLogin f=new FbLogin();
   fillValue(f.getTxtUser(),getData(2,2));
   fillValue(f.getTxtPass(),getData(2, 4));
}


@When("The User should Click the Login button")
public void the_User_should_Click_the_Login_button() throws InterruptedException {
   FbLogin f=new FbLogin();
   clickBtn(f.getBtnLogn());
   Thread.sleep(5000);
}

@Then("The User should Navigate to Incorrect Credential page")
public void the_User_should_Navigate_to_Incorrect_Credential_page() {
    
  Assert.assertTrue("Wrong Page", currentUrl().contains("privacy_mutation_token"));
   System.out.println("Test Passed");
}


@When("The User should get the Title of the Current Webpage")
public void the_User_should_get_the_Title_of_the_Current_Webpage() {
   printTilte();
}

@When("The User should type the Invalid Username{string} valid Password{string}")
public void the_User_should_type_the_Invalid_Username_valid_Password(String string, String string2) {
	FbLogin f=new FbLogin();
	   fillValue(f.getTxtUser(),string);
	   fillValue(f.getTxtPass(),string2);
}



}
