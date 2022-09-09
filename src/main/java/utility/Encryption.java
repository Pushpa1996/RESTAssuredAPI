package utility;

public class Encryption {

	public static void main(String[] args) {
		
				// Create String variables
				// String originalString = "pushpakumaripush2104@gmail.com";

				String originalString = args[0];

				// Call encryption method
				String encryptedString = Encryptionutil.encrypt(originalString);

				// Call decryption method
				//String decryptedString = Encryptionutil.decrypt(encryptedString);

				// Print all strings
				System.out.println("**********************************************");
				System.out.println(encryptedString);
				System.out.println("**********************************************");
			}
	
	
	

	}




