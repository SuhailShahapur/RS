package TestComponents;

import ESite.Login;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BrowserIntialization {
    public WebDriver driver;
    public Login lg;

    public void intilization() throws IOException {
        Properties ps = new Properties();

        FileInputStream fs = new FileInputStream("C:\\Users\\suhail.shahapur\\IdeaProjects\\RSSelenium\\src\\main\\java\\Resources\\GlobalData.properties");

        ps.load(fs);
        String BrowserName = System.getProperty("browser")!=null?System.getProperty("browser"):ps.getProperty("browser");
        //String BrowserName = ps.getProperty("browser");

        if (BrowserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            if(BrowserName.contains("headless")){
                options.addArguments("headless");

               // driver.manage().window().maximize();

            }
            driver = new ChromeDriver(options);
        } else if (BrowserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();


        } else if (BrowserName.equalsIgnoreCase("fireFox")) {
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @BeforeMethod(alwaysRun = true)
    public Login launchApplication() throws IOException {
        intilization();
        lg = new Login(driver);
        lg.goTo();

        return lg;
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public List<HashMap<String, String>> readData(String FilePath) throws IOException {
        String jsonFileContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonFileContent, new TypeReference<List<HashMap<String, String>>>() {
        });
    }
    //"C:\\Users\\suhail.shahapur\\IdeaProjects\\RSSelenium\\src\\main\\java\\Resources\\TestData.json"
}
