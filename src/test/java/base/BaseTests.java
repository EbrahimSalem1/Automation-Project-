package base;

//import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegisterPage;
//import reader.ReadDataFromJson;
//import utils.ScreenRecorderUtil;
//import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class BaseTests {

    WebDriver driver;
    protected HomePage homePage;
    protected RegisterPage registerPage;

    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional ("chrome") String browser) {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Parameters("browser")
    public void setUpBrowser(@Optional ("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headLessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }



}


















//UtilsTests utilsTests;
//protected ReadDataFromJson readDataFromJson;


//    @BeforeMethod
//    public void goHome(Method method) throws Exception {
//        readDataFromJson = new ReadDataFromJson();
//        utilsTests = new UtilsTests(driver);
//        driver.get(dataModel().URL);
//        ScreenRecorderUtil.startRecord(method.getName());
//        utilsTests.createTestCaseInReport(method);
//    }




    //    @AfterMethod
//    public void afterMethod(Method method, ITestResult result) throws Exception {
//        utilsTests = new UtilsTests(driver);
//        utilsTests.takeScreenShot(method);
//        ScreenRecorderUtil.stopRecord();
//        utilsTests.setStatus(method,result);
//    }

//    @BeforeSuite
//    public void beforeSuite(){
//        utilsTests = new UtilsTests(driver);
//        utilsTests.createReport();
//    }
//
//    @AfterSuite
//    public void afterSuite(){
//        utilsTests = new UtilsTests(driver);
//        utilsTests.flushReport();
//    }
//
//    public DataModel dataModel() throws FileNotFoundException {
//        readDataFromJson = new ReadDataFromJson();
//        return readDataFromJson.readJsonFile();
//    }


