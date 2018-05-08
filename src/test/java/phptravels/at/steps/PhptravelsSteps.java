package phptravels.at.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import phptravels.at.pages.HomePage;
public class PhptravelsSteps {

    @Test
    @Given("select $Toronto as the City")
    public void selectTorontoastheCity() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.searchFor("Toronto");

    }
    @Test
    @Given("optional: Change the dates. (You can leave as default)")
    public void optionalChangethedates() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.setPeriodOfTimeEnd();
    }
    @Test
    @Given("choose $3 Adults and $2 Childs")
    public void choose3Adultsand2Childs() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.choose3Adultsan();
        homePage.choose2Childs();
    }
    @When("do the search")
    public void dothesearch() throws Throwable {
        HomePage homePage = new HomePage();
    }
    @Then("get the Number of Results(Optional).. If 0 Results go back using the browser navigation")
    public void gettheNumberofResults() throws Throwable {
        HomePage homePage = new HomePage();
    }
    @When("do the search again same values except the city, leave empty")
    public void doTheSearchAgainSameValuesExceptTheCityLeaveempty() throws Throwable {
        HomePage homePage = new HomePage();
    }
    @When("get the number of Results(Optional)")
    public void GettheNumberofResults() throws Throwable {
        HomePage homePage = new HomePage();
    }
    @When("choose any of the results and click Details")
    public void ChooseAnyofTheResultsandClickDetails() throws Throwable {
        HomePage homePage = new HomePage();
    }
    @When("wait for the page to load")
    public void waitForthePageToLoad() throws Throwable {
        HomePage homePage = new HomePage();
    }
    @Then("get the details text and store in a variable to display on your output console")
    public void getTheDetailstext() throws Throwable {
        HomePage homePage = new HomePage();
    }

    }

