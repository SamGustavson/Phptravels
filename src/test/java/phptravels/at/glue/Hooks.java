package phptravels.at.glue;

import org.junit.After;
import org.junit.Before;
import phptravels.at.frameworks.Browser;


public class Hooks {
    @Before
    public void beforeScenario() {
//        Browser.get().get("http://google.com");
    }

    @After()
    public void afterScenario() {
        Browser.close();
    }

}


