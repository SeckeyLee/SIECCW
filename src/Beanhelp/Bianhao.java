package Beanhelp;

public class Bianhao {
 
public String aoto(String num){
     char[] c = num.toCharArray();
     String str1 = String.valueOf(c[0]);
     String str2 = String.valueOf(c[1]);
     String str3 = String.valueOf(c[2]);
     String str4 = String.valueOf(c[3]);
     String str5 = String.valueOf(c[4]);
     String str6 = String.valueOf(c[5]);
	 int n1 = Integer.parseInt(str2);
	 int n2 = Integer.parseInt(str3);
	 int n3 = Integer.parseInt(str4);
	 int n4 = Integer.parseInt(str5);
	 int n5 = Integer.parseInt(str6);
	 n5++;
	 if(n5 == 10){
	 n5=0;
	 n4++;
	 }
	 if(n4 == 10){
	 n4=0;
	 n3++;
	 }
	 if(n3 == 10){
     n3=0;
     n2++;
	 }
	 if(n2 == 10){
	 n2=0;
	 n1++;
	 }
	 StringBuffer a = new StringBuffer();
	 a.append(str1);
	 a.append(n1); 
	 a.append(n2); 
	 a.append(n3); 
	 a.append(n4); 
	 a.append(n5); 
	return a.toString();}

public String autow(String num)
{
	  char[] c = num.toCharArray();	
	  String str1 = String.valueOf(c[0]);
	  String str2 = String.valueOf(c[1]);
	  String str3 = String.valueOf(c[2]);
	  int num4 = c[3];
	  String str5 = String.valueOf(c[4]);
	  String str6 = String.valueOf(c[5]);
	  String str7 = String.valueOf(c[6]);
	  String str8 = String.valueOf(c[7]);
	  String str9 = String.valueOf(c[8]);
	  String str10 = String.valueOf(c[9]);
	  int n1 = Integer.parseInt(str5);
	  int n2 = Integer.parseInt(str6);
	  int n3 = Integer.parseInt(str7);
	  int n4 = Integer.parseInt(str8);
	  int n5 = Integer.parseInt(str9);
	  int n6 = Integer.parseInt(str10);
	  n6++;
	  if(n6 == 10){
	  n6 = 0;
	  n5++;
	  }
	  if(n5 == 10){
	  n5 = 0 ;
	  n4++;
	  }
	  if(n4 == 10){
	  n4 = 0;
	  n3++;
	  }
	  if(n3 == 10){
	  n3 = 0;	  
	  n2++;	  
	  }
	  if(n2 == 10)
	  {
	  n2 = 0;
	  n1++;
	  }
	  if(n1 == 10)
	  {
	  n1 = 0;
	  num4++;
	  }
	  char char4 = (char)num4;
	  String str4 = String.valueOf(char4);
	  StringBuffer a = new StringBuffer();
	  a.append(str1);
	  a.append(str2);
	  a.append(str3);
	  a.append(str4);
	  a.append(n1);
	  a.append(n2);
	  a.append(n3);
	  a.append(n4);
	  a.append(n5);
	  a.append(n6);
	  return a.toString();
	  
}
}
