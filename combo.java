/*
 ID: Benson.2
 LANG: JAVA
 TASK: combo
 */
import java.util.*;
import java.io.*;

public class combo
{
  public static int x1;
  public static int y1;
  public static int z1;
  public static int x2;
  public static int y2;
  public static int z2;
  public static int n;
  static ArrayList<String>valid;
  static ArrayList<String>visited;
  
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("combo.in"));
    // Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("combo.out"));
    n=s.nextInt();
    x1=s.nextInt();
    y1=s.nextInt();
    z1=s.nextInt();
    x2=s.nextInt();
    y2=s.nextInt();
    z2=s.nextInt();
    valid=new ArrayList<String>();
    visited=new ArrayList<String>();
    recurse(x1,y1,z1);
    recurse(x2,y2,z2);
    out.println (valid.size());
     System.out.println (valid.size());
    out.close();
  }
  
  public static void recurse(int a,int b,int c)
  {
    if (a==0)a=n;
    if (b==0)b=n;
    if (c==0)c=n;
        if (a==n+1)a=1;
    if (b==n+1)b=1;
    if (c==n+1)c=1;
    if (visited.contains(a+" "+b+" "+c))return;
    visited.add (a+" "+b+" "+c);
    if (close(a,x1)&&close(b,y1)&&close(c,z1))
    {
      if (!valid.contains(a+" "+b+" "+c))
        valid.add(a+" "+b+" "+c);
          recurse(a,b,c+1);
    recurse(a,b,c-1);
    
    recurse(a,b+1,c);
    recurse(a,b-1,c);
    
    
    recurse(a+1,b,c);
    recurse(a-1,b,c);
    }
    else if (close(a,x2)&&close(b,y2)&&close(c,z2))
    {
      if (!valid.contains(a+" "+b+" "+c))
        valid.add(a+" "+b+" "+c);
          recurse(a,b,c+1);
    recurse(a,b,c-1);
    
    recurse(a,b+1,c);
    recurse(a,b-1,c);
    
    
    recurse(a+1,b,c);
    recurse(a-1,b,c);
    }
    else return;

  }
  
  public static boolean close(int a,int b)
  {
    int temp=a;
    if (a==b)return true;
    for (int x=0;x<2;x++)
    {
      a++;
      if (a>n)a=1;
      if (a==b)return true;
    }
    for (int x=0;x<2;x++)
    {
      temp--;
      if (temp<1)temp=n;
      if (temp==b)return true;
    }
    return false;
  }
}