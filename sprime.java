/*
 ID: Benson.2
 LANG: JAVA
 TASK: sprime 
 */

import java.util.*;
import java.io.*;

public class sprime
{
  static int n;
 static ArrayList<Integer> isRib=new ArrayList<Integer>();
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("sprime.in"));
  // Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("sprime.out"));
    
    n=s.nextInt();
    System.out.println (n);
    recurse ("2");
    recurse("3");
    recurse("5");
    recurse("7");
    Collections.sort(isRib);
    for (int x=0;x<isRib.size();x++)
    {
        out.println (isRib.get(x));
    }
    out.close();
  }
  
  public static void recurse (String num)
  {
 //   System.out.println (num+" "+isPrime(Integer.parseInt(num))+" "+num.length()+" "+n);
    if (num.length()>n||!isPrime(Integer.parseInt(num)))return;
  //  System.out.println ("pass");
    if (num.length()==n)isRib.add (Integer.parseInt(num));
    recurse (num+"1");
    recurse (num+"3");
    recurse (num+"5");
    recurse (num+"7");
    recurse (num+"9");
  }

  public static boolean isPrime(int i)
  {
    if (i==2)return true;
    if (i%2==0)return false;
    for (int x=3;x<=Math.sqrt(i);x+=2)
    {
      if (i%x==0)return false;
    }
    return true;
  }
}