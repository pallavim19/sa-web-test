# Search Article Automation Project

The project is build in [Serenity](https://github.com/serenity-bdd/serenity-core), [Selinium](https://www.selenium.dev/) and [Maven](https://maven.apache.org/)

The project covers testing scenarios to search Article from Google and Wikipedia Pages.

### *Test class - SearchArticleGigaBerlinTest.java* 
### Below are the list of Test cases:
##### navigateGoogleSearchPageAndSearchWikipedia()
##### openWikipediaAndSearchArticleVerifyDetailsAndOpenGoogleMapThenVerifyAddress()

The tests are executed in parallel with 1 threads as default.

To run the tests in a specific browser, e.g. chrome:

```
mvn verify -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=/opt/dev/chromedriver
```

To use default webdriver:

```
mvn verify
```

Test Report Details

maven command

```
mvn serenity:aggregate
```

report location with screen shot of each steps are documented below :

```
<code>/target/site/serenity/index.html
```
CSV file is also generated with test inforamtion at below location :
```
<code>/target/site/serenity/result.csv
```
