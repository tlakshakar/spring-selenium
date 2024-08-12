package com.udemy.spring.spring_selenium.page.redbus;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageFragment;
import com.udemy.spring.spring_selenium.page.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

//@Component // @Component by default, it will be a singleton scope. So the only one instance will be created and all the threads will be using the same instance. If you need a different scope, you can use the @Scope annotation to specify it.
@PageFragment
public class SearchBus extends Base {
    @FindBy(css = "#src.sc-bxivhb")
    public WebElement from;
    @FindBy(css = "#dest.sc-bxivhb")
    public WebElement to;
    @FindBy(className = "labelCalendarContainer")
    public WebElement date_picker;
    @FindBy(xpath = ".//div[starts-with(@class,'DatePicker__MainBlock')]" +
            "//div[starts-with(@class,'DayTilesWrapper__RowWrap')]" +
            "//span//div[starts-with(@class,'DayTiles__CalendarDaysBlock')]" +
            "/span[starts-with(@class,'DayTiles__CalendarDaysSpan')]")
    public List<WebElement> days;
    @FindBy(xpath = ".//div[starts-with(@class,'DatePicker__MainBlock')]" +
            "//div[starts-with(@class,'DayNavigator__CalendarHeader')]" +
            "//div[starts-with(@class,'DayNavigator__IconBlock')][contains(@style,'flex-grow')][position()=1]")
    public WebElement leftDatePickerArrow;
    @FindBy(xpath = ".//div[starts-with(@class,'DatePicker__MainBlock')]" +
            "//div[starts-with(@class,'DayNavigator__CalendarHeader')]" +
            "//div[starts-with(@class,'DayNavigator__IconBlock')][contains(@style,'flex-grow')][position()=3]")
    public WebElement rightDatePickerArrow;
    @FindBy(xpath = ".//div[starts-with(@class,'DatePicker__MainBlock')]" +
            "//div[starts-with(@class,'DayNavigator__CalendarHeader')]" +
            "//div[starts-with(@class,'DayNavigator__IconBlock')][contains(@style,'font-size')]")
    public WebElement monthHeader;
    @FindBy(xpath = ".//*[@class='placeHolderMainText']")
    public List<WebElement> listOfCities;
    @FindBy(id = "search_button")
    public WebElement searchButton;

    @Override
    public boolean isAt() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return this.webDriverWait.until((driver) -> js.executeScript("return document.readyState").equals("complete"));
    }
    public void searchBusForToday(String from, String to) {
        this.from.clear();
        this.from.sendKeys(from);
        this.from.sendKeys(Keys.TAB);
        this.to.clear();
        this.to.sendKeys(to);
        pauseExecution(500);
        this.to.sendKeys(Keys.TAB);
        this.date_picker.click();
        this.selectCurrentDay();
    }
    public void searchBusForParticularDay(String from, String to, String dd_MMM_yyyy) {
        this.from.clear();
        this.from.sendKeys(from);
        this.webDriverWait.until(ExpectedConditions.visibilityOfAllElements(this.listOfCities));
        this.from.sendKeys(Keys.TAB);
        this.to.clear();
        this.to.sendKeys(to);
        pauseExecution(500);
        this.to.sendKeys(Keys.TAB);
        this.date_picker.click();
        this.selectParticularDate(dd_MMM_yyyy);
    }
    public void clickSearchBusesButton() {
        this.searchButton.click();
    }
    private void selectCurrentDay() {
        /**
         * 1. `this.days` represents a collection (probably a list) of web elements.
         * 2. `.stream()` converts the collection into a stream, allowing us to perform operations on its elements.
         * 3. `.filter(webElement -> ...)` applies a filter to the stream. It keeps only the elements that satisfy the specified condition inside the lambda expression.
         *
         * Now, let's dive into the filter condition within the lambda expression:
         * - `webElement.isEnabled()`: Checks if the web element is enabled.
         * - `webElement.isDisplayed()`: Checks if the web element is displayed.
         * - `webElement.getCssValue("background").contains("rgb(239, 67, 72)")`: Checks if the CSS value of the background property contains the specified RGB color (red: 239, green: 67, blue: 72).
         *
         * In summary, this code snippet filters the `this.days` collection to include only web elements that are enabled, displayed, and have a background color matching "rgb(239, 67, 72)".
         * After filtering, `.findFirst()` retrieves the first matching element from the stream (if any), and `
         * .ifPresent(WebElement::click)` invokes the `click` method on that element.
         * So, this code essentially clicks the first eligible web element based on the specified conditions.
         */
        this.days
                .stream()
                .filter(webElement -> webElement.isEnabled()
                        && webElement.isDisplayed()
                        && webElement.getCssValue("background").contains("rgb(239, 67, 72)")
                )
                .findFirst()
                .ifPresent(WebElement::click);
    }
    private void selectParticularDate(String dd_MMM_yyyy) {
        boolean found = false;
        String getMonthFromDateToInput = dd_MMM_yyyy.split(" ")[1];
        while(!found) {
            if (this.monthHeader.getText().split(" ")[0].equalsIgnoreCase(getMonthFromDateToInput)) {
                String day = String.format(".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                        "//div[starts-with(@class,'DayTilesWrapper__RowWrap')]" +
                        "//span//div[starts-with(@class,'DayTiles__CalendarDaysBlock')]" +
                        "/span[starts-with(@class,'DayTiles__CalendarDaysSpan')][contains(text(),%s)]", dd_MMM_yyyy.split(" ")[0]);
                driver.findElement(By.xpath(day)).click();
                found = true;
            } else {
                this.rightDatePickerArrow.click();
            }
        }
    }
}
