package ESite;

import ReusableMethods.ABS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends ABS {
    WebDriver driver;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutButton;
    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement countryDropdown;
    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement placeOrder;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    public void provideShippingDetails(String countryName) {
        countryDropdown.sendKeys(countryName);
        String countryXpath = String.format("//span[contains(text(),'%s')]/..", countryName);
        driver.findElement(By.xpath(countryXpath)).click();
    }

    public void goToCheckOutPage() {
        checkoutButton.click();


    }

    public PageInformation goToPlaceOrderScreen() {
        placeOrder.click();
        return new PageInformation(driver);
    }


}
