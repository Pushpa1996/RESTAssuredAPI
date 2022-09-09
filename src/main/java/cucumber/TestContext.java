package cucumber;




import com.aventstack.extentreports.ExtentTest;

import apiEngine.model.common.Endpoints;
import configs.ConfigReader;
import cucumberHooks.ExtentReportsClass;

public class TestContext {

	private Endpoints endPoints = new Endpoints(ConfigReader.getInstance().getBaseUrl());
	
	 private ExtentTest result;
	
	

	public Endpoints getEndPoints() {
        return endPoints;
    }

	
	
	public ExtentTest getreport() {
		result=	ExtentReportsClass.extent;
		return result;
		
		
	}

	

}