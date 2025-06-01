package config;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // tu znajduje się scieżka do zbudowanych raportow extentreports
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
            // nazwa raportu i tytuł raportu
            sparkReporter.config().setReportName("Raport z testów automatycznych - projekt PUBLIGO");
            //title raportu
            sparkReporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}