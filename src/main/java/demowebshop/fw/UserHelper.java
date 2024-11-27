package demowebshop.fw;

import demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

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

    public boolean isThisEmailAlreadyExists() {
        return isElementPresent(By.xpath("//li[contains(.,'The specified email already exists')]"));
    }

    public void fillInLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[@href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@value='Log in']"));
    }

    public boolean isLoginLinkPresent(){
        return isElementPresent(By.xpath("//a[contains(.,'Log in')]"));
    };

    public void clickOnLogOutButton() {
        click(By.xpath("//a[contains(.,'Log out')]"));
    }

    public void clickOnContinueButton() {
        click(By.xpath("//input[@class='button-1 register-continue-button']"));
    }
}
