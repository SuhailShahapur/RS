package Resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

    public static ExtentReports getReportObject() {

        String path = (System.getProperty("user.dir")) + "\\reports\\Newindex.html";
        ExtentSparkReporter reportConfig = new ExtentSparkReporter(path);
        reportConfig.config().setReportName("FrameWork Test Report");
        reportConfig.config().setDocumentTitle("Automation Report");


        ExtentReports report = new ExtentReports();
        report.attachReporter(reportConfig);
        report.setSystemInfo("Tester", "Suhail");
        return report;

    }
}
