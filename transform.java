/*
 ID: Benson.2
 LANG: JAVA
 TASK: transform
 */
import java.io.*;
import java.util.*;

public class transform
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("transform.in"));
    PrintWriter out=new PrintWriter (new FileWriter("transform.out"));
    
    int n=s.nextInt();
    char[][]a=new char[n][n];
    char[][]b=new char[n][n];
    for (int y=0;y<n;y++)
    {
      a[y]=s.next().toCharArray();
    }
    for (int y=0;y<n;y++)
    {
      b[y]=s.next().toCharArray();
    }
    
    if (check(rot90(a,n),b,n))
      out.println (1);
    else if (check(rot180(a,n),b,n))
      out.println (2);
    else if (check(rot270(a,n),b,n))
      out.println (3);
    else if (check(reflect(a,n),b,n))
      out.println (4);
    else if (check(combo90(a,n),b,n))
      out.println (5);
    else if (check(combo180(a,n),b,n))
      out.println (5);
    else if (check(combo270(a,n),b,n))
      out.println (5);
    else if (check(a,b,n))
      out.println (6);
    else
      out.println (7);
    
    
    
    out.close();
    
  }
  
  public static char[][] rot90 (char[][]arr,int n)
  {
    char[][] change=new char[n][n];
    for (int y=0;y<n;y++)
    {
      for (int x=0;x<n;x++)
      {
        change[y][x]=arr[n-1-x][y];
      }
    }
    return change;
  }
  
  public static char[][] rot180 (char[][]arr,int n)
  {
    char[][] change=rot90(arr,n);
    change=rot90(change,n);
    return change;
  }
  
  public static char[][] rot270 (char[][]arr,int n)
  {
    char[][] change=rot90(arr,n);
    change=rot90(change,n);
    change=rot90(change,n);
    return change;
  }
  
  public static char[][] reflect (char[][]arr,int n)
  {
    char[][] change=new char[n][n];
    for (int y=0;y<n;y++)
    {
      for (int x=0;x<n;x++)
      {
        change[y][x]=arr[y][n-1-x];
      }
    }
    return change;
  }
  
  public static char[][] combo90 (char[][]arr,int n)
  {
    char[][] change=reflect(arr,n);
    change=rot90(change,n);
    return change;
  }
  
  public static char[][] combo180 (char[][]arr,int n)
  {
    char[][] change=reflect(arr,n);
    change=rot90(change,n);
    change=rot90(change,n);
    return change;
  }
  
  public static char[][] combo270 (char[][]arr,int n)
  {
    char[][] change=reflect(arr,n);
    change=rot90(change,n);
    change=rot90(change,n);
    change=rot90(change,n);
    return change;
  }
  
  public static boolean check (char[][]a,char[][]b,int n)
  {
    for (int y=0;y<n;y++)
    {
      for (int x=0;x<n;x++)
      {
        if (a[y][x]!=b[y][x])
          return false;
      }
    }
    return true;
  }
}