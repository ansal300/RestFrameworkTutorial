package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.util.List;

public class ExtentReportManager {

    public static ExtentReports extentReports;
    public static ExtentReports createInstance() {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Report.html");
        extentSparkReporter.config().setReportName("API Test Report");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }

    public static void logPass(String log)
    {
        SetUp.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFail(String log)
    {
        SetUp.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logInfo(String log)
    {
        SetUp.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void logJson(String json)
    {
        SetUp.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logHeaders(List<Header> headerList)
    {
       String[][]headers= headerList.stream().map(header -> new String[]{header.getName(), header.getValue()})
                        .toArray(String[][]::new );
        SetUp.extentTest.get().info(MarkupHelper.createTable(headers));
    }
}
