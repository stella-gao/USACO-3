/*
 ID: Benson.2
 LANG: JAVA
 TASK: concom
 */
import java.util.*;
import java.io.*;

public class concom
{
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("concom.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("concom.out"));
    int n=s.nextInt();
    int[]data=new int[3*n];
    int max=0;
    for (int x=0;x<3*n;x++)
    {
      data[x]=s.nextInt();
      if (x%3==0&&data[x]>max||x%3==1&&data[x]>max)
        max=data[x];
    }
    int[][]comp=new int [max+1][max+1];
    int [][]compB=new int [max+1][max+1];
    for (int x=0;x<n;x++)
    {
      comp[data[3*x]][data[3*x+1]]=data[3*x+2];
      compB[data[3*x]][data[3*x+1]]=data[3*x+2];
    }
    
        
//    for (int x=1;x<max+1;x++)
//    {
//      for (int y=1;y<max+1;y++)
//      {
//        System.out.print (comp[x][y]+" ");
//      }
//      System.out.println ();
//    }
    
    for (int x=1;x<max+1;x++)
    {
      boolean [] visited=new boolean [max+1];
      Arrays.fill (visited,false);
      Queue<Integer> toSee=new LinkedList<Integer>(); 
      for (int z=1;z<max+1;z++)
      {
        if (compB[x][z]>50)
        {
          toSee.add(z);
          visited[z]=true;
        }
      }
      while (toSee.size()>0)
      {
        int next=toSee.poll ();
        //System.out.println (x+" "+next);
        if (next==x)
          continue;
        else
        {
          for (int z=1;z<max+1;z++)
          {
            comp[x][z]+=compB[next][z];
            if (comp[x][z]>50&&!visited[z])
            {
              toSee.add(z);
              visited[z]=true;
            }
          }
          
        }
      }
    }
    
        for (int x=1;x<max+1;x++)
    {
      for (int y=1;y<max+1;y++)
      {
        if (x==y)continue;
        if (comp[x][y]>50)
        out.println (x+" "+y);
       // System.out.println (x+" "+y);
      }
    }
    
//    for (int x=1;x<max+1;x++)
//    {
//      for (int y=1;y<max+1;y++)
//      {
//        System.out.print (comp[x][y]+" ");
//      }
//      System.out.println ();
//    }
    out.close();
  }
}