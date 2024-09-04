package homePage;

import base.BaseTests;
import base.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(TestListeners.class)
public class HomeTest extends BaseTests {

    HomePage homePage1;

    @Test
    public void TestHomePageIsVisible(){

        homePage1 = homePage;
        Assert.assertEquals(homePage1.homePageVisible() , "Home");
        homePage1.clickOnSignUpAndLoginBtn1();
    }
}
