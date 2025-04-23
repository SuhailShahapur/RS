package ESite;

import ReusableMethods.ABS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Site extends ABS {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
    List<WebElement> items;
    @FindBy(css = ".ng-animating")
    WebElement loader;
    By addButton = By.cssSelector(".card-body button:last-child");
    By productList = By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");
    By toastMessage = By.id("toast-container");

    public Site(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> listOfItems() {
        visibleWaitMethod(productList);
        return items;
    }

    public WebElement getProductsByName(String productName) {
        return listOfItems().stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    }

    public void addToCart(String productName) {
        getProductsByName(productName).findElement(addButton).click();
        visibleWaitMethod(toastMessage);
        elementToBeDisappeared(loader);

    }


}
