/*
 ID: Benson.2
 LANG: JAVA
 TASK: dualpal
 */

import java.util.*;
import java.io.*;

public class dualpal
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("dualpal.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("dualpal.out"));
    
    int count=s.nextInt();
    int num=s.nextInt()+1;
    int current=0;
    while (current<count)
    {
      int bases=0;
      for (int x=2;x<11;x++)
      {
      if (checkPal(Integer.toString(num,x)))
            bases++;
      if (bases==2)
      {
        out.println (num);
        current++;
        break;
      }
      }
      num++;
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