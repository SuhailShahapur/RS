package ESite;

import ReusableMethods.ABS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageInformation extends ABS {
    WebDriver driver;
    @FindBy(xpath = "//label[@class='ng-star-inserted']")
    List<WebElement> orderId;
   /* @FindBy (xpath = "//a[text()='Place Order ']")
    WebElement placeOrder;*/

    public PageInformation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    /* public void goToPlaceOrderScreen(){
         placeOrder.click();
     }
 */
    public void getOrderIDs() {
        orderId.forEach(s -> System.out.println(s.getText().trim()));
    }


}
