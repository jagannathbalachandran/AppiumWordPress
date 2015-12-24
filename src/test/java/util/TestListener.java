package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import scenarios.BaseTest;

public class TestListener implements ITestListener{

    private WebDriver driver;

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test is  passed");

    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test is failed");
        this.driver= ((BaseTest)result.getInstance()).getDriver();
        System.out.println("befr taking shots: "+result.getTestName());
        System.out.println("befr taking shots: "+result.getName());
        System.out.println("befr taking shots: "+result.getMethod().getMethodName());
        takescreenshot(result.getMethod().getMethodName());
        System.out.println("aftr taking shots");
    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] takescreenshot(String description){
        System.out.println("befr taking shots inside method");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}

