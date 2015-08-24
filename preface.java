/*
 ID: Benson.2
 LANG: JAVA
 TASK: preface
 */

import java.util.*;
import java.io.*;

public class preface
{
  
  static int d;
  public static void main (String[]args) throws IOException
  {
    //Scanner s=new Scanner(System.in);
    Scanner s=new Scanner(new File("preface.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("preface.out"));
    int n=s.nextInt();
    //I,V,X,L,C,D,M
    int [] total =new int [7];
    int [] current =new int [7];
    Arrays.fill (total,0);
    for (int x=0;x<=n;x++)
    {
      Arrays.fill (current,0);
      int next =x;
      while (next>0)
      {
        next-=sub(next, current,total);
      }
      for (int y=0;y<7;y++)
      {
        total[y]+=current[y];
      }
    }
    
    if (total [0]>0)
      out.println ("I "+total [0]);
    if (total [1]>0)
      out.println ("V "+total [1]);
    if (total [2]>0)
      out.println ("X "+total [2]);
    if (total [3]>0)
      out.println ("L "+total [3]);
    if (total [4]>0)
      out.println ("C "+total [4]);
    if (total [5]>0)
      out.println ("D "+total [5]);
    if (total [6]>0)
      out.println ("M "+total [6]);
    
    out.close();
  }
  
  public static int sub(int num,int []current, int []total)
  {
    if (num>=900&&num<1000)
    {
      total[4]++;
      total [6] ++;
      return 900;
    }
    if (num>=400&&num<500)
    {
      total[4]++;
      total [5] ++;
      return 400;
    }
    if (num>=90&&num<100)
    {
      total[2]++;
      total [4] ++;
      return 90;
    }
    if (num>=40&&num<50)
    {
      total[2]++;
      total [3] ++;
      return 40;
    }
    if (num>=9&&num<10)
    {
      total[0]++;
      total [2] ++;
      return 9;
    }
    if (num>=4&&num<5)
    {
      total[0]++;
      total [1] ++;
      return 4;
    }
    if (num>=1000&&current[6]<3)
    {
      current [6]++;
      return 1000;
    }
    else if (num>=500&&current[5]<1)
    {
      current [5]++;
      return 500;
    }
    else if (num>=100&&current[4]<3)
    {
      current [4]++;
      return 100;
    }
    else if (num>=50&&current[3]<1)
    {
      current [3]++;
      return 50;
    }
    else if (num>=10&&current[2]<3)
    {
      current [2]++;
      return 10;
    }
    else if (num>=5&&current[1]<1)
    {
      current [1]++;
      return 5;
    }
    else 
    {
      current [0]++;
      return 1;
    }
  }
}