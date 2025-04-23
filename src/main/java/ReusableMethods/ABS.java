package ReusableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ABS {
    WebDriver driver;
    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement ordersButton;

    public ABS(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void visibleWaitMethod(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));


    }

    public void elemantVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    public void elementToBeDisappeared(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }

    public void goTOOrdersPage() {
        ordersButton.click();

    }
}
