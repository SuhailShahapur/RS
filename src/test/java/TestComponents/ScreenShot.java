package TestComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    WebDriver driver;

    @Test
    public void getScreenShot() throws IOException {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File sourceFile = sc.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenShot.png");
        FileUtils.copyFile(sourceFile, destFile);

    }

    public String getScreenshot_nd_MethodName(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File src = sc.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "//Reports//screenshots//" + testcaseName + ".png");
        FileUtils.copyFile(src, dest);
        return System.getProperty("user.dir" )+ "//Reports//screenshots//" + testcaseName + ".png";
    }
}
