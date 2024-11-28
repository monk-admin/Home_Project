package demowebshop.tests;

import demowebshop.data.UserData;
import demowebshop.models.User;
import demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
                .setFirstname(UserData.FIRSTNAME)
                .setLastname(UserData.LASTNAME)
                .setEmail("tomHanks" + i + "@gmail.com")
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        app.getUser().clickOnContinueButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }



    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void userRegPosFromDataProviderTest(String firstname, String lastname, String email, String password, String confirmpassword){
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setFirstname(firstname)
                .setLastname(lastname)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmpassword));
        app.getUser().clickOnRegistrationButton();
        app.getUser().clickOnContinueButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }



    @Test(dataProvider = "addNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void userRegPosFromDataProviderWithCsvFileTest(User user){
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterLoginForm(user);
        app.getUser().clickOnRegistrationButton();
        app.getUser().clickOnContinueButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test(dataProvider = "addNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void userRegNegativeFromDataProviderWithCsvFileTest(User user){
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterLoginForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isThisEmailAlreadyExists());
    }

    @Test
    public void userRegNegativeTest(){
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setFirstname(UserData.FIRSTNAME)
                .setLastname(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isThisEmailAlreadyExists());
    }
}
