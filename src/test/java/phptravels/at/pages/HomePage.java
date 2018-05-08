package phptravels.at.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import phptravels.at.frameworks.BasePage;
import phptravels.at.frameworks.Browser;

import java.util.List;

public class HomePage extends BasePage {
    private static final By SEARCH_FIELD_LOCATOR = By.xpath("//*[@id='s2id_autogen10']/a/span[1]");
    private static final By RESULT_FIELD_LOCATOR = By.xpath("//*[@id='select2-drop']/ul/li/ul/li/div");

    private static final By CALENDAR_FIELD_LOCATOR = By.xpath("//*[@id='dpd1']/input");
    private static final By CALENDAR_FIELD_LOCATOR2 = By.xpath("//*[@id='dpd2']/input");
    private static final By URLs = By.xpath("//*[@id='body-section']/div[5]/div[3]/div/table/tbody/tr");
    private static final By ADULTS_LOCATOR = By.xpath("//*[@id='adults']");
    private static final By CHILD_LOCATOR = By.xpath("//*[@id='child']");

    Actions actions = new Actions(Browser.get());

    public void searchFor(String searchPattern) throws InterruptedException {
//        Thread.sleep(4000);
        Browser.waitElement(SEARCH_FIELD_LOCATOR, 7);
        WebElement searchField = Browser.get().findElement(SEARCH_FIELD_LOCATOR);
        WebElement resultField = Browser.get().findElement(RESULT_FIELD_LOCATOR);

        actions.moveToElement(searchField).click().sendKeys(searchPattern).build().perform();
        Browser.waitElement(RESULT_FIELD_LOCATOR, 3);
        actions.moveToElement(resultField).sendKeys(Keys.ENTER).build().perform();

    }

    public void setPeriodOfTimeEnd() throws InterruptedException {
        WebElement calendarOneElement1 = Browser.get().findElement(CALENDAR_FIELD_LOCATOR);
        calendarOneElement1.click();
        Thread.sleep(1000);
        calendarOneElement1.clear();
        calendarOneElement1.sendKeys("18/05/2018");
        calendarOneElement1.click();
        Thread.sleep(1000);
        WebElement calendarOneElement2 = Browser.get().findElement(CALENDAR_FIELD_LOCATOR2);
        calendarOneElement2.click();
        calendarOneElement2.clear();
        calendarOneElement2.sendKeys("18/05/2018");
        calendarOneElement2.click();


    }

    public boolean isTitlePresent() {
        boolean titleVer = Browser.get().getTitle().contains(System.getProperty("test.wordfinder"));
        return titleVer;
    }

    public boolean CatchLinks(String URLtoSearch) {

        List<WebElement> ElementCollection = Browser.get().findElements(URLs);

        for (int y = 0; y < ElementCollection.size(); y++) {
            WebElement URL = ElementCollection.get(y);
            String URLText = URL.getText();


            //  System.out.println(URLText);

            if (URLText.equals(URLtoSearch)) {
                System.out.println("This is our link: " + URLText);
                return true;
            }
        }
        return false;
    }


    public void CatchPages(String URLtoSearch, int PageNum) {
//    driver.findElement(By.xpath("//a[@class ='pn'][@id='pnnext']")).click();


        for (int x = 0; x < PageNum; x++) {


            boolean result = CatchLinks(URLtoSearch);

            if (!result && x == PageNum - 1) {
                Assert.fail("Our link is absent");
            }
            if (result) {
                break;
            }
            Browser.get().findElement(By.xpath("//*[@id='body-section']/div[5]/div[3]/div/table/tbody/tr")).click();


        }
    }


    public void choose3Adultsan() {
        WebElement choseAdults = Browser.get().findElement(ADULTS_LOCATOR);
        actions.moveToElement(choseAdults).click().build().perform();
        List<WebElement> allNum = Browser.get().findElements(By.xpath("//*[@id='adults']/option"));

        for (WebElement ele : allNum) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("3")) {
//                ele.click();
                actions.moveToElement(ele).click().build().perform();
                break;
            }

//            choseAdults.sendKeys(Keys.ARROW_DOWN);
//            choseAdults.sendKeys(Keys.ARROW_DOWN);
        }
    }

        public void choose2Childs() {
            Browser.waitElement(CHILD_LOCATOR, 4);
            WebElement choseKids = Browser.get().findElement(CHILD_LOCATOR);
            choseKids.click();
            choseKids.sendKeys(Keys.ARROW_DOWN);
            choseKids.sendKeys(Keys.ARROW_DOWN);
            choseKids.sendKeys(Keys.ARROW_DOWN);
            choseKids.sendKeys(Keys.ENTER);
        }

    }
