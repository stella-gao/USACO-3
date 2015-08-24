/*
 ID: Benson.2
 LANG: JAVA
 TASK: ttwo
 */
import java.util.*;
import java.io.*;

public class ttwo
{
  //0,1,2,3 n,e,s,w
  static int fx=0;
  static int fy=0;
  static int fd=0;
  static int cx=0;
  static int cy=0;
  static int cd=0;
  static int count=0;
  
  static int ofx=0;
  static int ofy=0;
  static int ocx=0;
  static int ocy=0;
  static ArrayList<String>fvisited=new ArrayList<String>();
  static ArrayList<String>cvisited=new ArrayList<String>();
  static boolean cyclef=false;
  static boolean cyclec=false;
  static boolean checked=false;
  
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("ttwo.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("ttwo.out"));
    char grid[][]=new char[10][10];
    for (int y=0;y<10;y++)
    {
      grid[y]=s.nextLine().toCharArray();
    }
    for (int y=0;y<10;y++)
    {
      for (int x=0;x<10;x++)
      {
        if (grid[y][x]=='F')
        {
          fy=y;
          fx=x;
          ofy=y;
          ofx=x;
        }
        if (grid[y][x]=='C')
        {
          cy=y;
          cx=x;
          ocy=y;
          ocx=x;
        }
      }
    }
    while (!meet()&&!check())
    {
//      if (!cvisited.contains(""+cy+cx))
//        cvisited.add (""+cy+cx);
//      if (!fvisited.contains(""+fy+fx))
//        cvisited.add (""+fy+fx);
      sim (grid);
      if (count>10000)
      {
        count=0;
        break;
      }
    }
    if (check())
      out.println (0);
    else
      out.println (count);
    
//        for (int y=0;y<10;y++)
//    {
//      for (int x=0;x<10;x++)
//      {
//        System.out.print (grid[y][x]);
//      }
//      System.out.println ();
//    }
    
    out.close();
    s.close();
  }
  
  public static void sim(char[][]arr)
  {
    if (fd==0)
    {
      if (fy>0&&arr[fy-1][fx]!='*')
      {
        arr[fy-1][fx]='F';
        arr[fy][fx]='.';  
        fy--;
      }
      else 
        turn (true);
    }
    else if (fd==1)
    {
      if (fx<9&&arr[fy][fx+1]!='*')
      {
        arr[fy][fx+1]='F';
        arr[fy][fx]='.';  
        fx++;
      }
      else 
        turn (true);
    }
    else if (fd==2)
    {
      if (fy<9&&arr[fy+1][fx]!='*')
      {
        arr[fy+1][fx]='F';
        arr[fy][fx]='.';  
        fy++;
      }
      else 
        turn (true);
    }
    else
    {
      if (fx>0&&arr[fy][fx-1]!='*')
      {
        arr[fy][fx-1]='F';
        arr[fy][fx]='.';  
        fx--;
      }
      else 
        turn (true);
    }
    
    if (cd==0)
    {
      if (cy>0&&arr[cy-1][cx]!='*')
      {
        arr[cy-1][cx]='C';
        arr[cy][cx]='.';  
        cy--;
      }
      else 
        turn (false);
    }
    else if (cd==1)
    {
      if (cx<9&&arr[cy][cx+1]!='*')
      {
        arr[cy][cx+1]='C';
        arr[cy][cx]='.';  
        cx++;
      }
      else 
        turn (false);
    }
    else if (cd==2)
    {
      if (cy<9&&arr[cy+1][cx]!='*')
      {
        arr[cy+1][cx]='C';
        arr[cy][cx]='.';  
        cy++;
      }
      else 
        turn (false);
    }
    else
    {
      if (cx>0&&arr[cy][cx-1]!='*')
      {
        arr[cy][cx-1]='C';
        arr[cy][cx]='.';  
        cx--;
      }
      else 
        turn (false);
    }
    count++;
  }
  
  public static boolean check ()
  {
    if (fx==ofx&&fy==ofy&&fd==0)
      cyclef=true;
    if (cx==ocx&&cy==ocy&&cd==0)
      cyclec=true;
    if (fx==ofx&&fy==ofy&&fd==0&&cx==ocx&&cy==ocy&&cd==0&&count>0)
    {
      return true;
    }
    return false;
  }
  
  public static boolean contains()
  {
    if (!checked&&cyclef&&cyclec)
    {
      for (int x=0;x<fvisited.size();x++)
      {
        checked=true;
        if (cvisited.contains (fvisited.get(x)))
          return true;
      }
      return false;
    }
    return true;
  }
  
  public static boolean meet()
  {
    if (fx==cx&&fy==cy)
      return true;
    
    return false;
  }
  
  public static void turn (boolean farmer)
  {
    if (farmer)
      fd=(fd+1)%4;
    else 
      cd=(cd+1)%4;
  }
}