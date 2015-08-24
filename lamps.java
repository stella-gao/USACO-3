/*
 ID: Benson.2
 LANG: JAVA
 TASK: lamps
 */

import java.util.*;
import java.io.*;


public class lamps
{
  public static void main (String[]args) throws IOException
  {
    //Scanner s=new Scanner(System.in);
    Scanner s=new Scanner(new File("lamps.in"));
    //Scanner s=new Scanner(new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("lamps.out"));
    int n=s.nextInt();
    int c=s.nextInt();
    ArrayList<boolean[]> answer=new ArrayList<boolean[]>();
    int [] win=new int[n];
    Arrays.fill (win,-1);
    int next=s.nextInt();
    while (next!=-1)
    {
      win[next-1]=1;
      next=s.nextInt();
    }
    next=s.nextInt();
    while (next!=-1)
    {
      win[next-1]=0;
      next=s.nextInt();
    }
//    for (int x=0;x<win.length;x++)
//    {
//      System.out.print(win[x]);
//    }
    Comparator arraySort=new Comparator<boolean[]> (){
      public int compare (boolean []a,boolean []b){
        for (int z=0;z<b.length;z++)
        {
          if (a[z]&&!b[z])return 1;
          else if (b[z]&&!a[z])return -1;
          else{
          }
        }
        return 0;
      }
    };
    boolean []toAdd;
    if (c==0)
    {
      toAdd=new boolean [n];
      Arrays.fill (toAdd,true);
      if (!contains(toAdd,answer)&&isValid(toAdd,win))
        answer.add (toAdd);
    }
    else if (c==1)
    {
      toAdd=new boolean [n];
      Arrays.fill (toAdd,true);
      if (!contains(toAdd,answer)&&isValid(toAdd,win))
        answer.add (toAdd);
      for (int x=1;x<5;x++)
      {
        toAdd=new boolean [n];
        Arrays.fill (toAdd,true);
        b(toAdd,x);
        if (!contains(toAdd,answer)&&isValid(toAdd,win))
          answer.add (toAdd);
      }
    }
    else if (c==2)
    {
      toAdd=new boolean [n];
      Arrays.fill (toAdd,true);
      if (!contains(toAdd,answer)&&isValid(toAdd,win))
        answer.add (toAdd);
      for (int x=1;x<5;x++)
      {
        for (int y=0;y<5;y++)
        {
          toAdd=new boolean [n];
          Arrays.fill (toAdd,true);
          b(toAdd,x);
          b(toAdd,y);
          if (!contains(toAdd,answer)&&isValid(toAdd,win))
            answer.add (toAdd);
        }
      }
    }
    else if (c==3)
    {
      toAdd=new boolean [n];
      Arrays.fill (toAdd,true);
      if (!contains(toAdd,answer)&&isValid(toAdd,win))
        answer.add (toAdd);
      for (int x=1;x<5;x++)
      {
        for (int y=0;y<5;y++)
        {
          for (int j=0;j<5;j++)
          {
            toAdd=new boolean [n];
            Arrays.fill (toAdd,true);
            b(toAdd,x);
            b(toAdd,y);
            b(toAdd,j);
            if (!contains(toAdd,answer)&&isValid(toAdd,win))
              answer.add (toAdd);
          }
        }
      }
    }
    else 
    {
      toAdd=new boolean [n];
      Arrays.fill (toAdd,true);
      if (!contains(toAdd,answer)&&isValid(toAdd,win))
        answer.add (toAdd);
      for (int x=1;x<5;x++)
      {
        for (int y=0;y<5;y++)
        {
          for (int j=0;j<5;j++)
          {
            for (int k=0;k<5;k++)
            {
              toAdd=new boolean [n];
              Arrays.fill (toAdd,true);
              b(toAdd,x);
              b(toAdd,y);
              b(toAdd,j);
              b(toAdd,k);
              if (!contains(toAdd,answer)&&isValid(toAdd,win))
                answer.add (toAdd);
            }
          }
        }
      }
    }
    Collections.sort (answer,arraySort);
    if (answer.size()==0)
      out.println ("IMPOSSIBLE");
    for (int x=0;x<answer.size();x++)
    {
      for (int y=0;y<n;y++)
      {
        if (answer.get(x)[y])
          out.print ("1");
        else
          out.print ("0");
      }
      out.println();
    }
    
    out.close();
  }
  
  public static boolean isValid(boolean[]arr, int [] win)
  {
    for (int x=0;x<win.length;x++)
    {
      if (win[x]!=-1)
      {
        if (win[x]==0&&arr[x])
          return false;
        else if (win[x]==1&&!arr[x])
          return false;
      }
    }
    return true;
  }
  
  public static boolean contains(boolean[] arr,ArrayList<boolean[]>contain)
  {
    for (int x=0;x<contain.size();x++)
    {
      boolean match=true;
      for (int y=0;y<arr.length;y++)
      {
        if (arr[y]!=contain.get(x)[y])
        {
          match=false;
          break;
        }
      }
      if (match)
        return true;
    }
    return false;
  }
  
  public static boolean[] b(boolean [] arr, int button)
  {
    if (button==1)
    {
      for (int x=0;x<arr.length;x++)
        arr[x]=!arr[x];
    }
    else if (button==2)
    {
      for (int x=0;x<arr.length;x+=2)
        arr[x]=!arr[x];
    }
    else if (button==3)
    {
      for (int x=1;x<arr.length;x+=2)
        arr[x]=!arr[x];
    }
    else
    {
      for (int x=0;x<arr.length;x+=3)
        arr[x]=!arr[x];
    }
    return arr;
  }  
}