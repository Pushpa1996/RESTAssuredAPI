package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.gherkin.model.Scenario;





public class CreateFolder {
	static Scenario scenario;
	static String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	
	 public static String folderCreation () {        
		
		String path =System.getProperty("user.dir")+"\\ExtentReports\\Report_"+dateName;
		 System.out.println("-----------folderCreationpath-------------------"+path);
	      //Using Scanner class to get the folder name from the user  
	      System.out.println( "desired a directory"+path);  
	      
	      //Instantiate the File class   
	      File f1 = new File(path);  
	      //Creating a folder using mkdir() method  
	      boolean bool = f1.mkdir();  
	      if(bool){  
	         System.out.println("Folder is created successfully");  
	         return path;
	      }else{  
	         System.out.println("Error Found!");  
	      }
		return path;  
	   }  
}
