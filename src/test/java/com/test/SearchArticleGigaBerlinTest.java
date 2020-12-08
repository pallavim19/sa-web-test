package com.test;

import com.requirement.SearchArticle;
import com.step.SearchArticleEndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static com.util.SearchArticleTestData.GIGA_BERLIN;
import static com.util.SearchArticleTestData.WIKIPEDIA;

/**
 * Test cases for Search Article for Giga Berlin.
 */
@Story(SearchArticle.GigaBerlin.VerifyDetailsInGoogleAndWikipedia.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchArticleGigaBerlinTest {

    @Managed
    WebDriver driver;

    @Steps
    SearchArticleEndUserSteps endUser;

    @Test
    @Title("Open Google Search Engine and search Wikipedia")
    public void navigateGoogleSearchPageAndSearchWikipedia() {
        // Google Main Page
        endUser.openHomePage();
        endUser.clickOnAgreeButton(driver);
        endUser.enterSearchText(WIKIPEDIA);
        endUser.clickOnSubmitButton();
    }

    @Test
    @Title("In search box of Wikipedia submit Article as GigaBerlin and verify Coordinates, Logistics and Site Concerns." +
            " Then verify the co-ordinates of Searched Article from Wikipedia in new Tab of Google Map")
    public void openWikipediaAndSearchArticleVerifyDetailsAndOpenGoogleMapThenVerifyAddress() {
        // Wikipedia Page
        endUser.clickOnLink();
        endUser.enterWikipediaText(GIGA_BERLIN);
        String coordinates = endUser.getAndVerifyCoordinates();
        endUser.verifySiteConcerns();
        endUser.verifyLogistics();
        // Google Map Page
        endUser.openNewTab(driver);
        endUser.clickOnAgreeButton(driver);
        endUser.enterCoordinatesText(coordinates);
        endUser.clickOnCoordinates();
        endUser.verifyAddress();
    }
}
