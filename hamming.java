/*
 ID: Benson.2
 LANG: JAVA
 TASK: hamming
 */

import java.util.*;
import java.io.*;

public class hamming
{
  
  static int d;
  public static void main (String[]args) throws IOException
  {
    Scanner s=new Scanner(new File("hamming.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("hamming.out"));
    
    int n=s.nextInt();
    int b=s.nextInt();
    d=s.nextInt();
    
    ArrayList<String> codes=new ArrayList<String>();
    boolean used []=new boolean[(int)Math.pow(2,b+1)];
    Arrays.fill (used,false);
    int count=0;
    String next;
    while (codes.size()<n)
    {
      if (!used[count])
      {
        used[count]=true;
        next=convert(Integer.toBinaryString(count),b);
        if (check(next,codes))
          codes.add(next);
      }
      count++;
    }
    for (int x=0;x<codes.size();x++)
    {
      if (x%10==9)
        out.println (Integer.parseInt(codes.get(x),2));
      else
      {
        out.print (Integer.parseInt(codes.get(x),2));
        if (x%10!=9&&x!=codes.size()-1)
          out.print (" ");
      }
    }
    if (codes.size()%10!=0)
    out.println();
    out.close();
  }
  public static String convert (String s, int b)
  {
    while (s.length()<b)
    {
      s="0"+s;
    }
    return s;
  }
  
  public static boolean check(String s,ArrayList<String> arr)
  {
    int dif=0;
    for (int x=0;x<arr.size();x++)
    {
      dif=0;
      for (int y=0;y<arr.get(0).length();y++)
      {
        if (!s.substring(y,y+1).equals(arr.get(x).substring(y,y+1)))
          dif++;
      }
      if (dif<d)return false;
    }
    return true;
  }
}