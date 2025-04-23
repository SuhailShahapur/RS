package ESite;

import ReusableMethods.ABS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCartPage extends ABS {
    WebDriver driver;
    @FindBy(xpath = "//button[@tabindex='0' and @routerlink=\"/dashboard/cart\"]")
    WebElement addToCartButton;
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void gotoCartPage() {
        addToCartButton.click();
    }

    public List<WebElement> getProducts() {
        return driver.findElements(By.cssSelector(".mb-3"));

    }

    public boolean validateCartItems(String itemTobeValidated) {
        List<WebElement> cartItems = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
        return cartItems.stream().anyMatch(ac -> ac.getText().equalsIgnoreCase(itemTobeValidated));
        //getProducts().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(itemTobeValidated)).findFirst().orElse(null);
    }
}
