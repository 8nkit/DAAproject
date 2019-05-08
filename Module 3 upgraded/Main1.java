package finalproject;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
 
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
 
import java.util.regex.*; 
//Java Program to illustrate reading from FileReader 
//using BufferedReader 
import java.io.*; 
 @SuppressWarnings("unused")
public class Main1 extends Huffman01
{ 
	 String loc="JAIPUR";
	 
	 static String rwData;
	 static int KMPSearch(String pat, String txt) 
	    { 
	        int M = pat.length(); 
	        int N = txt.length(); 
	   
	        // create lps[] that will hold the longest 
	        // prefix suffix values for pattern 
	        int lps[] = new int[M]; 
	        int j = 0;  // index for pat[] 
	   
	        // Preprocess the pattern (calculate lps[] 
	        // array) 
	        computeLPSArray(pat,M,lps); 
	   
	        int i = 0;  // index for txt[] 
	        int res = 0;  
	        int next_i = 0;   
	          
	        while (i < N) 
	        { 
	            if (pat.charAt(j) == txt.charAt(i)) 
	            { 
	                j++; 
	                i++; 
	            } 
	            if (j == M) 
	            { 
	                // When we find pattern first time, 
	                // we iterate again to check if there  
	                // exists more pattern 
	                j = lps[j-1]; 
	                res++; 
	  
	                // We start i to check for more than once 
	                // appearance of pattern, we will reset i  
	                // to previous start+1 
	                if (lps[j]!=0) 
	                    i = ++next_i; 
	                j = 0; 
	            } 
	   
	            // mismatch after j matches 
	            else if (i < N && pat.charAt(j) != txt.charAt(i)) 
	            { 
	                // Do not match lps[0..lps[j-1]] characters, 
	                // they will match anyway 
	                if (j != 0) 
	                    j = lps[j-1]; 
	                else
	                    i = i+1; 
	            } 
	        } 
	        return res; 
	    } 
	   
	    static void computeLPSArray(String pat, int M, int lps[]) 
	    { 
	        // length of the previous longest prefix suffix 
	        int len = 0; 
	        int i = 1; 
	        lps[0] = 0;  // lps[0] is always 0 
	   
	        // the loop calculates lps[i] for i = 1 to M-1 
	        while (i < M) 
	        { 
	            if (pat.charAt(i) == pat.charAt(len)) 
	            { 
	                len++; 
	                lps[i] = len; 
	                i++; 
	            } 
	            else  // (pat[i] != pat[len]) 
	            { 
	                // This is tricky. Consider the example. 
	                // AAACAAAA and i = 7. The idea is similar  
	                // to search step. 
	                if (len != 0) 
	                { 
	                    len = lps[len-1]; 
	   
	                    // Also, note that we do not increment 
	                    // i here 
	                } 
	                else  // if (len == 0) 
	                { 
	                    lps[i] = len; 
	                    i++; 
	                } 
	            } 
	        } 
	   
	    }
	    
	
	
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

	

	 static int solve(int[] a) 
    { 
        // min Heap 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
  
        // to store the 2 numbers formed by array elements to 
        // minimize the required sum 
        StringBuilder num1 = new StringBuilder(); 
        StringBuilder num2 = new StringBuilder(); 
  
        // Adding elements in Priority Queue 
        for (int x : a) 
            pq.add(x); 
  
        // checking if the priority queue is non empty 
        while (!pq.isEmpty()) 
        { 
            num1.append(pq.poll()+ ""); 
            if (!pq.isEmpty()) 
                num2.append(pq.poll()+ ""); 
        } 
  
        // the required sum calculated 
        int sum = Integer.parseInt(num1.toString()) + 
        		Integer.parseInt(num2.toString()); 
  
        return sum; 
    } 
  
	
public static void main(String[] args)throws Exception 
{ 
	List<String> myAlist1 = new ArrayList<String>();  
	 HashMap<String, Integer> map = new HashMap<>();     
//We need to provide file path as the parameter: 
//double backquote is to avoid compiler interpret words 
//like \test as \t (ie. as a escape sequence) 
File file = new File("E:\\8nkit\\ank.txt"); 
BufferedReader br = new BufferedReader(new FileReader(file)); 
String str; 
while ((str= br.readLine()) != null) 
{
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
	myAlist1.add(myAlist.get(i)); 

}
Set<String> s = new LinkedHashSet<String>(myAlist1);  
List<String> aList = new ArrayList<String>(s.size()); 
for (String x : s) 
  aList.add(x); 

for(int i=0;i<aList.size();i++)
{
int ans=0;
String str1;
	File file1 = new File("E:\\8nkit\\ank.txt"); 
	BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
	while ((str1 = br1.readLine()) != null) 
	{
if (str1.contains(aList.get(i))) {
            

      
            if (str1.contains("Hello")||str1.contains("Hi"))
            	if(KMPSearch("Hello",str1)==1||KMPSearch("Hi",str1)==1)
            		ans++;
            		
           
        }
 }
	map.put(aList.get(i),ans); 
	br1.close();
}
    //print(map); 
	Map<String, Integer> sorted =map.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                    LinkedHashMap::new));
    
    
    Map.Entry<String,Integer> entry = sorted.entrySet().iterator().next();
    String key= entry.getKey();
    //int value=entry.getValue();
//
  //  System.out.println(key);
  //
    Main1 mon=new Main1();
    int i=0;
    long num = Long.parseLong(key);
//    Int_to_array(num);
    long [] arr= new long[10];
    do { 
    	arr[i] = num % 10; 
    	num /= 10; 
    	i++; 
    	} while (num != 0);
    
    int[] integerArray = new int[10];
	// copy elements from object array to integer array

    //for(int jj=0;jj<10;jj++)
    	//System.out.println(integerArray[jj]);
  int g11=solve(integerArray);
  Random rand = new Random();
g11=Math.abs(g11);
if(g11==0)
	g11=50200;
//Obtain a number between [0 - 49].
int g12 = rand.nextInt(g11);
int g1=g12;
//System.out.println(g1);
  if(g1%2==0 && g1%5==0) {
      mon.loc="MUMBAI";
      
     }
if(g1%2!=0) {
	mon.loc="HYDERABAD";
   
   }
if(g1%3==0&&g1%2!=0) {
	mon.loc="KOLKATA";
   
   }

if(g1%7==0&&g1%5!=0&&g1%3!=0&&g1%2!=0) {
	mon.loc="NAGPUR";
}
    if(g1%11==0&&g1%5!=0&&g1%3!=0&&g1%2!=0) {
    	mon.loc="DELHI";
    
   }
    if(g1%17==0&&g1%5!=0&&g1%3!=0&&g1%2!=0) {
    	mon.loc="JAIPUR";
    
   }
    if(g1%3==0&&g1%2==0&&g1%5!=0) {
    	mon.loc="CHENNAI";
       
       }
    if(g1%3!=0&&g1%5==0&&g1%2!=0) {
    	mon.loc="BENGALURU";
       
       }
    if(g1%19==0) {
        mon.loc="KASHMIR";
       
       }
    br.close();
   // mon.startdij();
    Main1 m=new Main1();
      m.dl(mon.loc);
}

}

 