package pages.employer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriverWait wait;
    String userName = "org.wordpress.android:id/nux_username";
    String password = "org.wordpress.android:id/nux_password";
    String signIn = "org.wordpress.android:id/nux_sign_in_button";
    String newPost = "org.wordpress.android:id/fab_button";

    private AppiumDriver<MobileElement> driver;

    public HomePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public PostPage login() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(userName)));
        driver.findElementById(userName).sendKeys("vodqa@gmail.com");
        driver.findElementById(password).sendKeys("Hello12345678");
        driver.findElementById(signIn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(newPost)));
        return new PostPage(driver ,wait);
    }
}
