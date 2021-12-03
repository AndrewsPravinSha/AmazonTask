package aps.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aps.util.BaseClass;

public class ShopCluesPojo extends BaseClass{
	public ShopCluesPojo(){
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(xpath="//a[text()='Mobiles & More']"),
		@FindBy(xpath="(//a[@href='javascript:void(0);'])[23]")
	})
	private WebElement mobile;
	
	@FindBy(xpath="(//a[text()='Pen Drives'])[1]")
	private WebElement pendrives;
	
	@FindBy(xpath="//span[@class='prod_name ']")
	private WebElement pendriveCollection;

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getPendrives() {
		return pendrives;
	}

	public WebElement getPendriveCollection() {
		return pendriveCollection;
	}

}
