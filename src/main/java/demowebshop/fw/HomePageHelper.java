package demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageComponentPresent(){
        return isElementPresent(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));
    }
}
