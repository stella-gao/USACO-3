/*
 ID: Benson.2
 LANG: JAVA
 TASK: runround
 */

import java.util.*;
import java.io.*;


public class runround
{
  public static void main (String[]args) throws IOException
  {
 //  Scanner s=new Scanner(System.in);
    Scanner s=new Scanner(new File("runround.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("runround.out"));
    long n=s.nextInt();
    while (true)
    {
      boolean first=true;
      n++;
      if (!distinct(n))continue;
      String next=Long.toString (n);
      int index=0;
      boolean[] visited=new boolean[next.length()]; 
      Arrays.fill (visited, false);
      while (true)
      {
        if (visited[index])break;
        else
        {
          if (!first)
          visited [index]=true;
          index=(index+Integer.parseInt(next.substring(index,index+1)))%next.length();
          first=false;
        }
      }
      if (check (visited))
      {
        break;
      }
      
    }
    out.println (n);
        //System.out.println (distinct(114));
   out.close();
  }
  
  public static boolean check (boolean []arr)
  {
    for (int x=0;x<arr.length;x++)
    {
      if (arr[x]==false)
        return false;
    }
    return true;
  }
  
  public static boolean distinct (long num)
  {
    boolean [] used=new boolean [10];
    Arrays.fill (used,false);
    int loop=(int)Math.log10(num);
    for (int x=0;x<=loop;x++)
    {
      if (!used[(int)num%10])
      {
        used[(int)num%10]=true;
        num/=10;
      }
        else
      {
        return false;
      }
    }
    return true;
  }
}