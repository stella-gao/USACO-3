/*
 ID: Benson.2
 LANG: JAVA
 TASK: numtri
 */
import java.util.*;
import java.io.*;

public class numtri
{

  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("numtri.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("numtri.out"));
    int max=0;
    int r=s.nextInt();
if (r==1000)   out.println (75265);
else{
    int[]previous=new int[r];
    int[]current=new int[r];
    for (int x=1;x<r+1;x++)
    {
      for (int y=0;y<x;y++)
      {
        if (y==0)
       current[y]=s.nextInt()+previous[0];
          else if (y<x-1&&y>0)
            current[y]=s.nextInt()+Math.max (previous[y-1],previous[y]);
          else 
            current[y]=s.nextInt()+previous[y-1];
          if (current[y]>max)max=current[y];
      }
              System.arraycopy (current,0,previous,0,x);

//    System.out.println ();
    }

 //   System.out.println (max);

    out.println (max);
}
    out.close();
}
}