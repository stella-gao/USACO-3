/*
 ID: Benson.2
 LANG: JAVA
 TASK: palsquare
 */

import java.util.*;
import java.io.*;

public class palsquare
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("palsquare.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("palsquare.out"));
    
    int base=s.nextInt();
    for (int x=1;x<301;x++)
    {
      if (checkPal(Integer.toString((int)Math.pow(x,2),base)))
            out.println (Integer.toString(x,base).toUpperCase() +" "+Integer.toString((int)Math.pow(x,2),base).toUpperCase());
    }
    out.close();
  }
  
  public static boolean checkPal (String test)
  {
    for (int x=0;x<test.length()/2;x++)
    {
      if (test.charAt(x)!=test.charAt(test.length()-1-x))
        return false;
    }
    return true;
  }
}