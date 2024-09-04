package registrationPage;

import base.BaseTests;
import base.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static utils.DataDriven.JsonClass.readJson;

@Listeners(TestListeners.class)
public class RegistartionTC5 extends BaseTests {


    String regFile = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\RegisterData.json";

    RegisterPage register;

    @Test
    public void RegisterUserWithExistingEmailTC5(){

        register = homePage.clickOnSignUpAndLoginBtn1();
        Assert.assertEquals(register.userSignUpTextVisible() , "New User Signup!");
        register.insertRegisterName(readJson(regFile , "Name"));
        register.insertRegisterEmail(readJson(regFile , "Email"));
        register.clickOnRegisterBtn();

        Assert.assertEquals(register.emailAlreadyExistErrorTxt() , "Email Address already exist!");

    }

}