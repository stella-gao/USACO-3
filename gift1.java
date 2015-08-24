/*
ID: Benson.2
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

public class gift1
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("gift1.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("gift1.out"));
    int people=s.nextInt();
    HashMap<String,Integer> moneyGiven=new HashMap <String,Integer>();
    HashMap<String,Integer> moneyReceived=new HashMap <String,Integer>();
    String []names=new String[people];
    for (int x=0;x<people;x++)
    {
      String name=s.next();
      names[x]=name;
      moneyGiven.put(name,0);
      moneyReceived.put(name,0);
    }
    for (int x=0;x<people;x++)
    {
      String person=s.next();
      int give=s.nextInt();
      int receivers=s.nextInt();
      if (receivers==0)continue;
      give=give-give%receivers;
      moneyGiven.put(person,give);
      for (int y=0;y<receivers;y++)
      {
        String name=s.next();
        moneyReceived.put(name,give/receivers+moneyReceived.get(name));
      }
    }
    for (int x=0;x<people;x++)
    {
      out.println (names[x]+" "+(moneyReceived.get(names[x])-moneyGiven.get(names[x])));
    }
    out.close();
  }
}