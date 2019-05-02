package jio2;

public class filupe {
public static void main(String...args) {
	long g1=9675102496L;
	  String loc=""; 
	  
	  if(g1%2==0 && g1%11==0)
		   loc="DELHI";
	  if(g1%2==0 && g1%3==0)
		  loc="MUMBAI";
	  if(g1%2==0 && g1%3==0 && g1%5!=0)
		  loc="NAGPUR";
	  if(g1%2==0 && g1%3==0 && g1%5==0)
		  loc="ALIGARH";
	  if(g1%3==0 && g1%5==0 && g1%7==0)
		  loc="DHANBAD";
	  if(g1%7==0 && g1%5==0)
		  loc="CHENNAI";
	  if(g1%11==0 && g1%7==0)
		  loc="MIRZAPUR";
	  if(g1%5!=0 && g1%11==0 && g1%3==0)
		  loc="SURAT";
	  else
		  loc="BULANDSHAHR";
	  System.out.println(loc);
}
	  
	
}
