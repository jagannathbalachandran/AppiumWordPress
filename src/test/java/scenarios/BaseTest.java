package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.AppiumServer;
import util.PropertyReader;

import java.io.IOException;
import java.net.URL;


public class BaseTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    PropertyReader propertyReader = new PropertyReader();
    String device = "Nexus 5";
    AppiumServer server;

//    @BeforeSuite
//    public void setUpServer(){
//        server = new AppiumServer();
//        server.startAppiumServer();
//        System.out.println("Server after start up is " + server);
//    }

    public void setUpAndroidDriver() throws Exception {

        System.out.println("Server before setting up android driver  is " + server);
        System.out.println("Set up Android Driver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", device);
        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
//        capabilities.setCapability("device", "Selendroid");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/build/wordpress.apk");
//        System.out.println("Server here in set up  " + server);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        String explicitWait = propertyReader.readProperty("explicitWait");
        wait = new WebDriverWait(driver, Long.parseLong(explicitWait));
    }


    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File destFile = new File("target/snapshot/" + testResult.getMethod().getMethodName() + ".jpg");
//            FileUtils.copyFile(scrFile, destFile);
//            System.out.println("Capture screenshot here:" + destFile.getAbsolutePath());
//        }
        driver.quit();
        System.out.println("Close Android driver");
    }

//    @AfterSuite
//    public void stopAppiumServer(){
//        server.stopAppiumServer();
//    }


    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
