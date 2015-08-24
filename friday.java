/*
ID: Benson.2
LANG: JAVA
TASK: friday
 */

import java.util.*;
import java.io.*;

public class friday
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("friday.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("friday.out"));
    int [] month=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    String[] day=new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saterday"};
    HashMap<String,Integer> numDay=new HashMap<String,Integer>();
    for (int y=0;y<7;y++)
    {
      numDay.put(day[y],0);
    }
    int years=s.nextInt();
    int count=0;
    int year=1899;
    for (int x=0;x<years;x++)
    {
      year++;
      if (year%4==0)
        month[1]=29;
      else 
        month[1]=28;
      if (year%100==0)
        month[1]=28;
      if (year%400==0)
        month[1]=29;
      
      for (int z=0;z<12;z++)
      {
        count+=13;
        count=count%7;
        numDay.put(day[count],(numDay.get(day[count])+1));
        count+=(month[z]-13);
        count=count%7;
      }
    }
    out.print (numDay.get(day[6]));
    for (int x=0;x<6;x++)
    {
      out.print (" "+numDay.get(day[x]));
    }
    out.println();
    out.close();
  }
}