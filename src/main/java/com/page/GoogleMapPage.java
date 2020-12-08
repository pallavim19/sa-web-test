package com.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

/**
 * All elements needed for Google Map Page
 */
public class GoogleMapPage extends PageObject {
	
	@FindBy (xpath = "//input[@id='searchboxinput']")
	public WebElementFacade coordinatesInput;

	@FindBy (xpath = "//span[contains(text(),'Grünheide, 15537 Grünheide (Mark)')]")
	public WebElementFacade locationAddressText;

	public void enterCoordinates(String text) {
		element(coordinatesInput).waitUntilVisible();
		element(coordinatesInput).typeAndEnter(text);
	}

	public void clickOnCoordinates() { coordinatesInput.sendKeys(Keys.ENTER); }

	public String getGruenheideAddressText(){ return locationAddressText.getText(); }
}
