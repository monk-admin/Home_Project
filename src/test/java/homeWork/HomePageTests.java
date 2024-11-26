package homeWork;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomePageComponentPresentTest(){
        Assert.assertTrue(isHomePageComponentPresent());
    }
}
