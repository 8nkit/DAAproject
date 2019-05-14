package finalcrux;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import java.util.regex.*;
import java.io.*;
@SuppressWarnings("unused")
public class Main1 extends binn {
    static String kkey = "";
    String loc = "JAIPUR";
    static String rwData;
    static int KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;
        computeLPSArray(pat, M, lps);
        int i = 0;
        int res = 0;
        int next_i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                j = lps[j - 1];
                res++;
                if (lps[j] != 0)
                    i = ++next_i;
                j = 0;
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return res;
    }
    static void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else
            {
                if (len != 0) {
                    len = lps[len - 1];
                } else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static boolean isValid(String s) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    static int solve(int[] a) {
        PriorityQueue < Integer > pq = new PriorityQueue < Integer > ();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int x: a)
            pq.add(x);
        while (!pq.isEmpty()) {
            num1.append(pq.poll() + "");
            if (!pq.isEmpty())
                num2.append(pq.poll() + "");
        }
        int sum = Integer.parseInt(num1.toString()) +
            Integer.parseInt(num2.toString());
        return sum;
    }
    static void locatingf(String fileloc3) throws Exception {
        List < String > myAlist1 = new ArrayList < String > ();
        HashMap < String, Integer > map = new HashMap < > ();
        File file = new File(fileloc3);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            str = str.replaceAll("[^-?0-9]+", " ");
            List < String > secondList = Arrays.asList(str.trim().split(" "));
            List < String > myAlist = new ArrayList < String > ();
            for (String strss: secondList) {
                myAlist.add(strss);
            }
            for (int i = 0; i < myAlist.size(); i++) {
                if (!isValid(myAlist.get(i))) {
                    myAlist.remove(myAlist.get(i));
                }
            }
            for (int i = 0; i < myAlist.size(); i++)
                myAlist1.add(myAlist.get(i));
        }
        Set < String > s = new LinkedHashSet < String > (myAlist1);
        List < String > aList = new ArrayList < String > (s.size());
        for (String x: s)
            aList.add(x);
        for (int i = 0; i < aList.size(); i++) {
            int ans = 0;
            String str1;
            File file1 = new File(fileloc3);
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            while ((str1 = br1.readLine()) != null) {
                if (str1.contains(aList.get(i))) {
                    if (str1.contains("kill") || str1.contains("killing"))
                        if (KMPSearch("kill", str1) == 1 || KMPSearch("killing", str1) == 1)
                            ans++;
                }
            }
            map.put(aList.get(i), ans);
            br1.close();
        }
        Map<String, Integer> sorted =map.entrySet()
	            .stream()
	            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	            .collect(
	                toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
	                    LinkedHashMap::new));
        
        Map.Entry < String, Integer > entry = sorted.entrySet().iterator().next();
        String key = entry.getKey();
        kkey = key;
        Main1 mon = new Main1();
        int i = 0;
        long num = Long.parseLong(key);
        long[] arr = new long[10];
        do {
            arr[i] = num % 10;
            num /= 10;
            i++;
        } while (num != 0);
        int[] integerArray = new int[10];
        int g11 = solve(integerArray);
        Random rand = new Random();
        g11 = Math.abs(g11);
        if (g11 == 0)
            g11 = 50200;
        int g12 = rand.nextInt(g11);
        int g1 = g12;
        if (g1 % 2 == 0 && g1 % 5 == 0) {
            mon.loc = "MUMBAI";
        }
        if (g1 % 2 != 0) {
            mon.loc = "HYDERABAD";
        }
        if (g1 % 3 == 0 && g1 % 2 != 0) {
            mon.loc = "KOLKATA";
        }
        if (g1 % 7 == 0 && g1 % 5 != 0 && g1 % 3 != 0 && g1 % 2 != 0) {
            mon.loc = "NAGPUR";
        }
        if (g1 % 11 == 0 && g1 % 5 != 0 && g1 % 3 != 0 && g1 % 2 != 0) {
            mon.loc = "DELHI";
        }
        if (g1 % 17 == 0 && g1 % 5 != 0 && g1 % 3 != 0 && g1 % 2 != 0) {
            mon.loc = "JAIPUR";
        }
        if (g1 % 3 == 0 && g1 % 2 == 0 && g1 % 5 != 0) {
            mon.loc = "CHENNAI";
        }
        if (g1 % 3 != 0 && g1 % 5 == 0 && g1 % 2 != 0) {
            mon.loc = "BENGALURU";
        }
        if (g1 % 19 == 0) {
            mon.loc = "KASHMIR";
        }
        br.close();
        Main1 m = new Main1();
        m.dl(mon.loc, kkey);
    }
    public static void main(String[] args) throws Exception {
        int opt = 0;
        System.out.println("THE MAVERICK'S WELCOMES YOU HERE");
        System.out.println("\t Menu");
        System.out.println("\t 1. Report if you've the database ");
        System.out.println("\t 2. Decrypt your mail attachment ");
        System.out.println("Your choice : ");
        Scanner sc = new Scanner(System.in);
        opt = sc.nextInt();
        switch (opt) {
            case 1:
                System.out.println("Enter the Chat file location :  ");
                String c = sc.next();
                locatingf(c);
                break;
            case 2:
                System.out.println("Enter the file location :  ");
                String dfile = sc.next();
                Main1 op2 = new Main1();
                op2.option2(dfile);
                break;
            default:
                System.out.println("Wrong Choice!!! Try again");
                break;
        }
        sc.close();
    }
}