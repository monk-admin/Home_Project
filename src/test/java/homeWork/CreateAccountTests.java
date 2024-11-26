package homeWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void userRegPosTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        clickOnRegisterLink();
        fillRegisterLoginForm(new User()
                .setFirstname("Tom")
                .setLastname("Hanks")
                .setEmail("tomHanks" + i + "@gmail.com")
                .setPassword("Heelo123!")
                .setConfirmPassword("Heelo123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isLogOutButtonPresent());
    }

    @Test
    public void userRegNegativeTest(){
        clickOnRegisterLink();
        fillRegisterLoginForm(new User()
                .setFirstname("Tom")
                .setLastname("Hanks")
                .setEmail("tomHanks09071956@gmail.com")
                .setPassword("Heelo123!")
                .setConfirmPassword("Heelo123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isThisEmailAlreadyExists());
    }
}
