/*
 ID: Benson.2
 LANG: JAVA
 TASK: milk3
 */
import java.util.*;
import java.io.*;

public class milk3
{
  static ArrayList<String>states=new ArrayList<String>();
  static ArrayList<Integer>solutions=new ArrayList<Integer>();
    static int maxA;
  static int maxB;
  static int maxC;
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
     Scanner s=new Scanner (new File ("milk3.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("milk3.out"));
    int a=s.nextInt();
    int b=s.nextInt();
    int c=s.nextInt();
    maxA=a;
    maxB=b;
    maxC=c;
    recurse(0,0,c);
    Collections.sort(solutions);
    for (int x=0;x<solutions.size();x++)
    {
      if (x==solutions.size()-1)     
      { out.println (solutions.get(x));
        break;}
      System.out.print (solutions.get(x)+" ");
      out.print (solutions.get(x)+" ");
    }
    out.close();
  }
  public static void recurse (int a, int b, int c)
  {
    int temp=0;
    if (stateChecked(a,b,c))return;
      //  System.out.println(a+" "+b+" "+c);
    states.add(a+" "+b+" "+c);
    if (a==0)addSol(c);
    //a-b
    temp=Math.min (maxB-b,a);
    recurse (a-temp,b+temp,c);
    //a-c
    temp=Math.min (maxC-c,a);
    recurse (a-temp,b,c+temp);
    //b-a
    temp=Math.min (maxA-a,b);
    recurse (a+temp,b-temp,c);
    //b-c
    temp=Math.min (maxC-c,b);
    recurse (a,b-temp,c+temp);
    //c-a
    temp=Math.min (maxA-a,c);
    recurse (a+temp,b,c-temp);
    //c-b
    temp=Math.min (maxB-b,c);
    recurse (a,b+temp,c-temp);
  }
  public static boolean stateChecked (int a,int b,int c)
  {
    String current=a+" "+b+" "+c;
    for (int x=0;x<states.size();x++)
    {
      if (current.equals(states.get(x)))
        return true;
    }
    return false;
  }
  public static void addSol(int c)
  {
    for (int x=0;x<solutions.size();x++)
    {
      if (c==solutions.get(x))return;
    }
    solutions.add(c);
  }
  
}