package TestCases;

import ESite.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FrameWorkP1 {
    public static void main(String[] args) throws InterruptedException {
        String Item = "ADIDAS ORIGINAL";
        WebDriver driver = new ChromeDriver();
        Login a = new Login(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("naruto99@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Sasuke@7788");
        driver.findElement(By.id("login")).click();
        // driver.switchTo().alert().accept();
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
        WebElement requiredItem = items.stream().filter(item -> item.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
        //assert requiredItem != null;
        requiredItem.findElement(By.cssSelector(".card-body button:last-child")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.xpath("//button[@tabindex='0' and @routerlink=\"/dashboard/cart\"]")).click();

        List<WebElement> cartItems = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
        boolean result = cartItems.stream().anyMatch(ac -> ac.getText().equalsIgnoreCase(Item));
        Assert.assertTrue(result);
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        WebElement dropDown = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));


        dropDown.sendKeys("ind");
        driver.findElement(By.xpath("//span[text()=' India']/..")).click();
        driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
        List<WebElement> orderId = driver.findElements(By.xpath("//label[@class='ng-star-inserted']"));
        orderId.forEach(s -> System.out.println(s.getText().trim()));
        driver.quit();


    }
}
