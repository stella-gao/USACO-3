/*
 ID: Benson.2
 LANG: JAVA
 TASK: ariprog
 */
import java.util.*;
import java.io.*;

public class ariprog
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("ariprog.in"));
   //   Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("ariprog.out"));
    int count=0;
    int n=s.nextInt();
    int max=s.nextInt();
    int maxNum=2*max*max;
    boolean sequence;
    int[]table=new int[maxNum+1];
    Arrays.fill (table,0);
    for (int x=0;x<max+1;x++)
    {
      for (int y=0;y<max+1;y++)
      {
        table[x*x+y*y]=1;
      }
    }
    for (int x=1;x<(maxNum/(n-1)+1);x++)
    {
      for (int y=0;y<maxNum+1;y++)
      {
        if (table[y]==0)continue;
        sequence=true;
        for (int z=0;z<n;z++)
        {
          if ((y+x*z)>maxNum||table[y+x*z]==0)
          {
            sequence=false;
            break;
          }
        }
        if (sequence==true)
        {
          System.out.println (y+" "+x);
          out.println (y+" "+x);
          count++;
        }
      }
    }
    if (count==0)out.println ("NONE");
    out.close();
  }
}