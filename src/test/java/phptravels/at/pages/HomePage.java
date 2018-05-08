package phptravels.at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import phptravels.at.frameworks.BasePage;
import phptravels.at.frameworks.Browser;

import java.util.List;

public class HomePage extends BasePage {
    private static final By     SEARCH_FIELD_LOCATOR   = By.xpath("//*[@id='select2-drop']/div/input");
    private static final By     CALENDAR_FIELD_LOCATOR   = By.xpath("//*[@id='dpd1']/input");
    private static final By     CALENDAR_FIELD_LOCATOR2   = By.xpath("//*[@id=/dpd2/]/input");

    public void searchFor (String searchPattern) throws InterruptedException {
        Thread.sleep(4000);
//        Browser.ImplicitWait();
//        Browser.waitElement(SEARCH_FIELD_LOCATOR,7);
        WebElement searchField = Browser.get().findElement(SEARCH_FIELD_LOCATOR);
        searchField.click();
        Thread.sleep(2000);
        searchField.sendKeys(searchPattern);
        searchField.sendKeys(Keys.ENTER);
    }

    public void setPeriodOfTimeEnd() {
        WebElement calendarOneElement1 = Browser.get().findElement(CALENDAR_FIELD_LOCATOR);
        calendarOneElement1.click();
        utils("May", 18);
//       Browser.waitElement(IntransoLocators.CALENDAR_ELEMENT_1.getLocator()).submit();
        WebElement calendarOneElement2 = Browser.get().findElement(CALENDAR_FIELD_LOCATOR2);
        calendarOneElement2.click();

        utils("May", 19);

    }


    private void utils(String month, int day){
        List<WebElement> allMoun= Browser.get().findElements(By.xpath("//div[@class='ui-datepicker-title']//option"));

        for(WebElement ele:allMoun)
        {
            String date=ele.getText();
            if(date.equalsIgnoreCase(month))
            {
                ele.click();
                break;
            }

        }

        List<WebElement> allDates= Browser.get().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for(WebElement ele:allDates)
        {
            String date=ele.getText();
            if(date.equalsIgnoreCase(String.valueOf(day)))
            {
                ele.click();
                break;
            }

        }

    }
}
