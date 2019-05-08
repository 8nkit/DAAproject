package finalproject;

import java.text.ParseException;
import java.util.Arrays;


public class StringToASCII {

    public static void main(String args[]) throws ParseException {
        
        // converting character to ASCII value in Java
        char A = 'A';
        int ascii = A;
        System.out.println("ASCII value of 'A' is  : " + ascii);
        
        // you can explicitly cast also
        char a = 'a';
        int value = (int) a;
        System.out.println("ASCII value of 'a' is  : " + value);
        
        
        
        
        // converting String to ASCII value in Java
        try {
            String text = "ABCDEFGHIJKLMNOP";

            // translating text String to 7 bit ASCII encoding
            byte[] bytes = text.getBytes("US-ASCII");
            
            System.out.println("ASCII value of " + text + " is following");
            System.out.println(Arrays.toString(bytes));
            
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
