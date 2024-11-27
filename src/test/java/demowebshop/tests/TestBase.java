package demowebshop.tests;

import demowebshop.fw.AppManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static AppManager app = new AppManager(System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp(){
        app.init();
    }

    //@AfterMethod(enabled = false)
    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
