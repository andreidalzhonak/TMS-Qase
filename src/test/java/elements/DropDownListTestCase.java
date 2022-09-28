package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DropDownListTestCase {
    private static final String LIST_XPATH = "//div//form[contains(@class, 'form-create-case')]//div//label[text()='%s']//parent::div//div/button";

    private static final String LIST_XPATH_MILESTONE = "//div[contains(@class, 'row')]//label[text()='Milestone']//following-sibling::div/div";
    private static final String OPTION_XPATH = "//div[contains(@id, 'modals')]//div//div/div/div[contains(., '%s')]";

    private static final String OPTION_XPATH_SUITE = "//div[contains(@class, 'row')]//input[contains(@id, 'suite')]//parent::div//div//div//div//div[contains(., '%s')]";

    private static final String OPTION_XPATH_MILESTONE = "//div[@id=\"layout\"]/div[6]//div/div//div[contains(., '%s')]";


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
        String optionFinalXpath = String.format(OPTION_XPATH_SUITE, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectOptionInListForMilestone (String option) {
        String listFinalXpath = String.format(LIST_XPATH_MILESTONE, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpath = String.format(OPTION_XPATH_MILESTONE, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }
}
