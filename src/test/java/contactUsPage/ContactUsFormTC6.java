package contactUsPage;

import base.BaseTests;
import base.TestListeners;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static utils.DataDriven.JsonClass.readJson;

@Listeners(TestListeners.class)
public class ContactUsFormTC6 extends BaseTests {

    String uploadFile = System.getProperty("user.dir") + "\\src\\test\\java\\fileUpload\\ice cream.jpeg";
    String contactFile = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ContactUsInfo.json";

    HomePage hm;
    ContactUsPage contact;


    @Test
    public void testContactUsFormTc6(){

        hm = homePage;
        Assert.assertEquals(hm.homePageVisible() , "Home");
        hm.clickOnContactUsBtn();


        contact = contactUsPage;
        Assert.assertEquals(contact.getInTouchTxt() , "GET IN TOUCH");


        contact.insertContactName(readJson(contactFile , "ContactName1"));
        contact.insertContactEmail(readJson(contactFile , "ContactEmail1"));
        contact.insertContactSubject(readJson(contactFile , "ContactSubject1"));
        contact.insertContactMessage(readJson(contactFile , "ContactMessage1"));


        contact.uploadContactFile(uploadFile);
        contact.clickOnContactSubmitBtn();
        contact.clickOnAcceptJs();


        Assert.assertEquals(contact.getSuccessMessageVisible() , "Success! Your details have been submitted successfully.");
        contact.clickOnHomeBtn();


        Assert.assertEquals(hm.homePageVisible() , "Home");
    }

}