//package dellyf;
import java.io.*; 
public class extractionfrmfile{
	   /*public static void main(String args[]){
	       String str1 = new String("This is a test String");
	       String str2 = new String("Test ABC");
	       boolean var1 = str1.endsWith("String");
	       boolean var2 = str1.endsWith("ABC");
	       boolean var3 = str2.endsWith("String");
	       boolean var4 = str2.endsWith("ABC");
	       System.out.println("str1 ends with String: "+ var1);
	       System.out.println("str1 ends with ABC: "+ var2);
	       System.out.println("str2 ends with String: "+ var3);
	       System.out.println("str2 ends with ABC: "+ var4);
	    */
	public static void main(String[] args)throws Exception 
	    { 
	    File file = new File("E:\\\\8nkit\\\\out.txt"); 
	    BufferedReader br = new BufferedReader(new FileReader(file)); 

	    String st; 
	    while ((st = br.readLine()) != null) {
		       boolean var1 = st.endsWith("CHENNAI");
		       if(var1)
	    	System.out.println(st);
	    }
	    	br.close();
	    } 
}