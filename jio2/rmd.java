package jio2;
import java.util.Random;

public class rmd {

public static long randInt(long Min, long Max) {

    // NOTE: This will (intentionally) not run as written so that folks
    // copy-pasting have to think about how to initialize their
    // Random instance.  Initialization of the Random instance is outside
    // the main scope of the question, but some decent options are to have
    // a field that is initialized once and then re-used as needed or to
    // use ThreadLocalRandom (if using at least Java 1.7).
    // 
    // In particular, do NOT do 'Random rand = new Random()' here or you
    // will get not very good / not very random results.

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    long randomNum =(long)(Min + (Math.random() * (Max - Min)));

    return randomNum;
}
public static void main(String...strings)
{
	System.out.println(randInt(9000,9999));
}
}
