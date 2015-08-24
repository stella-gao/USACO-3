/*
 ID: Benson.2
 LANG: JAVA
 TASK: subset
 */

import java.util.*;
import java.io.*;


public class subset
{
  static int n;
  static int goal;
  public static void main (String[]args) throws IOException
  {
    //Scanner s=new Scanner(System.in);
    Scanner s=new Scanner(new File("subset.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("subset.out"));
    n=s.nextInt();
    if (n*(n+1)%4!=0)goal=0;
    else
    goal=n*(n+1)/4;
    //out.println (recurse(goal,n)/2);
    int [][]storage=new int [n+1][goal+1];
    for (int x=0;x<n;x++)
    Arrays.fill (storage[x], 0);
    storage [0][0]=1;
    for (int x=1;x<=n;x++)
    {
      for (int y=1;y<=goal;y++)
      {
        
        if (y-x<0)
          storage[x][y]=storage[x-1][y];
        else 
          storage[x][y]=storage[x-1][y-x]+storage[x-1][y];
      }
    }
    out.println (storage[n][goal]);
    out.close();
  }
  
  //sum n, set of k
  public static int recurse (int n, int k)
  {
    if (n<0||k<0)return 0;
    if (n==0&&k==0)return 1;
    return recurse (n,k-1)+recurse (n-k,k-1);
  }
}