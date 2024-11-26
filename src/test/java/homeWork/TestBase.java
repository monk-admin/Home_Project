package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isHomePageComponentPresent(){
        return driver.findElements(By.xpath("//img[@alt='Tricentis Demo Web Shop']")).size()>0;
    }

//    public boolean ifExistedUser(){
//        return driver.findElements(By.xpath("//li[contains(.,'The specified email already exists')]")).size()>0;
//    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("FirstName"), user.getFirstname());
        type(By.name("LastName"), user.getLastname());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.xpath("//a[.='Log out']"));
    }

    protected boolean isThisEmailAlreadyExists() {
        return isElementPresent(By.xpath("//li[contains(.,'The specified email already exists')]"));
    }

    public void fillInLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[@href='/login']"));
    }

    protected void clickOnLoginButton() {
        click(By.xpath("//input[@value='Log in']"));
    }

    protected boolean isAlertDisplayed() {
        return isElementPresent(By.xpath("//span[contains(.,'Login was unsuccessful. Please correct the errors and try again.')]"));
    }
}
