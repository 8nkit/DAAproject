package finalproject;
import java.util.*;
import java.io.*;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
@SuppressWarnings("unused")
public class Huffman01 extends Dijkstra{
	
	
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
	 
	 
	 
	  void dl(String locc)throws Exception
	 {
		  Huffman01 l=new Huffman01();
		  l.startdij();
	 	File file2 = new File("E:\\8nkit\\out.txt"); 
	     BufferedReader br1 = new BufferedReader(new FileReader(file2)); 
	     //String vro="";
	     //System.out.println(viu.loc);
	     
	     String st;
	     String rwData="NONE ";
	     while ((st = br1.readLine()) != null) {
	 	       boolean var1 = st.endsWith(locc);
	 	       if(var1)
	 	    	 rwData=st;
	     }
	 	br1.close();
	 
	 	mainn(rwData);
	 }
	 
	 
	static void mainn(String rawData)throws Exception {
		Huffman01 vvdi=new Huffman01();
    	//String rawData=Main1.rwData;
    	//System.out.println(rawData);
   	Hashtable < Character, String > huffEncodeTable;
        int rawDataLen = rawData.length();
        HuffmanEncoder encoder = new HuffmanEncoder();
        huffEncodeTable = new Hashtable < Character, String > (); 
        ArrayList < Byte > binaryEncodedData = encoder.encode(rawData, huffEncodeTable);
        hexDisplay48(binaryEncodedData);
        System.out.println( huffEncodeTable);
        sendmail();  
        /*System.out.println();
        HuffmanDecoder decoder = new HuffmanDecoder();
        String decodedData = decoder.decode(binaryEncodedData, huffEncodeTable,rawDataLen);
        display48(decodedData);
   */ }
    static void display48(String data) {
        for (int cnt = 0; cnt < data.length(); cnt += 48) {
            if ((cnt + 48) < data.length()) {
          	  try{
				    FileWriter fstream = new FileWriter("E:\\8nkit\\grab.txt");
				        BufferedWriter out = new BufferedWriter(fstream);
				  out.write(data.substring(cnt, cnt + 48));
				  out.write(System.lineSeparator());  
				  out.close();
				    }
			  catch (Exception e){//Catch exception if any
			      System.err.println("Error: " + e.getMessage());
			    }

            	
//                System.out.println(data.substring(cnt, cnt + 48));
            } else {
            	try{
				    FileWriter fstream = new FileWriter("E:\\8nkit\\grab.txt",true);
				        BufferedWriter out = new BufferedWriter(fstream);
				  out.write(data.substring(cnt));
				  out.write(System.lineSeparator());  
				  out.close();
				    }
			  catch (Exception e){//Catch exception if any
			      System.err.println("Error: " + e.getMessage());
			    }
                //System.out.println(data.substring(cnt));
            }
        }
    }
    static void hexDisplay48(
        ArrayList < Byte > binaryEncodedData) {
        int charCnt = 0;
        try{
		    FileWriter fstream = new FileWriter("E:\\8nkit\\encrypted.txt");
		        BufferedWriter out = new BufferedWriter(fstream);
		  out.close();
		    }
	  catch (Exception e){//Catch exception if any
	      System.err.println("Error: " + e.getMessage());
	    }
        for (Byte element: binaryEncodedData) {
        	try{
			    FileWriter fstream = new FileWriter("E:\\8nkit\\encrypted.txt",true);
			        BufferedWriter out = new BufferedWriter(fstream);
			  out.write(Integer.toHexString((int) element & 0X00FF));
			  out.close();
			    }
		  catch (Exception e){//Catch exception if any
		      System.err.println("Error: " + e.getMessage());
		    }
            charCnt++;
            if (charCnt % 24 == 0) {
            	try{
    			    FileWriter fstream = new FileWriter("E:\\8nkit\\encrypted.txt",true);
    			        BufferedWriter out = new BufferedWriter(fstream);
    			  out.write(System.lineSeparator());  
    			  out.close();
    			    }
    		  catch (Exception e){//Catch exception if any
    		      System.err.println("Error: " + e.getMessage());
    		    }
            	charCnt = 0;
            }
        }
    }
}
class HuffmanEncoder {
    String rawData;
    TreeSet < HuffTree > theTree = new TreeSet < HuffTree > ();
    ArrayList < Byte > binaryEncodedData =
        new ArrayList < Byte > ();
    Hashtable < Character, Integer > frequencyData =
        new Hashtable < Character, Integer > ();
    StringBuffer code = new StringBuffer();
    Hashtable < Character, String > huffEncodeTable;
    String stringEncodedData;
    Hashtable < String, Byte > encodingBitMap =
        new Hashtable < String, Byte > ();
    ArrayList < Byte > encode(
        String rawData,
        Hashtable < Character, String > huffEncodeTable) {
        this.rawData = rawData;
        this.huffEncodeTable = huffEncodeTable;

        createFreqData();
        createLeaves();
        createHuffTree();
        createBitCodes(theTree.first());
        encodeToString();
        buildEncodingBitMap();
        encodeStringToBits();
        return binaryEncodedData;
    }
    void createFreqData() {
        for (int cnt = 0; cnt < rawData.length(); cnt++) {
            char key = rawData.charAt(cnt);
            if (frequencyData.containsKey(key)) {
                int value = frequencyData.get(key);
                value += 1;
                frequencyData.put(key, value);
            } else {
                frequencyData.put(key, 1);
            }
        }
    }
    void displayFreqData() {
        System.out.println("nFrequency Data");
        Enumeration < Character > enumerator =
            frequencyData.keys();
        while (enumerator.hasMoreElements()) {
            Character nextKey = enumerator.nextElement();
            System.out.println(
                nextKey + " " + frequencyData.get(nextKey));
        }
    }
    void createLeaves() {
        Enumeration < Character > enumerator =
            frequencyData.keys();
        while (enumerator.hasMoreElements()) {
            Character nextKey = enumerator.nextElement();
            theTree.add(new HuffLeaf(
                nextKey, frequencyData.get(nextKey)));
        }
    }
    class HuffLeaf extends HuffTree {
        private int value;
        public HuffLeaf(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
        public int getValue() {
            return value;
        }
    }
    void createHuffTree() {
        while (theTree.size() > 1) {
            HuffTree left = theTree.first();
            theTree.remove(left);
            HuffTree right = theTree.first();
            theTree.remove(right);
            HuffNode tempNode = new HuffNode(left.getFrequency() +
                right.getFrequency(), left, right);
            theTree.add(tempNode);

        }
    }
    void displayHuffTree(HuffTree tree, int recurLevel) {
        recurLevel++;
        if (tree instanceof HuffNode) {
            HuffNode node = (HuffNode) tree;
            HuffTree left = node.getLeft();
            HuffTree right = node.getRight();
            System.out.print("  Left to " + recurLevel + " ");
            displayHuffTree(left, recurLevel);
            System.out.print("  Right to " + recurLevel + " ");
            displayHuffTree(right, recurLevel);
        } else {
            HuffLeaf leaf = (HuffLeaf) tree;
            System.out.println(
                "  Leaf:" + (char) leaf.getValue());
        }
        System.out.print("  Back ");
    }
    class HuffNode extends HuffTree {
        private HuffTree left;
        private HuffTree right;
        public HuffNode(
            int frequency, HuffTree left, HuffTree right) {
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
        public HuffTree getLeft() {
            return left;
        }
        public HuffTree getRight() {
            return right;
        }
    }
    void createBitCodes(HuffTree tree) {
        if (tree instanceof HuffNode) {
            HuffNode node = (HuffNode) tree;
            HuffTree left = node.getLeft();
            HuffTree right = node.getRight();
            code.append("0");
            createBitCodes(left);
            code.deleteCharAt(code.length() - 1);
            code.append("1");
            createBitCodes(right);
            code.deleteCharAt(code.length() - 1);
        } else {
            HuffLeaf leaf = (HuffLeaf) tree;
            huffEncodeTable.put((char)(
                leaf.getValue()), code.toString());
        }
    }
    void displayBitCodes() {
        System.out.println(
            "nMessage Characters versus Huffman BitCodes");
        Enumeration < Character > enumerator =
            huffEncodeTable.keys();
        while (enumerator.hasMoreElements()) {
            Character nextKey = enumerator.nextElement();
            System.out.println(
                nextKey + " " + huffEncodeTable.get(nextKey));
        }
    }
    void encodeToString() {
        StringBuffer tempEncoding = new StringBuffer();
        for (int cnt = 0; cnt < rawData.length(); cnt++) {
            tempEncoding.append(huffEncodeTable.get(
                rawData.charAt(cnt)));
        }
        stringEncodedData = tempEncoding.toString();
    }
    void buildEncodingBitMap() {
        for (int cnt = 0; cnt <= 255; cnt++) {
            StringBuffer workingBuf = new StringBuffer();
            if ((cnt & 128) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 64) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 32) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 16) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 8) > 0) {
                workingBuf.append("1");
         } else {
                workingBuf.append("0");
            };
            if ((cnt & 4) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 2) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 1) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            encodingBitMap.put(workingBuf.toString(),
                (byte)(cnt));
        }
    }
    void encodeStringToBits() {
        int remainder = stringEncodedData.length() % 8;
        for (int cnt = 0; cnt < (8 - remainder); cnt++) {
            stringEncodedData += "0";
        }
        for (int cnt = 0; cnt < stringEncodedData.length(); cnt += 8) {
            String strBits = stringEncodedData.substring(
                cnt, cnt + 8);
            byte realBits = encodingBitMap.get(strBits);
            binaryEncodedData.add(realBits);
        }
    }
    void display48(String data) {
        for (int cnt = 0; cnt < data.length(); cnt += 48) {
            if ((cnt + 48) < data.length()) {
                System.out.println(data.substring(cnt, cnt + 48));
            } else {
                System.out.println(data.substring(cnt));
            }
        }
    }
}
class HuffmanDecoder {
    Hashtable < String, Character > huffDecodeTable =
        new Hashtable < String, Character > ();
    String stringDecodedData;
    String decodedData = "";
    Hashtable < Byte, String > decodingBitMap =
        new Hashtable < Byte, String > ();
    ArrayList < Byte > binaryEncodedData;
    Hashtable < Character, String > huffEncodeTable;
    int rawDataLen;
    String decode(ArrayList < Byte > binaryEncodedData,
        Hashtable < Character, String > huffEncodeTable,
        int rawDataLen) {
        this.binaryEncodedData = binaryEncodedData;
        this.huffEncodeTable = huffEncodeTable;
        this.rawDataLen = rawDataLen;
        buildDecodingBitMap();
        decodeToBitsAsString();
        buildHuffDecodingTable();
        decodeStringBitsToCharacters();
        return decodedData.substring(0, rawDataLen);
    }
    void buildDecodingBitMap() {
        for (int cnt = 0; cnt <= 255; cnt++) {
            StringBuffer workingBuf = new StringBuffer();
            if ((cnt & 128) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 64) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 32) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 16) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 8) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 4) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 2) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            if ((cnt & 1) > 0) {
                workingBuf.append("1");
            } else {
                workingBuf.append("0");
            };
            decodingBitMap.put((byte)(cnt), workingBuf.toString());
        }
    }
    void decodeToBitsAsString() {
        StringBuffer workingBuf = new StringBuffer();
        for (Byte element: binaryEncodedData) {
            byte wholeByte = element;
            workingBuf.append(decodingBitMap.get(wholeByte));
        }
        stringDecodedData = workingBuf.toString();
    }
    void buildHuffDecodingTable() {
        Enumeration < Character > enumerator =
            huffEncodeTable.keys();
        while (enumerator.hasMoreElements()) {
            Character nextKey = enumerator.nextElement();
            String nextString = huffEncodeTable.get(nextKey);
            huffDecodeTable.put(nextString, nextKey);
        }
    }
    void decodeStringBitsToCharacters() {
        StringBuffer output = new StringBuffer();
        StringBuffer workBuf = new StringBuffer();
        for (int cnt = 0; cnt < stringDecodedData.length(); cnt++) {
            workBuf.append(stringDecodedData.charAt(cnt));
            if (huffDecodeTable.containsKey(workBuf.toString())) {
                output.append(
                    huffDecodeTable.get(workBuf.toString()));
                workBuf = new StringBuffer();
            }
        }
        decodedData = output.toString();
    }
    void display48(String data) {
        for (int cnt = 0; cnt < data.length(); cnt += 48) {
            if ((cnt + 48) < data.length()) {
                System.out.println(data.substring(cnt, cnt + 48));
            } else {
                System.out.println(data.substring(cnt));
            }
        }
    }
}
@SuppressWarnings("rawtypes")
abstract class HuffTree implements Comparable {
    int frequency;
    public int getFrequency() {
        return frequency;
    }
    public int compareTo(Object obj) {
        HuffTree theTree = (HuffTree) obj;
        if (frequency == theTree.frequency) {
            return (hashCode() - theTree.hashCode());
        } else {
            return frequency - theTree.frequency;
        }
    }
}