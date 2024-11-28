package demowebshop.tests;

import demowebshop.data.UserData;
import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void addingItemToCart(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getCart().clickOnAddToCartButton();
        app.getCart().clickOnShoppingCartButton();
        Assert.assertTrue(app.getCart().isItemAddedToCart());
    }

}
