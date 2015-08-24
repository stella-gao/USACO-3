/*
 ID: Benson.2
 LANG: JAVA
 TASK: sort3
 */
import java.util.*;
import java.io.*;

public class sort3
{
  static int[]records;
  static int n;
  static int val;
  static int pOne,pOne2,pTwo,pTwo2,pThree,pThree2;
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("sort3.in"));
    //Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("sort3.out"));
    n=s.nextInt();
    int swaps=0;
    int swapTemp=0;
    int temp=0;
    int one=0;
    int two=0;
    int three=0;
    records=new int[n];
    int []tempRecords=new int [n];
    for (int x=0;x<n;x++)
    {
      records [x]=s.nextInt();
      if (records[x]==1)one++;
      if (records[x]==2)two++;
      if (records[x]==3)three++;
    }
    System.arraycopy (records,0,tempRecords,0,n);
    pOne=0;
    pOne2=one-1;
    pTwo=one;
    pTwo2=one+two-1;
    pThree=one+two;
    pThree2=n-1;
    int lOne=n-1;
    int fThree=0;
    int lTwo=n-1;
    int fTwo=0;
    int pos=0;
    
    if (one>0&&two>0&&three>0)
    {
      //1-2
      while (onein2()!=-1&&twoin1()!=-1)
      {
        records[onein2()]=2;
        records[twoin1()]=1;
        swaps++;
      }
      //2-3
      while (twoin3()!=-1&&threein2()!=-1)
      {
        records[threein2()]=2;
        records[twoin3()]=3;
        swaps++;
      }
      //1-3
      while (onein3()!=-1&&threein1()!=-1)
      {
        records[onein3()]=3;
        records[threein1()]=1;
        swaps++;
      }
      
      //1
      while (lastOne()>firstNotOne())
      {
        temp=records[firstNotOne()];
        records[firstNotOne()]=1;
        records[lastOne()]=temp;
        swaps++;
      }
      //2
      lTwo=n-1;
      fThree=0;
      while (records[fThree]!=3)
      {
        fThree++;
      }
      while (records[lTwo]!=2)
      {
        lTwo--;
      }
      while (fThree<lTwo)
      {
        temp=records[lTwo];
        records[lTwo]=records[fThree];
        records[fThree]=temp;
        swaps++;
        while (records[lTwo]!=2)
        {
          lTwo--;
        }
        while (records[fThree]!=3)
        {
          fThree++;
        }
      }
    }
    else if (one>0&&two>0&&three==0)
    {
      fTwo=0;
      lOne=n-1;
      while (records[fTwo]!=2)
      {
        fTwo++;
      }
      while (records[lOne]!=1)
      {
        lOne--;
      }
      while (fTwo<lOne)
      {
        temp=records[lOne];
        records[lOne]=records[fTwo];
        records[fTwo]=temp;
        swaps++;
        while (records[lOne]!=1)
        {
          lOne--;
        }
        while (records[fTwo]!=2)
        {
          fTwo++;
        }
      }
    }
    else if (one>0&&two==0&&three>0)
    {
      lOne=n-1;
      fThree=0;
      while (records[lOne]!=1)
      {
        lOne--;
      }
      while (records[fThree]!=3)
      {
        fThree++;
      }
      while (fThree<lOne)
      {
        temp=records[lOne];
        records[lOne]=records[fThree];
        records[fThree]=temp;
        swaps++;
        while (records[lOne]!=1)
        {
          lOne--;
        }
        while (records[fThree]!=3)
        {
          fThree++;
        }
      }
    }
    else if (one==0&&two>0&&three>0)
    {
      lTwo=n-1;
      fThree=0;
      while (records[fThree]!=3)
      {
        fThree++;
      }
      while (records[lTwo]!=2)
      {
        lTwo--;
      }
      while (fThree<lTwo)
      {
        temp=records[lTwo];
        records[lTwo]=records[fThree];
        records[fThree]=temp;
        swaps++;
        while (records[lTwo]!=2)
        {
          lTwo--;
        }
        while (records[fThree]!=3)
        {
          fThree++;
        }
      }
    }
    else if ((one==0&&two==0)||(three==0&&two==0)||(one==0&&three==0))
    {
      swaps=0;
    }
    else
    {
    }
    
    System.out.println (swaps);
    out.println (swaps);
    out.close();
  }
  
  public static int lastOne()
  {
    for (int x=n-1;x>=0;x--)
    {
      if (records[x]==1)return x;
    }
    return -1;
  }
  
  public static int firstNotOne()
  {
    for (int x=0;x<n;x++)
    {
      if (records[x]!=1)
      {
        val=records[x];
        return x;
      }
    }
    return -1;
  }
  
  public static int onein2()
  {
    for (int x=pTwo;x<pTwo2+1;x++)
    {
      if (records[x]==1)return x;
    }
    return -1;
  }
  public static int onein3()
  {
    for (int x=pThree;x<n;x++)
    {
      if (records[x]==1)return x;
    }
    return -1;
  }
  public static int twoin1()
  {
    for (int x=pOne;x<pOne2+1;x++)
    {
      if (records[x]==2)return x;
    }
    return -1;
  }
  public static int twoin3()
  {
    for (int x=pThree;x<n;x++)
    {
      if (records[x]==2)return x;
    }
    return -1;
  }
  public static int threein1()
  {
    for (int x=pOne;x<pOne2+1;x++)
    {
      if (records[x]==3)return x;
    }
    return -1;
  }
  public static int threein2()
  {
    for (int x=pTwo;x<pTwo2+1;x++)
    {
      if (records[x]==3)return x;
    }
    return -1;
  }
}
