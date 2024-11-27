package demowebshop.tests;

import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void userRegPosTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setFirstname("Tom")
                .setLastname("Hanks")
                .setEmail("tomHanks" + i + "@gmail.com")
                .setPassword("Heelo123!")
                .setConfirmPassword("Heelo123!"));
        app.getUser().clickOnRegistrationButton();
        app.getUser().clickOnContinueButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test
    public void userRegNegativeTest(){
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setFirstname("Tom")
                .setLastname("Hanks")
                .setEmail("tomHanks09071956@gmail.com")
                .setPassword("Heelo123!")
                .setConfirmPassword("Heelo123!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isThisEmailAlreadyExists());
    }
}
