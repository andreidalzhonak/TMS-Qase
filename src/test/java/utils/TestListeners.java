package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseWebWithThreadLocalTest;
import tests.CommonBaseTest;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started");

    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseWebWithThreadLocalTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        ((BaseWebWithThreadLocalTest) currentClass).getBrowser();
        allureService.getSystemName();
        allureService.takeScreenshot(driver);
        System.out.println("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseWebWithThreadLocalTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.getSystemName();
        allureService.takeScreenshot(driver);
        ((BaseWebWithThreadLocalTest) currentClass).getBrowser();

    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
