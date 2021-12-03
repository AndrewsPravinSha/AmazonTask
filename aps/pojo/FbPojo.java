package aps.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aps.util.BaseClass;

public class FbPojo extends BaseClass{

	public FbPojo() {
		PageFactory.initElements(driver, this);
		}
	@FindAll({
		@FindBy(id="email"),
		@FindBy(name="email"),
		@FindBy(xpath = "//input[@data-testid='royal_email']"),
		@FindBy(xpath = "//input[contains(@placeholder,'Email')]")
	})
	private WebElement fbEmail;
	
	@FindAll({
		@FindBy(id = "pass"),
		@FindBy(name = "pass"),
		@FindBy(xpath = "//input[@placeholder='Password']")
	})
	private WebElement fbPaswrd;
	
	@FindAll({
		@FindBy(xpath = "//button[@type='submit']"),
		@FindBy(xpath = "//button[@data-testid='royal_login_button']"),
		@FindBy(xpath = "//button[text()='Log In']")
	})
	private WebElement fbLoginButton;
	
	@FindBy(xpath = "//a[text()='Forgotten password?']")
	private WebElement fbForgotPassword;
	
	@FindBy(xpath = "//a[text()='Create New Account']")
	private WebElement fbCreateNewAccnt;

	public WebElement getFbEmail() {
		return fbEmail;
	}

	public WebElement getFbPaswrd() {
		return fbPaswrd;
	}

	public WebElement getFbLoginButton() {
		return fbLoginButton;
	}

	public WebElement getFbForgotPassword() {
		return fbForgotPassword;
	}

	public WebElement getFbCreateNewAccnt() {
		return fbCreateNewAccnt;
	}

}
