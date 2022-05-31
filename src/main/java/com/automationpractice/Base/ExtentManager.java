package com.automationpractice.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        String reportName = "TestReport";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportName + ".html");
        htmlReporter.config().setDocumentTitle(reportName);
        htmlReporter.config().setReportName(reportName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("OS Arch Model", System.getProperty("os.arch"));
        extent.setSystemInfo("JAVA version", System.getProperty("java.runtime.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));

        return extent;
    }
}