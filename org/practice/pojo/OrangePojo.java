package org.practice.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practical.base.BaseClass;

public class OrangePojo extends BaseClass{

	public OrangePojo() {
		PageFactory.initElements(driver,this);
	}
	
	@FindAll({
		@FindBy(xpath="(//input[@type='text'])[2]"),
		@FindBy(id="txtUsername"),
		@FindBy(name="txtUsername")
	})
	private WebElement orangeUserId;
	@FindAll({
		@FindBy(id="txtPassword"),
		@FindBy(name="txtPassword"),
		@FindBy(xpath="//input[@type='password']")
	})
	private WebElement orangePassword;
	@FindAll({
		@FindBy(xpath="//input[@type='submit']"),
		@FindBy(name="Submit"),
		@FindBy(id="btnLogin")
	})
	private WebElement orangeSubmitBtn;
	@FindAll({
		@FindBy(xpath="//a[contains(text(),'word?')]"),
		@FindBy(xpath="//div[@id='forgotPasswordLink']//a[@href]")
	})
	private WebElement orangeForgotPassword;
	@FindAll({
		@FindBy(id="spanMessage"),
		@FindBy(xpath="//span[text()='Invalid credentials']")
	})
	private WebElement invalidCred;
	
	@FindBy(id="welcome")
	private WebElement welcomeNote;
	public WebElement getInvalidCred() {
		return invalidCred;
	}
	public WebElement getWelcomeNote() {
		return welcomeNote;
	}
	public WebElement getOrangeUserId() {
		return orangeUserId;
	}
	public WebElement getOrangePassword() {
		return orangePassword;
	}
	public WebElement getOrangeSubmitBtn() {
		return orangeSubmitBtn;
	}
	public WebElement getOrangeForgotPassword() {
		return orangeForgotPassword;
	}

}
