package stepDefinitions;

import java.util.Map;

import org.apache.log4j.Logger;

import apiEngine.model.common.BaseStep;
import apiEngine.model.route.UserServiceRoute;
import cucumber.TestContext;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.ExtentReport;
import utility.Log;


public class VerifyOTPByMobileStepDef extends BaseStep {
	final Logger logger = Log.getLogData(Log.class.getName());
	ExtentReport result ;
	public VerifyOTPByMobileStepDef(TestContext testContext) {
		
		super(testContext);
		result= new ExtentReport(testContext);
	}
	
	@When("^user enter mobile details with otp$")
	public void verifyOtpByMobile(Map<String, String> data) throws Exception {
		try {
			
			Response otpByMobile = getEndPoints().getResponse(data, UserServiceRoute.verifyOTPByMobile());

			
			if(otpByMobile.statusCode()==200) {
				result.pass("otpByMobile Status Code :"+otpByMobile.statusCode());
			}else {
				result.fatal("otpByMobile Status Code :"+otpByMobile.statusCode());
			}
		
			JsonPath jsnPath = new JsonPath(otpByMobile.asString());

			String userAccountStatus = jsnPath.getString("details.userAccountStatus");
			logger.info("userAccountStatus :" + userAccountStatus);
			if(!(userAccountStatus==null)) {
				result.pass("userAccountStatus:"+userAccountStatus);
			}else {
				result.fail("userAccountStatus is null:"+userAccountStatus);
			}
		
			String loginType = jsnPath.getString("details.loginType");
			logger.info("loginType :" + loginType);
			if(!(loginType==null)) {
				result.pass("loginType:"+loginType);
			}else {
				result.fail("loginType is null:"+loginType);
			}

			String accessToken = jsnPath.getString("details.accessToken");
			logger.info("accessToken:" + accessToken);
			if(!(accessToken==null)) {
				result.pass("accessToken:"+accessToken);
			}else {
				result.fail("accessToken is null:"+accessToken);
			}
			
			
			String gameUserId = jsnPath.getString("details.gameUserId");
			logger.info("gameUserId:" + gameUserId);
			if(!(gameUserId==null)) {
				result.pass("gameUserId:"+gameUserId);
			}else {
				result.fail("gameUserId is null:"+gameUserId);
			}
			
			
			String gameHost = jsnPath.getString("details.gameHost");
			logger.info("gameHost:" + gameUserId);
			if(!(gameHost==null)) {
				result.pass("gameHost:"+gameHost);
			}else {
				result.fail("gameHost is null:"+gameHost);
			}
			
			
			String gameToken = jsnPath.getString("details.gameToken");
			logger.info("gameToken:" + gameToken);
			if(!(gameToken==null)) {
				result.pass("gameToken:"+gameToken);
			}else {
				result.fail("gameToken is null:"+gameToken);
			}
			

		} catch (Exception e) {
			result.fail("Exception:"+e);
			e.printStackTrace();
		}

	}
}
