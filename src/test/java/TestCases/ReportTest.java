package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ReportTest {
    // Declare at class level
    static ExtentReports extent;

    @BeforeSuite
    public void setupReports() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Testing");
        reporter.config().setDocumentTitle("Automation Test Report");

        // Initialize the class-level extent variable
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Suhail");
    }

    @Test
    public void test1() {
        // Create test and get reference
        ExtentTest test = extent.createTest("test1");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println(title);
            test.pass("Navigated to Google successfully. Title: " + title);
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDown() {
        // Flush the report once at the end
        if (extent != null) {
            extent.flush();
        }
    }
}