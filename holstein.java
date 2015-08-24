/*
 ID: Benson.2
 LANG: JAVA
 TASK: holstein
 */
import java.util.*;
import java.io.*;

public class holstein
{
  static int v;
  static int g;
  static int req[];
  static ArrayList<int[]>feeds;
  static int minFeedNum;
  static ArrayList<boolean[]>answers;
  
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("holstein.in"));
    //Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("holstein.out"));
    v=s.nextInt();
    req=new int[v];
    feeds=new ArrayList<int[]>();
    answers=new ArrayList<boolean[]>();
    for (int x=0;x<v;x++)
    {
      req[x]=s.nextInt();
    }
    g=s.nextInt();
    minFeedNum=g+1;
    for (int x=0;x<g;x++)
    {
      int[]  temp=new int[v];
      for (int y=0;y<v;y++)
      {
        temp[y]=s.nextInt();
      }
      feeds.add (temp);
    }
    
    
    int[]  temp=new int[v];
    Arrays.fill (temp,0);
    boolean[]tempB=new boolean[g];
    Arrays.fill (tempB,false);
    recurse(temp,tempB,0,-1, false);
    System.out.print (minFeedNum);
    out.print (minFeedNum);
    for (int y=0;y<answers.size();y++)
    {
      if (count(answers.get(y))==minFeedNum)
      {
        for (int x=0;x<g;x++)
        {
          if (answers.get(y) [x]){
            System.out.print (" "+(x+1));
            out.print (" "+(x+1));
          }
        }
        System.out.println();
        out.println();
        break;
      }
    }
    out.close();
  }
  public static void recurse (int[]vals,boolean[]feedUsed,int numFeed, int currentFeed, boolean add)
  {
    if (currentFeed>=g||numFeed>=minFeedNum)
    {
      //System.out.println ("trace"+" "+currentFeed+" "+numFeed+" "+g);
      return;
    }
    if (add)
    {
      //  System.out.println ("trace"+" "+currentFeed+" "+numFeed+" "+vals.length);
      vals=updateVal (vals,currentFeed); 
      feedUsed[currentFeed]=true;
      numFeed++;
      if (metReq(vals))
      {
        // System.out.println ("trace "+numFeed+" "+currentFeed);
//        for (int x=0;x<v;x++)
//        {
//          System.out.print (vals[x]+" ");
//        }
//        for (int x=0;x<g;x++)
//        {
//          System.out.print (feedUsed[x]+" ");
//        }
        System.out.println ();
        answers.add (feedUsed);
        if (numFeed<minFeedNum)
          minFeedNum=numFeed;
        return;
      }
    }
    currentFeed++;
    int[]newVals=new int[v];
    System.arraycopy (vals,0,newVals,0,v);
    boolean[]newFeedUsed=new boolean[g];
    System.arraycopy (feedUsed,0,newFeedUsed,0,g);
    recurse(newVals,newFeedUsed,numFeed,currentFeed,true);
    int[]newVals2=new int[v];
    System.arraycopy (vals,0,newVals2,0,v);
    boolean[]newFeedUsed2=new boolean[g];
    System.arraycopy (feedUsed,0,newFeedUsed2,0,g);
    recurse(newVals2,newFeedUsed2,numFeed,currentFeed,false);
    // System.out.println ("trace");
  }
  public static boolean metReq(int[] vals)
  {
    for (int x=0;x<v;x++)
    {
      if (vals[x]<req[x])return false;
    }
    return true;
  }
  public static int[] updateVal(int[] vals, int newFeed)
  {
    for (int x=0;x<v;x++)
    {
      vals[x]+=feeds.get(newFeed)[x];
    }
    return vals;
  }
  public static int count (boolean[] arr)
  {
    int count=0;
    for (int x=0;x<arr.length;x++)
    {
      if (arr[x])count++;
    }
    return count;
  }
}
