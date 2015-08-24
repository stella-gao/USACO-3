/*
 ID: Benson.2
 LANG: JAVA
 TASK: prefix
 */
import java.util.*;
import java.io.*;

public class prefix
{
  public static void main (String[]args)throws IOException
  {
    //BufferedReader s=new BufferedReader (new FileReader ("in.txt"));
    BufferedReader s=new BufferedReader (new FileReader ("prefix.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("prefix.out"));
    String total="";
    String next="";
    while (true)
    {
      next=s.readLine();
      if (next.equals("."))
        break;
      total=total+next+" ";
    }
    String base[]=total.split(" ");
    String goal="";
    StringBuilder str = new StringBuilder();
    while (true)
    {
      next=s.readLine();
      if (next==null)break;
      str.append(next);
      //goal+=next;
    }
    goal=str.toString();
    boolean [] form=new boolean [goal.length()];
    Arrays.fill (form, false);
    for (int x=0;x<base.length;x++)
    {
      if (goal.substring(0,base[x].length()).equals (base[x]))
      {
        form[base[x].length()-1]=true;
      }
    }
    System.out.println (1);
    int max=0;
    for (int x=0;x<goal.length()-1;x++)
    {
      if (form[x])
      {
        for (int y=0;y<base.length;y++)
        {
          if (x+base[y].length()<goal.length())
          {
            if (goal.substring(x+1,x+1+base[y].length()).equals (base[y])&&!form[x+base[y].length()])
            {
              form[x+base[y].length()]=true;
              if ((x+base[y].length()+1)>max)
                max=x+base[y].length()+1;
            }
          }
        }
      }
    }
    out.println (max);
    //System.out.println (max);
    //System.out.println (goal);
    
    
    out.close();
  }
}