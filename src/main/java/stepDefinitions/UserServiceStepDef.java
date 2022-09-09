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



public class UserServiceStepDef extends BaseStep {
	final Logger logger = Log.getLogData(Log.class.getName());
	ExtentReport result ;
	public UserServiceStepDef(TestContext testContext) {
		
		super(testContext);
		result= new ExtentReport(testContext);
	}
	
	@When("^a user enters following details$")
	public void userRegistration(Map<String, String> data) throws Exception {
		try {
			
			Response UserDetailsResponse = getEndPoints().getResponse(data, UserServiceRoute.userLogin());

			
			if(UserDetailsResponse.statusCode()==200) {
				result.pass("User service Status Code :"+UserDetailsResponse.statusCode());
			}else {
				result.fatal("User service Status Code :"+UserDetailsResponse.statusCode());
			}
		
			JsonPath jsnPath = new JsonPath(UserDetailsResponse.asString());

			String userId = jsnPath.getString("details.userId");
			logger.info("User ID :" + userId);
			if(!(userId==null)) {
				result.pass("userId:"+userId);
			}else {
				result.fail("userId is null:"+userId);
			}
		
			String serverTime = jsnPath.getString("details.serverTime");
			logger.info("Server Time :" + serverTime);
			if(!(serverTime==null)) {
				result.pass("serverTime:"+serverTime);
			}else {
				result.fail("serverTime is null:"+serverTime);
			}

			String otpExpiryTime = jsnPath.getString("details.otpExpiryTime");
			logger.info("OTP Expire Time:" + otpExpiryTime);
			if(!(otpExpiryTime==null)) {
				result.pass("otpExpiryTime:"+otpExpiryTime);
			}else {
				result.fail("otpExpiryTime is null:"+otpExpiryTime);
			}
			

		} catch (Exception e) {
			result.fail("Exception:"+e);
			e.printStackTrace();
		}

	}

	@When("^a user resend otp$")
	public void resendOTP(Map<String, String> data) throws Exception {
		try {

			Response ResendOtpResponse = getEndPoints().getResponse(data, UserServiceRoute.reSendOTP());
			JsonPath jsnPath = new JsonPath(ResendOtpResponse.asString());
			
			if(ResendOtpResponse.statusCode()==200) {
				result.pass("Resend Status Code :"+ResendOtpResponse.statusCode());
			}else {
				result.fatal("Resend Status Code :"+ResendOtpResponse.statusCode());
			}

			
			String userId = jsnPath.getString("details.userId");
			logger.info("User ID :" + userId);
			if(!(userId==null)) {
				result.pass("userId:"+userId);
			}else {
				result.fail("userId is null:"+userId);
			}
		
			String serverTime = jsnPath.getString("details.serverTime");
			logger.info("Server Time :" + serverTime);
			if(!(serverTime==null)) {
				result.pass("serverTime:"+serverTime);
			}else {
				result.fail("serverTime is null:"+serverTime);
			}

			String otpExpiryTime = jsnPath.getString("details.otpExpiryTime");
			logger.info("OTP Expire Time:" + otpExpiryTime);
			if(!(otpExpiryTime==null)) {
				result.pass("otpExpiryTime:"+otpExpiryTime);
			}else {
				result.fail("otpExpiryTime is null:"+otpExpiryTime);
			}
			
			

		} catch (Exception e) {
			result.fail("Exception:"+e);

			e.printStackTrace();
		}

	}

}
