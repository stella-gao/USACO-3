/*
 ID: Benson.2
 LANG: JAVA
 TASK: barn1
 */
import java.util.*;
import java.io.*;

public class barn1
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("barn1.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("barn1.out"));
    
    int board=s.nextInt();
    int n=s.nextInt();
    int cows=s.nextInt();
    boolean []occupied=new boolean[n];
    Arrays.fill(occupied,false);
    boolean [] block=new boolean[n];
    Arrays.fill(block,false);
    for (int x=0;x<cows;x++)
    {
      occupied[s.nextInt()-1]=true;
    }
    int startIndex=0;
    int endIndex=n-1;
    while (occupied[startIndex]==false)
      startIndex++;
    while (occupied[endIndex]==false)
      endIndex--;
    for (int x=0;x<board;x++)
    {
      if (x==0)
      {
        for (int y=startIndex;y<endIndex+1;y++)
          block[y]=true;
      }
      else
      {
        int split=returnBiggest(occupied ,block);
       // System.out.println (split);
        if (split==-1)break;
        while (occupied[split]==false)
        {
          block[split]=false;
          split++;
        }
      }
    }
    int count=0;
    for (int x=0;x<n;x++)
    {
      if (block[x]==true)count++;
    }
    out.println (count);
    out.close();
  }
  
  public static int returnBiggest (boolean[] occ, boolean[] block)
  {
    int index=0;
    int space=0;
    int maxspace=0;
    int tempans=0;
    int ans=0;
    while (index<occ.length)
    {
      space=0;
      while (index<occ.length&&occ[index]==false)
        index++;
      index++;
      tempans=index;
      while (index<occ.length&&occ[index]==false&&block[index]==true)
      {
        space++;
        index++;
        if (index==block.length)
        {
          space=-1;
          break;
        }
      }
      if (space>maxspace)
      {
        ans=tempans;
        maxspace=space;
      }
    }
    if (maxspace==0)
      return -1;
    return ans;
  }
}