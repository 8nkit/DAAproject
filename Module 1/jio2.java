//MODULE 1
// CONTRIBUTION : ANKIT SHARMA , PIYUSH KANSAL , ABHINAV JOSHI
//25th APRIL 2019
package jio2;
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
public class jio2
{
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
    int value=entry.getValue();
    System.out.println(key+" - "+value);
}
}
