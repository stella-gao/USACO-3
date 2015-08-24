/*
 ID: Benson.2
 LANG: JAVA
 TASK: money
 */
import java.util.*;
import java.io.*;

public class money
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner ((System.in));
    //Scanner s=new Scanner (new File ("money.in"));
    //PrintWriter out=new PrintWriter(new FileWriter ("money.out"));
    int v=s.nextInt();
    int []monies=new int[v];
    int n=s.nextInt();
    
    for (int x=0;x<v;x++)
    {
      monies[x]=s.nextInt();
    }
    long [][]ways=new long[n+1][v+1];
    for (int x=0;x<n+1;x++)
      Arrays.fill (ways[x],0);
    for (int x=0;x<v+1;x++)
      ways[0][x]=1;
    //money,ways
    for (int x=1;x<n+1;x++)
    {
      for (int y=1;y<v+1;y++)
      {
        ways[x][y]+=ways[x][y-1];
        int coin=monies[y-1];
        if (x-coin>=0)
        {
          ways[x][y]+=ways[x-coin][y];
        }
      }
    }
    System.out.println (ways[n][v]);
    for (int x=0;x<n+1;x++)
    {
      for (int y=0;y<v+1;y++)
      {
        System.out.print (ways[x][y]+" ");
      }
      System.out.println ();
    }
//    
     //out.close();
  }
}