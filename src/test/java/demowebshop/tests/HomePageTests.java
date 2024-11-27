package demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomePageComponentPresentTest(){
        Assert.assertTrue(app.getHome().isHomePageComponentPresent());
    }
}
