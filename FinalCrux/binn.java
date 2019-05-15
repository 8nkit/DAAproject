package finalcrux;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;
import java.util.Properties;
import java.util.Scanner;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class binn extends Dijkstra {
    private static final String encryptionKey           = "ABCDEFGHIJKLMNOP";
    private static final String characterEncoding       = "UTF-8";
    private static final String cipherTransformation    = "AES/CBC/PKCS5PADDING";
    private static final String aesEncryptionAlgorithem = "AES";
    public static String encrypt(String plainText) {
        String encryptedText = "";
        try {
            Cipher cipher   = Cipher.getInstance(cipherTransformation);
            byte[] key      = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            Base64.Encoder encoder = Base64.getEncoder();
            encryptedText = encoder.encodeToString(cipherText);
        } catch (Exception E) {
             System.err.println("Encrypt Exception : "+E.getMessage());
        }
        return encryptedText;
    }
    public static String decrypt(String encryptedText) {
        String decryptedText = "";
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] cipherText = decoder.decode(encryptedText.getBytes("UTF8"));
            decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");
        } catch (Exception E) {
            System.err.println("decrypt Exception : "+E.getMessage());
        }
        return decryptedText;
    }
    
    public static String reverseString(String myStr)
    {
        if (myStr.isEmpty()){
         return myStr;
        }
        return reverseString(myStr.substring(1)) + myStr.charAt(0);
    }
    
     static String getAlphaNumericString(int n) 
        {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                        + "0123456789"
                                        + "abcdefghijklmnopqrstuvxyz";
            StringBuilder sb = new StringBuilder(n); 
      
            for (int i = 0; i < n; i++) {
                int index 
                    = (int)(AlphaNumericString.length() 
                            * Math.random());
                sb.append(AlphaNumericString 
                              .charAt(index)); 
            } 
      
            return sb.toString(); 
        }
     static String longestRepeatedSubstring(String str) { 
            int n = str.length(); 
            int LCSRe[][] = new int[n + 1][n + 1]; 
      
            String res = "";
            int res_length = 0;
            int i, index = 0; 
            for (i = 1; i <= n; i++) { 
                for (int j = i + 1; j <= n; j++) {
                    if (str.charAt(i - 1) == str.charAt(j - 1) 
                            && LCSRe[i - 1][j - 1] < (j - i)) { 
                        LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;
                        if (LCSRe[i][j] > res_length) { 
                            res_length = LCSRe[i][j]; 
                            index = Math.max(i, index); 
                        } 
                    } else { 
                        LCSRe[i][j] = 0; 
                    } 
                } 
            }
            if (res_length > 0) { 
                for (i = index - res_length + 1; i <= index; i++) { 
                    res += str.charAt(i - 1); 
                } 
            } 
      
            return res; 
        } 
       public void dl(String locc,String kkey)throws Exception
     {
           binn b2=new binn();
           b2.startdij();
        File file2 = new File("E:\\8nkit\\out.txt"); 
         BufferedReader br1 = new BufferedReader(new FileReader(file2)); 
         
         String st;
         String rwData="NONE ";
         while ((st = br1.readLine()) != null) {
               boolean var1 = st.endsWith(locc);
               if(var1)
                 rwData=st;
         }
        br1.close();
        String drep=encrypt(kkey)+"::";
        try{
            FileWriter fstream = new FileWriter("df.txt");
                BufferedWriter outa = new BufferedWriter(fstream);
                outa.write(drep);
                outa.write(System.lineSeparator());
          outa.close();
            }
      catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
        }
        
        String rev=reverseString(rwData);//reverse
        String encyptStr   = encrypt(rev);//encrypt the reverse string
        int niz=encyptStr.length()/2;
        String gt= getAlphaNumericString(niz);
        String fin=encyptStr+gt+encyptStr;//encrypt+randomstr+encrypt
        try{
            FileWriter fstream = new FileWriter("df.txt",true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(fin);
                out.close();
            }
      catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
        }
        System.out.println("File processed... Wait to email the file");
        int timeToWait = 5;
        try {
             for (int ii=0; ii<timeToWait ; ii++) {
                 Thread.sleep(400);
                 System.out.print(".");
             }
         } catch (InterruptedException ie)
         {
             Thread.currentThread().interrupt();
         }
        sendmail();
     }
         static void sendmail(){  
                Scanner sc= new Scanner(System.in);
                System.out.println("\n ");
                System.out.println("Recipent email : ");
                   String to = sc.nextLine();
            System.out.print("To send this mail you must login to your mailing account : \n");
                System.out.print("Email : ");
                String from = sc.nextLine();
                System.out.print("Password : ********");
                String pass="icing9cake@";
                System.out.println("\n");
                 System.out.println("Logging you in and sending your mail ...");
                 int timeToWait = 3;
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
          Properties properties = System.getProperties();
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
          try{  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(from));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject("MAVERICK'S");
            BodyPart messageBodyPart1 = new MimeBodyPart();  
            messageBodyPart1.setText("The information in the attached file is confidential ");
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
            String filename = "df.txt";//change accordingly  
            DataSource source = new FileDataSource(filename);  
            messageBodyPart2.setDataHandler(new DataHandler(source));  
            messageBodyPart2.setFileName(filename);
            Multipart multipart = new MimeMultipart();  
            multipart.addBodyPart(messageBodyPart1);  
            multipart.addBodyPart(messageBodyPart2);
            message.setContent(multipart );
            Transport.send(message);  
           System.out.println("Email sent...");  
           }catch (MessagingException ex) {ex.printStackTrace();}  
         }
         
         public void option2(String dfileloc)throws Exception
         {
             
        	 File file2a = new File(dfileloc); 
             BufferedReader br12 = new BufferedReader(new FileReader(file2a)); 
             String staa;
             String rwDataaa="NONE ";
             while ((staa = br12.readLine()) != null) {
                 boolean var1 = staa.endsWith("::");
                   if(var1)
                     rwDataaa=staa;
             }
             rwDataaa=rwDataaa.substring(0, rwDataaa.length() - 2);
             br12.close();
             String decryptStr12  = decrypt(rwDataaa);//decrypt it 
             System.out.println(decryptStr12);
             File file2 = new File(dfileloc); 
             BufferedReader br1 = new BufferedReader(new FileReader(file2)); 
             
             String sta;
             String rwDataa="NONE ";
             while ((sta = br1.readLine()) != null) {
                     rwDataa=sta;
             }
            br1.close();
            String ff=longestRepeatedSubstring(rwDataa);//using dynamic obtain encrypt
            String decryptStr1  = decrypt(ff);//decrypt it 
            System.out.println(reverseString(decryptStr1));//print the reverse of decryption             
         }
     }
