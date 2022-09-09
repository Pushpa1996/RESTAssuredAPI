package cucumberHooks;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.CreateFolder;
import utility.SendFileEmail;

public class ExtentReportsClass {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest extent;
	public static  String Path;
	public String ScenarioName;
	@Before(order = 0)
    public void printScenarioName(Scenario scenario) {
        System.out.println("Run into Before Hook: printScenarioName");
        System.out.println("Print Scenario name in Before Hook: " + scenario.getName());
        ScenarioName=scenario.getName();
       
    }
	
	
	@Before(order = 1)
	
	public void  startTesting() throws UnknownHostException {
		
	    Path=	CreateFolder.folderCreation();
		report = new ExtentReports();
		System.out.println("Extend Teport");
		htmlReporter = new ExtentHtmlReporter(Path+"\\"+ScenarioName+".html");
		String os = System.getProperty("os.name").toLowerCase();
		String username = System.getProperty("user.name");
		report.attachReporter(htmlReporter);
		InetAddress address = InetAddress.getLocalHost();
		report.setSystemInfo("OS", os);
		report.setSystemInfo("Project", "API");
		report.setSystemInfo("Resource", username);
		report.setSystemInfo("Environment", "TESTING");
		report.setSystemInfo("Host Name", address.getHostName());

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("RUMMY  CULTURE");
		htmlReporter.config().setReportName("API TESTING");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = report.createTest(ScenarioName);
		
		
	}
	
	@After
	
	public void endTest() {
		report.flush();
		System.out.println("Extend flush");
		
		
	}
	

	
	}
	
