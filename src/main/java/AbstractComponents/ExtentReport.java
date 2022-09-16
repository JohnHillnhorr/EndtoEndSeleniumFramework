package AbstractComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	
	public ExtentReports GetReport() {
		String path = System.getProperty("user.dir") + "//report//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("QA Automation Report");
		report.config().setDocumentTitle("Test Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "John");
		
		return extent;
	}
}
