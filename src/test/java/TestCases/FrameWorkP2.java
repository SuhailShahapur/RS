package TestCases;

import ESite.*;
import TestComponents.BrowserIntialization;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class FrameWorkP2 extends BrowserIntialization {
    //String Item ="ZARA COAT 3";
    // String EmailId= "naruto99@gmail.com";
    // String userPassword = "Sasuke@7788";
    //String siteURL ="https://rahulshettyacademy.com/client";
    //String r_Product ="ZARA COAT 3";
    String country = "India";

    @Test(dataProvider = "getData")
    public void appTest(HashMap<String, String> input) throws IOException {


        //Login lg =launchApplication(siteURL);




       /* WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/

        //Login lg = new Login(driver);
        //lg.goTo(siteURL);
        lg.loginWithCredentials(input.get("EmailId"), input.get("userPassword"));


        Site siteItems = new Site(driver);
        List<WebElement> it = siteItems.listOfItems();
        siteItems.getProductsByName(input.get("r_Product"));
        siteItems.addToCart(input.get("r_Product"));


        AddToCartPage add = new AddToCartPage(driver);
        add.gotoCartPage();
        Assert.assertTrue(add.validateCartItems(input.get("r_Product")));
        //site page code

        CheckOutPage cop = new CheckOutPage(driver);
        cop.goToCheckOutPage();
        cop.provideShippingDetails(country);

        PageInformation pInfo = cop.goToPlaceOrderScreen();
        pInfo.getOrderIDs();



       /* PageInformation PI = new PageInformation(driver);
        PI.goToPlaceOrderScreen();
        PI.getOrderIDs();
*/


    }

    @Test(dependsOnMethods = {"appTest"}, dataProvider = "getData")
    public void VerifyOrderPage(HashMap<String, String> input) {
        lg.loginWithCredentials(input.get("EmailId"), input.get("userPassword"));
        OrdersPage op = new OrdersPage(driver);
        op.goTOOrdersPage();
        Assert.assertTrue(op.verifyPacedOrders(input.get("r_Product")));


    }

    @DataProvider
    public Object[][] getData() throws IOException {
       /* HashMap<String,String> map = new HashMap<String,String>();
        map.put("EmailId","anshika@gmail.com");
        map.put("userPassword","Iamking@000");
        map.put("r_Product","ZARA COAT 3");

        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("EmailId","shetty@gmail.com");
        map1.put("userPassword","Iamking@000");
        map1.put("r_Product","ADIDAS ORIGINAL");*/

        List<HashMap<String, String>> data = readData("C:\\Users\\suhail.shahapur\\IdeaProjects\\RSSelenium\\src\\main\\java\\Resources\\TestData.json");

        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}
