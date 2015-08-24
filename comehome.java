/*
 ID: Benson.2
 LANG: JAVA
 TASK: comehome
 */
import java.util.*;
import java.io.*;

public class comehome
{
  static boolean[]visited;
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File("in.txt"));
    Scanner s=new Scanner (new File ("comehome.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("comehome.out"));
    
    int [][]connect=new int[52][52];
    for (int x=0;x<52;x++)
      Arrays.fill (connect[x],999899);
    int tt=s.nextInt();
    visited=new boolean[52];
    Arrays.fill (visited,true);
    for (int x=0;x<tt;x++)
    {
      int a=val (s.next().charAt(0));
      int b=val(s.next().charAt(0));
      int c=s.nextInt();
      if (connect[a][b]==0||c<connect[a][b])
      {
      connect[a][b]=c;
      connect[b][a]=c;
      }
    }
//    for (int y=0;y<26;y++)
//    {
//      for (int x=0;x<26;x++)
//      {
//        System.out.print (connect[y][x]+" ");
//      }
//      System.out.println ();
//    }
//    for (int x=0;x<26;x++)
//      System.out.println (contain[x]+" ");
    int count=0;
    for (int x=0;x<52;x++)
    {
      if (visited[x])
        count++;
    }
    
    while (count<52)
    {
      int min=999999;
      int index=0;
      for (int x=0;x<52;x++)
      {
        if (connect[51][x]<min&&!visited[x])
        {
          min =connect[51][x];
          index=x;
        }
      }
      visited[index]=true;
      count++;
      for (int x=0;x<52;x++)
      {
        connect[x][51]=Math.min(connect[51][x],connect[index][x]+connect[index][51]);
        connect[51][x]=connect[x][51];
      }
    }
//        for (int y=0;y<26;y++)
//    {
//      for (int x=0;x<26;x++)
//      {
//        System.out.print (connect[y][x]+" ");
//      }
//      System.out.println ();
//    }
    int min=999999;
    int index=0;
    for (int x=0;x<51;x++)
    {
      if (x>25&&connect[51][x]<min)
      {
        min=connect[51][x];
        index=x;
      }
    }
    System.out.println ((char)(index+39)+" "+min);
    out.println ((char)(index+39)+" "+min);
    s.close();
    out.close();
  }
  
  public static int val (char s)
  {
    if (s>93)
    {
      visited[s-97]=false;
      return (s-97);
    }
    else
    {
      visited[s-39]=false;
      return (s-39);
    }
  }
}