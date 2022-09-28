package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;


public class DropDownListTestCase {
    private static final String LIST_XPATH = "//div//form[contains(@class, 'form-create-case')]//div//label[text()='%s']//parent::div//div/button";

    private static final String LIST_XPATH_MILESTONE = "//label[text()='Milestone']//../div[1]";
    private static final String OPTION_XPATH = "//div[contains(@id, 'modals')]//div//div/div/div[contains(., '%s')]";

    private static final String OPTION_XPATH_SUITE = "//div[contains(@class, 'row')]//input[contains(@id, 'suite')]//parent::div//div//div//div//div[contains(., '%s')]";

    private static final String OPTION_XPATH_MILESTONE = "//div[@id='layout']/div[6]//div/div//div[contains(., '%s')]";

    private String labelText;
    private WebDriver driver;

    public DropDownListTestCase(WebDriver driver, String labelText) {
        this.driver = driver;
        this.labelText =labelText;
    }


    public void selectOptionInList (String option) {
        String listFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpath = String.format(OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectOptionInListForSuite (String option) {
        String listFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpathSuite = String.format(OPTION_XPATH_SUITE, option);
        driver.findElement(By.xpath(optionFinalXpathSuite)).click();
    }

    public void selectOptionInListForMilestone (String option) throws InterruptedException {
        String listFinalXpath = String.format(LIST_XPATH_MILESTONE, labelText);
        WebElement element = driver.findElement(By.xpath(listFinalXpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        String optionFinalXpathMilestone = String.format(OPTION_XPATH_MILESTONE, option);
        WebElement element1 = driver.findElement(By.xpath(optionFinalXpathMilestone));

        actions.moveToElement(element1).click().perform();
    }
}
