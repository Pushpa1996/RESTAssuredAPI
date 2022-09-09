package apiEngine.model.route;

public class UserServiceRoute {
	
	
    private static final String VERSION = "/v1.0";
   
    
    
    public static String userLogin(){
    	return  VERSION + "/userLogin";
    }

    public static String reSendOTP(){ 
    	return  VERSION + "/reSendOTP";
    }

    public static String verifyOTPByMobile(){ 
    	return  VERSION + "/verifyOTPByMobile";
    }

    public static String createUserProfile(){ 
    	return  VERSION + "/createUserProfile";
    }
    
    public static String updateUserProfile(){ 
    	return  VERSION + "/updateUserProfile";
    }
    
    
    public static String getUserProfile(){ 
    	return  VERSION + "/getUserProfile";
    }
    
    public static String getRefreshToken(){ 
    	return  VERSION + "/getRefreshToken";
    }
}
