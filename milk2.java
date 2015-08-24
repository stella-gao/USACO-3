/*
ID: Benson.2
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

public class milk2
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("milk2.in"));
    PrintWriter out=new PrintWriter (new FileWriter("milk2.out"));
    
    int farmer=s.nextInt();
    int last=0;
    int first=1000000;
    int longMilk=0;
    int longIdle=0;
    boolean[]seconds=new boolean[1000000];
    for (int x=0;x<farmer;x++)
    {
      int start=s.nextInt();
      if (start<first)first=start;
      int end=s.nextInt();
      if (end>last)last=end;
      int dur=end-start;
      for (int y=start;y<start+dur;y++)
      {
        seconds[y]=true;
      }
    }
    for (int x=first;x<last;x++)
    {
      boolean state=seconds[x];
      int milk=0;
      int idle=0;
      if (state)
      {milk++;
        x++;
        while (seconds[x])
        {
          milk++;
          x++;
        }
        if (milk>longMilk)longMilk=milk;
      }
      else 
      {idle++;
        x++;
        while (!seconds[x])
        {
          idle++;
            x++;
        }
        if (idle>longIdle)longIdle=idle;
      }
      if (x<last)
      x--;
    }
     out.println (longMilk+" "+longIdle);
     out.close();
  }
}