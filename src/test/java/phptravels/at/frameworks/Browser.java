package phptravels.at.frameworks;

import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import jline.internal.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class Browser {
    //=================================================================================================
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<NgWebDriver> ngWebDriver = new ThreadLocal<>();

    public static RemoteWebDriver get() {
        if (driver.get()==null) {
            init();
        }
        return driver.get();
    }


    private static void init() {
        ChromeDriverManager.getInstance().version("2.38").setup();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver");
        //=================================================================
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");//get().manage().window().maximize();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.set(new ChromeDriver(capabilities));

        //=================================================================

    }
    public static void close(){
        get().quit();
        driver.remove();
        ngWebDriver.remove();
    }

//====================================================================================================
    public static WebElement waitElement(By by, int... iSecToWait){
        long timeStart = System.currentTimeMillis();
        int iSecToWaitLoc = iSecToWait.length>0?iSecToWait[0]:0;
//        waitForAngular();
        WebElement we = null;
        try {
            we = (new WebDriverWait(get(), iSecToWaitLoc)).
                    until(ExpectedConditions.visibilityOfElementLocated(by));//if this invoked from waitAndClick we will wait 2 sec by def
        }catch (Exception e){}
        //===
        long timeElapsed = (System.currentTimeMillis() - timeStart)/1000;
        if (timeElapsed > 2 ){
            Log.info("Real waiting of: "+by+" element was more than 2 seconds: " + timeElapsed+" ");
        }
        return we;
    }

}