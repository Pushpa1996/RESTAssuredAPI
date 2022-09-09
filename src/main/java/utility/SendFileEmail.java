package utility;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


public class SendFileEmail {
	static Encryptionutil util = new Encryptionutil();
	static String timeStamp = new SimpleDateFormat("d_MMM_YY HH").format(Calendar.getInstance().getTime());
	public static void mail(String filename) {
		try {
			ZipFile.zipSingleFile(filename,filename+".zip");
			filename=filename+".zip";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	final String username = util.getEncryptionvalue("mail.username");
	final String password = util.getEncryptionvalue("mail.password");

		// final String username ="pushpakumarpush2104@gmail.com";
		// final String password ="twxgmnthppqntmad";
		String hostname = "smtp.gmail.com.";

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = new Properties();

		props.put("mail.smtp.host", hostname);

		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		// props.put("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");

		javax.mail.Authenticator auth = new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("AutomationResult@gmail.com"));

			// InternetAddress[] address = {new InternetAddress("sridasyam@gmail.com")};

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("sridasyam@gmail.com,pushpakumaripush21@gmail.com"));

			// msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject("ExtentReportZIP");
			// msg.addHeader("x-cloudmta-class", "standard");
			// msg.addHeader("x-cloudmta-tags", "demo, example");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Please find the attached report");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// set the second part, which is the attachment
			messageBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// send the entire message parts
			msg.setContent(multipart);
			Transport.send(msg);

			System.out.println("Message Sent.");
		} catch (javax.mail.MessagingException ex) {
			throw new RuntimeException(ex);
		}
	}

}