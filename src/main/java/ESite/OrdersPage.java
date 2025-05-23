package ESite;

import ReusableMethods.ABS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends ABS {

    WebDriver driver;
    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> placedItemName;


    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyPacedOrders(String item) {
        boolean result;
        result = placedItemName.stream().anyMatch(pItems -> pItems.getText().equalsIgnoreCase(item));
        return result;
    }


}
