package ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {

    public synchronized static ExtentReports createExtentReports() {
        ExtentTest test;
        ExtentReports extentReports;
        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html",true);
        test =extentReports.startTest("verify login page is opened");
        return extentReports;
    }
}
