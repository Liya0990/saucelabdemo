package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestDetector implements ITestListener {

    private String path=System.getProperty("user.dir")+"/reports/";
    private ExtentReports reportManager ;
    private ExtentSparkReporter spark;
    private static ExtentTest testCaseSection;


    // each test cycle related
    @Override
    public void onStart(ITestContext testCycle){
        reportManager =new ExtentReports();
        spark=new ExtentSparkReporter(path);
        spark.config().setDocumentTitle("Automated Test Report");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().thumbnailForBase64(true);
        reportManager.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext testCycle){
        reportManager.flush();

    }

    // each test case related
    @Override
    public void onTestStart(ITestResult testCase){
        String testCaseName=testCase.getName();
        testCaseSection=reportManager.createTest(testCaseName);


    }
    /**
     * use this mehtod to get access to test case sectons in the report for the current test case that is being executed
     */
    public static ExtentTest getCurrentTestCaseSection(){
        return testCaseSection;
    }

    @Override
    public void onTestSuccess(ITestResult testCase){
        testCaseSection.pass("Test case passed");
        WebDriver driver = DriverUtil.getDriver();
        String picture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        testCaseSection.addScreenCaptureFromBase64String(picture);
    }

    @Override
    public void onTestFailure(ITestResult testCase){
        testCaseSection.fail("Test failed");
        testCaseSection.fail(testCase.getThrowable());
        WebDriver driver = DriverUtil.getDriver();
        String picture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        testCaseSection.addScreenCaptureFromBase64String(picture);
//        String screenshotPic=DriverUtil.takeScreenshot();
//        testCaseSection.addScreenCaptureFromBase64String(screenshotPic);
    }

    @Override
    public void onTestSkipped(ITestResult testCase){
        testCaseSection.skip("test case has been blocked");
    }



}//end :: class

