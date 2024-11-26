package homeWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTests extends TestBase{

    @Test
    public void UserLogin(){
        clickOnLoginLink();
        fillInLoginForm(new User().setEmail("tomHanks09071956@gmail.com").setPassword("Heelo123!"));
        clickOnLoginButton();
        Assert.assertTrue(isLogOutButtonPresent());
    }

    @Test
    public void UserLoginNegative(){
        clickOnLoginLink();
        fillInLoginForm(new User().setPassword("Heelo123!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }
}
