package demowebshop.tests;

import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test(priority = 1)
    public void userLogin(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(new User().setEmail("tomHanks09071956@gmail.com").setPassword("Heelo123!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test(priority = 2)
    public void userLoginNegative(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(new User().setPassword("Heelo123!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }
}
