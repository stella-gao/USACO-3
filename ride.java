/*
ID: Benson.2
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("ride.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("ride.out"));
    String word1=s.nextLine();
    String word2=s.nextLine();
    int product1=1;
    int product2=1;
    for (int x=0;x<word1.length();x++)
    {
      product1*=(Character.getNumericValue(word1.charAt(x))-9);
      product1=product1%47;
    }
        for (int x=0;x<word2.length();x++)
    {
      product2*=(Character.getNumericValue(word2.charAt(x))-9);
      product2=product2%47;
    }
     if (product1==product2)out.println ("GO");
     else out.println ("STAY");
    out.close();
  }
}