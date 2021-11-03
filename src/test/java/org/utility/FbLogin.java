package org.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class FbLogin extends BaseClass {

	public FbLogin() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement txtUser;
	@FindBy(name="pass")
	private WebElement txtPass;
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnLogn;
	
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement amazonsearchbox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchbtn;
	
	
	public WebElement getAmazonsearchbox() {
		return amazonsearchbox;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getTxtUser() {
		return txtUser;
	}
	public WebElement getTxtPass() {
		return txtPass;
	}
	public WebElement getBtnLogn() {
		return btnLogn;
	}
	
	
	
	
	

}
