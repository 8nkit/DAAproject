import java.util.*;
  
import java.util.regex.*; 
class ExtractNumberFromString
{
    	public static boolean isValid(String s) 
	{ 
		// The given argument to compile() method 
		// is regular expression. With the help of 
		// regular expression we can validate mobile 
		// number. 
		// 1) Begins with 0 or 91 
		// 2) Then contains 7 or 8 or 9. 
		// 3) Then contains 9 digits 
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 

		// Pattern class contains matcher() method 
		// to find matching between given number 
		// and regular expression 
		Matcher m = p.matcher(s); 
		return (m.find() && m.group().equals(s)); 
	} 


  public static void main(String[] args) 
  {
      String str;
      String numbers;

      Scanner SC=new Scanner(System.in);
       
      System.out.print("Enter string that contains numbers: ");
      str=SC.nextLine();
       
      //extracting string
    str = str.replaceAll("[^-?0-9]+", " "); 
    List<String> secondList=Arrays.asList(str.trim().split(" "));
             List<String> myAlist = new ArrayList<String>();  

    for (String strss : secondList) {
	       myAlist.add(strss);
    }
    
     for (int i=0; i<myAlist.size(); i++) {
            if (!isValid(myAlist.get(i))) { 
            myAlist.remove(myAlist.get(i));
                
            }
     }
      for (int i=0; i<myAlist.size(); i++) 
          System.out.println(myAlist.get(i));
  }
}