package com.step;

import com.page.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.logging.Logger;

import static com.util.SearchArticleTestData.*;

/**
 * <p>Step Definition for Search Article.<p/>
 *
 * Below are the list of pages involved: <br/>
 *
 * GoogleHomePage <br/>
 * GoogleMapPage <br/>
 * WikipediaHomePage <br/>
 * WikipediaGigaBerlinPage <br/>
 *
 */
public class SearchArticleEndUserSteps extends ScenarioSteps {

    private final static Logger LOGGER = Logger.getLogger(SearchArticleEndUserSteps.class.getName());

    public SearchArticleEndUserSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void openHomePage() { googleHomePage().open(); }

    @Step
    public void clickOnAgreeButton(WebDriver driver) {
        driver.switchTo().frame(0);
        googleHomePage().clickOnAgreeButton();
    }

    @Step
    public void clickOnSubmitButton() { googleHomePage().clickOnSubmitButton(); }

    @Step
    public void enterSearchText(String searchText) { googleHomePage().enterSearch(searchText); }

    @Step
    public void enterWikipediaText(String searchText) { wikipediaMainPage().enterArticle(searchText); }

    @Step
    public void clickOnLink() { googleHomePage().clickOnWikipedialink(); }

    @Step
    public String getCoordinates() { return wikipediaGigaBerlinPage().getCoordinates(); }

    @Step
    public String getLogistics() { return wikipediaGigaBerlinPage().getLogistics(); }

    @Step
    public String getSiteConcerns() { return wikipediaGigaBerlinPage().getSiteConcerns(); }

    @Step
    public void clickOnCoordinates() { googleMapPage().clickOnCoordinates(); }

    @Step
    public void enterCoordinatesText(String searchText) { googleMapPage().enterCoordinates(searchText); }

    @Step
    public void openNewTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open('https://maps.google.de','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Step
    public String getAndVerifyCoordinates() {
        String coordinates = this.getCoordinates();
        Assert.assertEquals(COORDINATES, coordinates);
        LOGGER.info("Coordinates : " + coordinates);
        return coordinates;
    }

    @Step
    public void verifySiteConcerns() {
        String siteConcerns = this.getSiteConcerns();
        Assert.assertEquals("Site concerns", siteConcerns);
        Assert.assertEquals(SITE_CONCERNS, wikipediaGigaBerlinPage().getSiteConcernsData());
        LOGGER.info("Site concerns : " + wikipediaGigaBerlinPage().getSiteConcernsData());
    }

    @Step
    public void verifyLogistics() {
        String logistics = this.getLogistics();
        Assert.assertEquals("Logistics", logistics);
        Assert.assertEquals(LOGISTICS, wikipediaGigaBerlinPage().getLogisticsData());
        LOGGER.info("Logistics : " + wikipediaGigaBerlinPage().getLogisticsData());
    }

    @Step
    public void verifyAddress() {
        Assert.assertEquals(ADDRESS_GRUENHEIDE, googleMapPage().getGruenheideAddressText());
    }

    public GoogleHomePage googleHomePage() { return getPages().currentPageAt(GoogleHomePage.class); }

    public GoogleMapPage googleMapPage() { return getPages().currentPageAt(GoogleMapPage.class); }

    public WikipediaGigaBerlinPage wikipediaGigaBerlinPage() { return getPages().currentPageAt(WikipediaGigaBerlinPage.class); }

    public WikipediaHomePage wikipediaMainPage() { return getPages().currentPageAt(WikipediaHomePage.class); }
}
