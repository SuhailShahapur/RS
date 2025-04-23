package ESite;

import ReusableMethods.ABS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends ABS {
    WebDriver driver;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "userPassword")
    WebElement password;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
    WebElement alert;

    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void loginWithCredentials(String EmailD, String pass) {
        email.sendKeys(EmailD);
        password.sendKeys(pass);
        loginButton.click();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String validateMessage() {
        elemantVisible(alert);
        return alert.getText();
    }

}
