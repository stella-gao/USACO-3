/*
 ID: Benson.2
 LANG: JAVA
 TASK: zerosum
 */
import java.util.*;
import java.io.*;

public class zerosum
{
  static ArrayList<String>ans;
  static int n=0;
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("zerosum.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("zerosum.out"));
    n=s.nextInt();
    ans=new ArrayList<String>();
    if (n>2)
    {
      recurse ("",0,-1);
      Collections.sort (ans);
      for (int x=0;x<ans.size();x++)
      {
        out.println (ans.get(x));
      }
      //System.out.println (check ("+-+--+"));
    }
     out.close();
  }
  
  //1+, 2-, 3 
  public static void recurse(String seq,int spots,int type)
  {
    if (type==1)
    {
      seq+="+";
    }
    else if (type==2)
    {
      seq+="-";
    }
    else if (type==3)
    {
      seq+=" ";
    }
    else
    {
    }
    if (spots==n-1)
    {
      if (check(seq)&&!ans.contains(seq))
      {
        String toAdd="1";
        for (int x=0;x<n-1;x++)
        {
          toAdd+=seq.substring (x,x+1)+(x+2);
        }
        ans.add (toAdd);
      }
      return;
    }
    //System.out.println (seq);
    recurse (seq,spots+1,1);
    recurse (seq,spots+1,2);
    recurse (seq,spots+1,3);
  }
  
  public static boolean check (String seq)
  {
    int store=1;
    int sum=0;
    char curr='x';
    char prev='+';
    for (int x=0;x<seq.length()+1;x++)
    {
      if (x<seq.length())
        curr=seq.charAt(x);
      else
        curr='+';
      //System.out.println (store);
      if (prev=='+'&&curr!=' ')
      {
        sum+=store;
        store=0;
      }
      else if (prev=='-'&&curr!=' ')
      {
        sum-=store;
        store=0;
      }
      else
      {
        store*=10;
      }
      if (curr!=' ')
        prev=curr;
      store+=(x+2);
    }
    //System.out.println (sum);
    if (sum==0)
      return true;
    else return false;
  }
}