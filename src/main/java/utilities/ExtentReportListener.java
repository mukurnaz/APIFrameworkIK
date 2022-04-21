package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class ExtentReportListener implements ITestListener {
    protected static ExtentReports reports;
    public static ExtentTest test;
    String ReportLocation = "test-result/report/";

    public void onTestStart(ITestResult result){
        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO,result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result){
        test.log(LogStatus.PASS, "Test is Pass.#Muaz");
    }
    public void onTestFailure(ITestResult result){
        test.log(LogStatus.FAIL,"Test is fail.#Muaz");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        // TODO Auto-generated
    }
    public void onStart(ITestContext context){
        reports = new ExtentReports(ReportLocation + "ExtentReport.html");
    }
    public void onFinish(ITestContext context){
        reports.endTest(test);
        reports.flush();
    }
}
