package TestCases;

import ESite.AddToCartPage;
import ESite.Login;
import ESite.Site;
import TestComponents.BrowserIntialization;
import TestComponents.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class errorValidation extends BrowserIntialization {
    @Test(groups = {"errorVd"})
    public void validate() {
        lg.loginWithCredentials("EmailId@gmail.com", "userPassword");
        Login ob = new Login(driver);
        Assert.assertEquals("Incorrect email or password.", ob.validateMessage());
    }

    @Test(groups = {"errorVd"}, retryAnalyzer= Retry.class )
    public void cartProductValidate() {
        String Item = "ZARA COAT 3";
        String EmailId = "naruto99@gmail.com";
        String userPassword = "Sasuke@7788";

        String r_Product = "ZARA COAT 3";
        String country = "India";


        lg.loginWithCredentials(EmailId, userPassword);


        Site siteItems = new Site(driver);
        List<WebElement> it = siteItems.listOfItems();
        siteItems.getProductsByName(r_Product);
        siteItems.addToCart(r_Product);


        AddToCartPage add = new AddToCartPage(driver);
        add.gotoCartPage();
        Assert.assertTrue(add.validateCartItems(r_Product));
    }


}
