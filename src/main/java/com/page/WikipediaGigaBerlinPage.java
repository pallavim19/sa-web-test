package com.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * All elements needed for Wikipedia Giga Berlin Page
 */
public class WikipediaGigaBerlinPage extends PageObject {
	
	@FindBy(xpath = "//span[@id='coordinates']//span[@class='plainlinks nourlexpansion']//span[@style='white-space: nowrap;']//a[@class='external text']//span[@class='geo-default']//span[@class='geo-dec'][contains(text(),'52.4°N 13.8°E')]")
	public WebElementFacade coordinates;

	@FindBy(xpath = "//span[@id='Logistics']")
	public WebElementFacade logisticsText;

	@FindBy(xpath = "//span[@id='Site_concerns']")
	public WebElementFacade siteConcernsText;

	@FindBy(xpath ="//span[contains(text(),'Logistics') and @class = 'mw-headline']/../following-sibling::p")
	public WebElementFacade logisticsDataText;

	@FindBy(xpath = "//span[contains(text(),'Site concerns') and @class = 'mw-headline']/../following-sibling::p[1]")
	public WebElementFacade siteConcernsDataText;

	public String getCoordinates(){
		return coordinates.getText();
	}

	public String getLogistics(){ return logisticsText.getText(); }

	public String getLogisticsData(){
		return logisticsDataText.getText();
	}

	public String getSiteConcernsData(){
		return siteConcernsDataText.getText();
	}

	public String getSiteConcerns(){
		return siteConcernsText.getText();
	}
}
