/*
 ID: Benson.2
 LANG: JAVA
 TASK: fracdec
 */
import java.util.*;
import java.io.*;

public class fracdec
{
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File("in.txt"));
    Scanner s=new Scanner (new File ("fracdec.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("fracdec.out"));
    int n=s.nextInt();
    int d=s.nextInt();
    int [] pos=new int[100005];
    Arrays.fill (pos,-1);
    StringBuilder dec2 = new StringBuilder();
    String dec="";
    int whole=0;
    int counter=0;
    if (n>=d)
    {
      whole=n/d;
      n%=d;
    }
    pos[n]=0;
    if (n==0)
    {
      out.println (whole+".0");
      //System.out.println (whole+".0");
    }
    else
    {
      while (true)
      {
        n*=10;
        dec2.append(n/d);
        n%=d;
        if(n==0)
        {
          dec=dec2.toString();
          break;
        }
        if (pos[n]!=-1)
        {
          dec=dec2.toString();
          dec=dec.substring(0,pos[n])+"("+dec.substring(pos[n])+")";
          break;
        }
        pos[n]=++counter;
      }
      dec=whole+"."+dec;
      if (dec.length()<=76)
      {
        //System.out.println (dec);
        out.println (dec);
      }
      else
      {
        for (int x=0;x<dec.length()/76;x++)
        {
          //System.out.println (dec.substring(x*76,76*(x+1)));
          out.println (dec.substring(x*76,76*(x+1)));
        }
        if (dec.length()/76!=0)
        {
          //System.out.println (dec.substring(76*(dec.length()/76)));
          out.println (dec.substring(76*(dec.length()/76)));
        }
      }
    }
    s.close();
    out.close();
  }
}