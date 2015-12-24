package scenarios.employer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.employer.HomePage;
import scenarios.BaseTest;
import util.TestListener;

@Listeners(TestListener.class)


public class WordPressTest  extends BaseTest {

	HomePage homePage;


	@BeforeMethod
	public void setUpPages() throws Exception {
		System.out.println("********************** Set up android driver ****************************** ");
		setUpAndroidDriver();
		System.out.println("********************** Set up Pages ****************************** ");
		homePage = new HomePage(driver , wait);

	}

	@Test
	public void logInToWordPress() throws InterruptedException {
		homePage.login();
	}

	@Test
	public void makeANewPost() throws InterruptedException {
		homePage.login().post();
	}


}
