/*
 ID: Benson.2
 LANG: JAVA
 TASK: crypt1
 */
import java.util.*;
import java.io.*;

public class crypt1
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("crypt1.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("crypt1.out"));
    
    int n=s.nextInt();
    int[] set=new int[n];
    ArrayList<Integer>solutions=new ArrayList<Integer>();
    for (int x=0;x<n;x++)
    {
      set[x]=s.nextInt();
    }
    int count=0;
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    int e=0;
    int p1=0;
    String temp;
    int p2=0;
    int fin;
    int ans=0;
    boolean possible=true;
    
    for (int v=0;v<n;v++)
    {
      for (int w=0;w<n;w++)
      {
        for (int x=0;x<n;x++)
        {
          for (int y=0;y<n;y++)
          {    for (int z=0;z<n;z++)
            { 
            possible=true;
            a=set[v];
            b=set[w];
            c=set[x];
            d=set[y];
            e=set[z];
            p1=(100*a+10*b+c)*d;
            if (p1>999)continue;
            temp=p1+"";
            for (int q=0;q<temp.length();q++)
            {
              if (!setContains (set,Integer.parseInt(temp.substring(q,q+1))))
              {
                possible=false;
                break;
              }
            }
            p2=(100*a+10*b+c)*e;
            if (p2>999)continue;
            temp=p2+"";
            for (int q=0;q<temp.length();q++)
            {
              if (!setContains (set,Integer.parseInt(temp.substring(q,q+1))))
              {
                possible=false;
                break;
              }
            }
            fin=(100*a+10*b+c)*(d*10+e);
            if (fin>9999||fin<1000)continue;
            temp=fin+"";
            for (int q=0;q<temp.length();q++)
            {
              if (!setContains (set,Integer.parseInt(temp.substring(q,q+1))))
              {
                possible=false;
                break;
              }
            }
            if (possible&&!solutions.contains(10000*a+1000*b+c*100+d*10+e))
            {count++;
            solutions.add(10000*a+1000*b+c*100+d*10+e);
                          }
          }      
          }
        }
      }
    }
    out.println (solutions.size());
    out.close();
  }
  
  public static boolean setContains(int [] set,int num)
  {
    for (int x=0;x<set.length;x++)
      if (set[x]==num)return true;
      
      return false;
  }
  
}