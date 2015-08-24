/*
 ID: Benson.2
 LANG: JAVA
 TASK: frac1
 */
import java.util.*;
import java.io.*;

public class frac1
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("frac1.in"));
    //Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("frac1.out"));
    int n=s.nextInt();
    Map<Double, String>frac=new HashMap <Double,String>();
    double []vals=new double [Math.max(n*n/2,10)];
    Arrays.fill (vals,2);
    double temp=0;
    int count=2;
    int d;
    frac.put (1.0,"1/1");
    frac.put (0.0,"0/1");
    vals[0]=0.0;
    vals[1]=(1.0);
    for (int b=n;b>0;b--)
    {
      for (int a=1;a<b;a++)
      {
        d=gcd(a,b);
        temp=(double)a/(double)b;
        if (!frac.containsKey(temp))
        {
          vals[count]=(temp);
          count++;
          frac.put (temp,(a/d)+"/"+(b/d));
        }
      }
    }
    
    Arrays.sort(vals);
    for (int x=0;x<vals.length;x++)
    {
      if (vals[x]==2)break;
      //System.out.println (frac.get(vals[x]));
      out.println (frac.get(vals[x]));
    }
    out.close();
  }
  public static int gcd ( int a, int b )
  {
    int c;
    while ( a != 0 ) {
      c = a; a = b%a;  b = c;
    }
    return b;
  }
}