package com.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

/**
 * All elements needed for Google Main page
 */
@DefaultUrl("https://www.google.de")
public class GoogleHomePage extends PageObject {

    @FindBy(name = "q")
    public WebElementFacade searchInput;

    @FindBy(xpath = "//span[text()='I agree']")
    public WebElementFacade agreeButton;

    @FindBy(xpath = "//cite[text() ='www.wikipedia.org']")
    public WebElementFacade wikipediaLink;

    public void enterSearch(String text) {
        element(searchInput).waitUntilVisible();
        element(searchInput).typeAndEnter(text);
    }

    public void clickOnAgreeButton() {
        if (agreeButton.isPresent()) {
            agreeButton.click();
        }
    }

    public void clickOnSubmitButton() { searchInput.sendKeys(Keys.ENTER); }

    public void clickOnWikipedialink() { wikipediaLink.click(); }
}