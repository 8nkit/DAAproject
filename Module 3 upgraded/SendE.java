package finalproject;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
public class SendE{  
 static void sendmail(){  

		Scanner sc= new Scanner(System.in);
		
	    // Sender's email ID needs to be mentioned
		System.out.print("Recipent email : ");
		   String to = sc.nextLine();
	System.out.print("To send this mail you must login to your mailing account : \n");
		System.out.print("Email : ");
	     String from = sc.nextLine();
	     System.out.print("Password : ");
	     String pass=sc.nextLine();
	     System.out.println("Logging you in and sending your mail ...");
	     int timeToWait = 3; //second
	     try {
	         for (int i=0; i<timeToWait ; i++) {
	             Thread.sleep(400);
	             System.out.print(".");
	         }
	     } catch (InterruptedException ie)
	     {
	         Thread.currentThread().interrupt();
	     }
	sc.close();
  String host = "smtp.gmail.com";

  // Get system properties
  Properties properties = System.getProperties();
  // Setup mail server
  properties.put("mail.smtp.starttls.enable", "true");
  properties.put("mail.smtp.host", host);
  properties.put("mail.smtp.user", from);
  properties.put("mail.smtp.password", pass);
  properties.put("mail.smtp.port", "587");
  properties.put("mail.smtp.auth", "true");

  Session session = Session.getDefaultInstance(properties,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(from,pass);  
   }  
   
  });  
     
  //2) compose message     
  try{  
    MimeMessage message = new MimeMessage(session);  
    message.setFrom(new InternetAddress(from));  
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    message.setSubject("MAVERICK'S");  
      
    //3) create MimeBodyPart object and set your message text     
    BodyPart messageBodyPart1 = new MimeBodyPart();  
    messageBodyPart1.setText("The information in the attached file is confidential ");  
      
    //4) create new MimeBodyPart object and set DataHandler object to this object      
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
  
    String filename = "E:\\8nkit\\encrypted.txt";//change accordingly  
    DataSource source = new FileDataSource(filename);  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(filename);  
     
     
    //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  
  
    //6) set the multiplart object to the message object  
    message.setContent(multipart );  
     
    //7) send message  
    Transport.send(message);  
   
   System.out.println("Email sent...");  
   }catch (MessagingException ex) {ex.printStackTrace();}  
 }  
}  