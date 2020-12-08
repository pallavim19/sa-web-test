package com.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * All element for Wikipedia Home page
 */
public class WikipediaHomePage extends PageObject {

	@FindBy(xpath = "//input[@id='searchInput']")
	public WebElementFacade searchArticle;

	public void enterArticle(String text) {
		element(searchArticle).waitUntilVisible();
		element(searchArticle).typeAndEnter(text);
	}
}
