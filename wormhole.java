/*
 ID: Benson.2
 LANG: JAVA
 TASK: wormhole
 */
import java.util.*;
import java.io.*;

public class wormhole 
{
  static ArrayList<int[]>coord;
  static ArrayList<int[]>solutions=new ArrayList<int[]>();
  static int[] connect;
  static int n;
  static int count=0;
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("wormhole.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("wormhole.out"));
    n=s.nextInt();
    coord=new ArrayList<int[]>();
    connect=new int[n];
    Arrays.fill(connect,-1);
    //set up coordinates
    for (int x=0;x<n;x++)
    {
      coord.add (new int[]{s.nextInt(),s.nextInt()});
    }
    //find next hole in path
    for (int x=0;x<n;x++)
    {
      int next=-1;
      for (int y=0;y<n;y++)
      {
        if (x==y)continue;
        if (coord.get(x)[1]==coord.get(y)[1]&&coord.get(x)[0]<coord.get(y)[0])
        {
          if (next==-1)
            next=y;
          else
          {
            if (coord.get(y)[0]<coord.get(next)[0])
              next=y;
          }
        }
      }
      connect[x]=next;
    }
    
    //generate all possible pairs
//    if (n==2)
//    {
//      if (check(new int[]{1,0}))count++;
//    }
//    else if (n==4)
//    {
//      if (check(new int[]{3,2,1,0}))count++;
//      if (check(new int[]{1,0,3,2}))count++;
//      if (check(new int[]{2,3,0,1}))count++;
//    }
//    else if (n==6)
//    {
//    }
//    else if (n==8)
//    {
//    }
//    else if (n==10)
//    {
//    }
//    else
//    {
      int[]pairs=new int[n];
      Arrays.fill (pairs,-1);
      combo (pairs);
//    }
    
    System.out.println (count);
    out.println (count);
    out.close();
  }
  
  public static boolean check(int [] pair)
  {
    int nextHole=0;
    for (int x=0;x<n;x++)
    {
      nextHole=x;
      while (true)
      {
        nextHole=connect[nextHole];
        if (nextHole==-1)
          break;
        else
          nextHole=pair[nextHole];
        if (nextHole==x)return true;
      }
    }
    return false;
  }
  
  public static boolean isNew(int [] arr)
  {
    for (int x=0;x<solutions.size();x++)
    {
      for (int y=0;y<n;y++)
      {
        if (arr[y]!=solutions.get(x)[y])break;
        if (y==n-1)return false;
      }
    }
    return true;
  }
  
  public static void combo (int[]pairs)
  {
    if (paired(pairs))
    {
      if (check(pairs)&&isNew (pairs))
      {
        solutions.add (pairs);
        count++;
      }
    }
    else
    {
      ArrayList<Integer>empty=new ArrayList<Integer>();
      for (int x=0;x<pairs.length;x++)
      {
        if (pairs[x]==-1)empty.add(x);
      }
      for (int x=1;x<empty.size();x++)
      {
        int []newpairs=new int[pairs.length];
        System.arraycopy( pairs, 0, newpairs, 0, pairs.length );
        newpairs[empty.get(0)]=empty.get(x);
        newpairs[empty.get(x)]=empty.get(0);
        combo(newpairs);
      }
      
    }
  }
  
  
  public static boolean paired(int []pair)
  {
    for (int x=0;x<pair.length;x++)
    {
      if (pair[x]==-1)return false;
    }
    return true;
  }
}