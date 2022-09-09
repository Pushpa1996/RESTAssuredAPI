package utility;

import apiEngine.model.common.BaseStep;
import cucumber.TestContext;

public class ExtentReport extends BaseStep {

	public ExtentReport(TestContext testContext) {
		super(testContext);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void pass(String value) {
		getreport().pass(value);
	}
	public void fail(String value) {
		getreport().fail(value);
	}
	public void fatal(String value) {
		getreport().fatal(value);
	}
	public void info(String value) {
		getreport().info(value);
	}
	public void error(String value) {
		getreport().error(value);
	}
	

}
