package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public final By signUpAndLoginBtn = By.cssSelector("a[href='/login']");
    public final By homePageLinkText = By.xpath("//a[normalize-space()='Home']");



    @Step
    public String homePageVisible()
    {
        return driver.findElement(homePageLinkText).getText();
    }

    @Step
    public RegisterPage clickOnSignUpAndLoginBtn1(){
        driver.findElement(signUpAndLoginBtn).click();
        return new RegisterPage(driver);
    }

}