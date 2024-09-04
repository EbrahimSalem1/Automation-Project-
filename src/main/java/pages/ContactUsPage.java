package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ContactUsPage extends MethodHandles {


    public ContactUsPage(WebDriver driver){
        super(driver);
    }


    public final By getInTouchText = By.cssSelector("div[class='contact-form'] h2[class='title text-center']");
    public final By contactNameInput = By.cssSelector("input[placeholder='Name']");
    public final By contactEmailInput = By.cssSelector("input[placeholder='Email']");
    public final By contactSubjectInput = By.cssSelector("input[placeholder='Subject']");
    public final By contactMessageInput = By.cssSelector("#message");
    public final By contactUploadFile = By.cssSelector("input[name='upload_file']");
    public final By contactSubmitBtn = By.cssSelector("input[value='Submit']");
    public final By getSuccessMessageText = By.cssSelector(".status.alert.alert-success");
    public final By homeBtn = By.cssSelector(".btn.btn-success");


    @Step
    public String getInTouchTxt(){
        return driver.findElement(getInTouchText).getText();
    }

    @Step
    public ContactUsPage insertContactName(String contactName1){
        driver.findElement(contactNameInput).sendKeys(contactName1);
        return this;
    }

    @Step
    public ContactUsPage insertContactEmail(String contactEmail1){
        driver.findElement(contactEmailInput).sendKeys(contactEmail1);
        return this;
    }

    @Step
    public ContactUsPage insertContactSubject(String contactSubject1){
        driver.findElement(contactSubjectInput).sendKeys(contactSubject1);
        return this;
    }

    @Step
    public ContactUsPage insertContactMessage(String contactMessage1){
        driver.findElement(contactMessageInput).sendKeys(contactMessage1);
        return this;
    }

    @Step
    public ContactUsPage uploadContactFile(String contactUploadFile1){
        driver.findElement(contactUploadFile).sendKeys(contactUploadFile1);
        return this;
    }

    @Step
    public ContactUsPage clickOnContactSubmitBtn(){
        driver.findElement(contactSubmitBtn).click();
        return this;
    }

    @Step
    public ContactUsPage clickOnAcceptJs(){
        driver.switchTo().alert().accept();
        return this;
    }

    @Step
    public String getSuccessMessageVisible(){
        return driver.findElement(getSuccessMessageText).getText();
    }

    @Step
    public HomePage clickOnHomeBtn(){
        driver.findElement(homeBtn).click();
        return new HomePage(driver);
    }
}
