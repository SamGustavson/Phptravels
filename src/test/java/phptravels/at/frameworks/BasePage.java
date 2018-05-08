package phptravels.at.frameworks;


import net.serenitybdd.jbehave.SerenityStory;

public class BasePage  extends SerenityStory {
    public void navigateToHomePage() {
        Browser.get().get(" http://www.phptravels.net");

    }

}
