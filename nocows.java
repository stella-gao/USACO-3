/*
 ID: Benson.2
 LANG: JAVA
 TASK: nocows
 */
import java.util.*;
import java.io.*;

public class nocows
{
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("nocows.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("nocows.out"));
    
    int n=s.nextInt();
    int k=s.nextInt();
    if (n%2==0)
      out.println (0);
    else
    {
      n=(n-1)/2;
      k--;
      int [][] combos=new int [k+1][n+1];
      for (int x=0;x<=k;x++)
      {
        Arrays.fill (combos[x],0);
      }
      //for (int x=0;x<=k;x++)
      combos[0][0]=1;
      for (int x=0;x<=k;x++)
      {
        for (int y=1;y<=n;y++)
        {        
          int sum=0;
          for (int z=0;z<y;z++)
          {
            int sum1=0;
            int sum2=0;
            for (int a=0;a<x;a++)
            {
              sum1+=combos[x-1][z]%9901*combos[a][y-z-1]%9901;
              sum1%=9901;
            }
            for (int b=0;b<x-1;b++)
            { 
              sum2+=((combos[b][z]%9901)*(combos[x-1][y-z-1]%9901));
              sum2=sum2%9901;
            }
            sum+=((sum1+sum2)%9901);
            sum%=9901;
          }
          combos[x][y]=sum;
        }
      }
      
      //System.out.println (combos[k][n]%9901);
      //System.out.println (k+" "+n);
//    for (int x=0;x<=k;x++)
//    {
//      for (int y=0;y<=n;y++)
//      {
//        System.out.print (combos [x][y]+" ");
//      }
//      System.out.println ();
//    }
      out.println (combos[k][n]%9901);
    }
    out.close();
  }
}