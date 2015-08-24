/*
 ID: Benson.2
 LANG: JAVA
 TASK: milk
 */

import java.util.*;
import java.io.*;

public class milk
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("milk.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("milk.out"));
    
    int milkneeded=s.nextInt();
    int farmers=s.nextInt();
    int [] amount=new int[1001];
    Arrays.fill(amount,0);
    for (int x=0;x<farmers;x++)
    {
      int price=s.nextInt();
      amount[price]+=s.nextInt();
    }
    int index=0;
    int cost=0;
    while (milkneeded>0)
    {
      while (amount[index]==0)
        index++;

      int quant=amount[index];
      if (quant>milkneeded)
      {
        cost+=milkneeded*index;
        break;
      }
      else
      {
        cost+=quant*index;
        milkneeded-=quant;
        index++;
      }
    }
    out.println (cost);
    out.close();
  }
}