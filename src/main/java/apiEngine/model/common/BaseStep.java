package apiEngine.model.common;
import com.aventstack.extentreports.ExtentTest;


import cucumber.TestContext;
import cucumberHooks.ExtentReportsClass;

public class BaseStep {

	   private Endpoints endPoints;
	  
	   private ExtentTest result;
	   
	   public BaseStep(TestContext testContext) {
	    	endPoints = testContext.getEndPoints();
	    	
	    	result=testContext.getreport();
	    }

	    public Endpoints getEndPoints() {
	        return endPoints;
	    }
	    
	   
	    
	    public ExtentTest result() {
	    	
			return ExtentReportsClass.extent;
			
			
		}
	    	
	    
	    public ExtentTest getreport() {
			
			return result;
			
			
		}
	    
	    
	}