package driverManager.threadlocalmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.util.Arrays;

public class ChromeDriverThreadLocalManager extends DriverThreadLocalManager {
    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.addArguments("--window-size=1400,600");
        options.setExperimentalOption("excludeSwitches",

                Arrays.asList("disable-popup-blocking"));
        threadLocalDriver.set(new ChromeDriver(options));
    }
}
