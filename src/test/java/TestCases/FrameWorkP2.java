import ESite.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FrameWorkP2 {
    public static void main(String[] args) throws InterruptedException {
        String Item ="ZARA COAT 3";
        String EmailId= "naruto99@gmail.com";
        String userPassword = "Sasuke@7788";
        String siteURL ="https://rahulshettyacademy.com/client";
        String r_Product ="ZARA COAT 3";
        String country="India";


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Login lg = new Login(driver);
        lg.goTo(siteURL);
        lg.loginWithCredentials(EmailId,userPassword);


        Site siteItems = new Site(driver);
        List<WebElement> it =siteItems.listOfItems();
        siteItems.getProductsByName(r_Product);
        siteItems.addToCart(r_Product);


        AddToCartPage add= new AddToCartPage(driver);
        add.gotoCartPage();
        Assert.assertTrue(add.validateCartItems(r_Product));
        //site page code

        CheckOutPage cop = new CheckOutPage(driver);
        cop.goToCheckOutPage();
        cop.provideShippingDetails(country);

        PageInformation pInfo =cop.goToPlaceOrderScreen();
        pInfo.getOrderIDs();



       /* PageInformation PI = new PageInformation(driver);
        PI.goToPlaceOrderScreen();
        PI.getOrderIDs();
*/
        driver.quit();



    }
}
