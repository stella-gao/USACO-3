/*
 ID: Benson.2
 LANG: JAVA
 TASK: ariprog
 */
import java.util.*;
import java.io.*;

public class ariprog2
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("ariprog.in"));
    //  Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("ariprog.out"));
    int count=0;
    int n=s.nextInt();
    int max=s.nextInt();
    int maxNum=0;
    ArrayList<Integer> set=new ArrayList<Integer>();
    for (int x=0;x<max+1;x++)
    {
      for (int y=0;y<max+1;y++)
      {
        int num=(int)(Math.pow(x,2))+(int)(Math.pow(y,2));
        if (!set.contains(num))
          set.add(num);
      }
    }
    Collections.sort (set);
   // System.out.println (set);
    maxNum=set.get(set.size()-1);
    ArrayList<Integer>dif=new ArrayList<Integer>();
    if (max<5)
    {
      for (int x=0;x<set.size();x++)
      {
        for (int y=x+1;y<set.size();y++)
        {
          int newDif=set.get(y)-set.get(x);
          if (!dif.contains(newDif))
            dif.add(newDif);
        }
      }
      Collections.sort (dif);
    }
    if (max>5)
    {
      for (int y=4;y<5000;y+=4)
      {
        for (int x=0;x<set.size()-n;x++)
        {
          boolean good=true;
          //int d=dif.get(y);
          int d=y;
          if ((set.get(x)+d*(n-1))>maxNum)continue;
          for (int z=0;z<n;z++)
          {
            if (!set.contains(set.get(x)+d*(z)))
            {
              good=false;
              break;
            }
          }
          if (good)
          {
            System.out.println (set.get(x)+" "+d);
            out.println (set.get(x)+" "+d);
            count++;
          }
        }
      }
    }
    else
    {
      for (int y=0;y<dif.size();y++)
      {
        for (int x=0;x<set.size()-n;x++)
        {
          boolean good=true;
          int d=dif.get(y);
          if ((set.get(x)+d*(n-1))>maxNum)continue;
          for (int z=0;z<n;z++)
          {
            if (!set.contains(set.get(x)+d*(z)))
            {
              good=false;
              break;
            }
          }
          if (good)
          {
            System.out.println (set.get(x)+" "+d);
            out.println (set.get(x)+" "+d);
            count++;
          }
        }
      }
      
    }
    if (count==0)out.println ("NONE");
    
    out.close();
  }
}