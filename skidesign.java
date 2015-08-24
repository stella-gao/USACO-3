/*
 ID: Benson.2
 LANG: JAVA
 TASK: skidesign
 */
import java.util.*;
import java.io.*;

public class skidesign
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("skidesign.in"));
   // Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("skidesign.out"));
    int hills=s.nextInt();
    int [] hillcount=new int[101];
    for (int x=0;x<hills;x++)
    {
      hillcount[s.nextInt()]++;
    }
    int minsum=10000000; 
    for (int y=0;y<84;y++)
    {
      int sum=0; 
      for (int x=0;x<101;x++)
      {
        if (x<y)
          sum+=(hillcount[x]*(y-x)*(y-x));
        else if (x>y+17)
          sum+=(hillcount[x]*(x-y-17)*(x-y-17));
          else continue;
      }
      if (sum<minsum)minsum=sum;
    }
    System.out.println (minsum);
    out.println (minsum);
    out.close();
  }
}