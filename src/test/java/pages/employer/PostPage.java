package pages.employer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jbalacha on 22/12/15.
 */
public class PostPage {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    String newPost = "org.wordpress.android:id/fab_button12";

    public PostPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void post() {
       driver.findElementById(newPost).click();
    }
}
