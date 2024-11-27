package demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper{

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        click(By.xpath("(//input[@value='Add to cart'])[2]"));
    }

    public void clickOnShoppingCartButton() {
        click(By.xpath("//span[@class='cart-label' and contains(.,'Shopping cart')]"));
    }

    public boolean isItemAddedToCart(){
        return isElementPresent(By.xpath("//a[@class='product-name' and contains(.,'14.1-inch Laptop')]"));
    }
}
