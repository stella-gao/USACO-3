/*
 ID: Benson.2
 LANG: JAVA
 TASK: pprime 
 */

import java.util.*;
import java.io.*;

public class pprime
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("pprime.in"));
   //Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("pprime.out"));
    
    int a=s.nextInt();
    int b=s.nextInt();
    boolean []prime=new boolean[Math.min(10000001,b+1)];
    Arrays.fill (prime,true);
    for (int x=2;x<Math.sqrt(b);x++)
    {
      if (prime[x]==false)continue;
      int start=0;
      start=Math.max((a/x)*x,x*x);
      while (start<b+1&&start<10000000)
      {
        prime[start]=false;
        start+=x;
      }
    }
    for (int x=a;x<Math.min(b+1,10000000);x++)
    {
      if (prime[x]&&checkPal(""+x))
      {        out.println (x);
        System.out.println (x);
      }
    }
    int test=0;
    if (b>10000000)
    {
      for (int w=1;w<10;w+=2)
      {
        for (int x=0;x<10;x++)
        {
          for (int y=0;y<10;y++)
          {
            for (int z=0;z<10;z++)
            {
              test=w*10000001+x*1000010+y*100100+z*11000;
              if (test>b)break;
              if (isPrime(test))
                  {out.println (test);
        System.out.println (test);
                  }
            }
            if (test>b)break;
          }
          if (test>b)break;
        }
        if (test>b)break;
      }
      
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
  public static boolean isPrime(int i)
  {
    if (i%2==0)return false;
    for (int x=3;x<=Math.sqrt(i);x+=2)
    {
      if (i%x==0)return false;
    }
    return true;
  }
}