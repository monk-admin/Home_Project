package demowebshop.tests;

import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase{

    @Test
    public void addingItemToCart(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillInLoginForm(new User().setEmail("tomHanks09071956@gmail.com").setPassword("Heelo123!"));
        app.getUser().clickOnLoginButton();
        app.getCart().clickOnAddToCartButton();
        app.getCart().clickOnShoppingCartButton();
        Assert.assertTrue(app.getCart().isItemAddedToCart());
    }

}
