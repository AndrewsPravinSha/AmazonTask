package org.practical.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practical.base.BaseClass;

public class AmazonPojo extends BaseClass{

	public AmazonPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindAll({
		@FindBy(id="twotabsearchtextbox"),
		@FindBy(xpath="//input[@type='text']"),
		@FindBy(xpath="//input[@dir='auto']"),
		@FindBy(xpath="//input[@aria-label='Search']")
	})
	private WebElement amzSearchBox;
	@FindAll({
		@FindBy(id="nav-search-submit-button"),
		@FindBy(xpath="//input[@type='submit']"),
		@FindBy(xpath="//input[@value='Go']")
	})
	private WebElement amzSearchButton;

	@FindAll({
		@FindBy(xpath="//span[contains(text(),'Choice')]"),
		@FindBy(xpath="//span[@data-a-badge-color='ac-orange']"),
		@FindBy(xpath="(//span[@class='a-badge-text'])[2]")
	})
	private WebElement amzChoice;

	@FindAll({
		@FindBy(id="priceblock_ourprice"),
		@FindBy(xpath ="//span[contains(@class,'priceBlockBuying')]"),
	})
	private WebElement amzPriceTag;

	@FindAll({
		@FindBy(xpath="//input[@value='Add to Cart']"),
		@FindBy(id="add-to-cart-button"),
		@FindBy(name="submit.add-to-cart"),
		@FindBy(xpath="//input[@title='Add to Shopping Cart']")

	})
	private WebElement addtoCartButton;

	@FindAll({
		@FindBy(xpath="//h1[contains(text(),'Added to Cart')]"),
		@FindBy(xpath="//h4[contains(text(),'Added to Cart')]"),
		@FindBy(xpath="//h1[contains(@class,'a-text-bold')]")
	})
	private WebElement addtoCartMessage;

	@FindAll({
		@FindBy(id="hlb-view-cart-announce"),
		@FindBy(xpath="//a[contains(text(),'Cart')]"),
		@FindBy(xpath="//input[contains(@aria-labelledby,'view-cart-button')]")
	})
	private WebElement CartButton;

	@FindBy(xpath="((//i[@aria-label='Amazon Prime'])[1]//following::img)[1]")
	private WebElement prime;

	@FindAll({
		@FindBy(id="nav-cart-count-container")
	})
	private WebElement cartContainer;
	@FindAll({
	@FindBy(xpath="//input[@value='Delete']"),
	@FindBy(xpath="//input[@data-action='delete']")
	})
	private WebElement deleteOrder;

	public WebElement getDeleteOrder() {
		return deleteOrder;
	}

	public WebElement getCartContainer() {
		return cartContainer;
	}

	public WebElement getPrime() {
		return prime;
	}

	public WebElement getCartButton() {
		return CartButton;
	}

	public WebElement getAmzSearchBox() {
		return amzSearchBox;
	}

	public WebElement getAmzSearchButton() {
		return amzSearchButton;
	}

	public WebElement getAmzChoice() {
		return amzChoice;
	}

	public WebElement getAmzPriceTag() {
		return amzPriceTag;
	}

	public WebElement getAddtoCartButton() {
		return addtoCartButton;
	}

	public WebElement getAddtoCartMessage() {
		return addtoCartMessage;
	}


}
