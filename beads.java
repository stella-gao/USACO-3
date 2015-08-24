/*
 ID: Benson.2
 LANG: JAVA
 TASK: beads
 */

import java.util.*;
import java.io.*;

public class beads
{
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("beads.in"));
    PrintWriter out=new PrintWriter (new FileWriter ("beads.out"));
    
    int numBeads=s.nextInt();
    char[]necklace=s.next().toCharArray();
    int n=necklace.length;
    int max=0;
    //System.out.println (getMax(necklace));
//    for (int x=0;x<n;x++)
//    {
//      if (necklace[x]=='w')
//      {
//        char leftColor=' ';
//        char rightColor=' ';
//        int indexLeft=0;
//        int indexRight=x;
//        int numW=1;
//        if (x==0)
//        {
//          indexLeft=n-1;
//        }
//        else
//        {
//          indexLeft=x-1;
//        }
//        while (true)
//        {
//          if (necklace[indexLeft]!='w')
//          {
//            leftColor=necklace[indexLeft];
//            break;
//          }
//          else
//          {
//            numW++;
//            if (numW>=n-1)
//            {
//              leftColor='r';
//              rightColor='r';
//              indexLeft=n-1;
//              indexRight=0;
//              break;
//            }
//          }
//          indexLeft--;
//          if (indexLeft<0)
//          {
//            indexLeft=n-1;
//          }
//        }
//        if (numW<n-1)
//        {
//          while (true)
//          {
//            indexRight++;
//            if (indexRight>(n-1))indexRight=0;
//            if (necklace[indexRight]!='w')
//            {
//              rightColor=necklace[indexRight];
//              break;
//            }
//            else
//            {
//              numW++;
//            }
//          }
//        }
//        if (rightColor==leftColor)
//        {
//          //System.out.println (indexLeft+" "+indexRight);
//          indexLeft++;
//          if (indexLeft>(n-1))indexLeft=0;
//          while(indexLeft!=indexRight)
//          {
//            necklace[indexLeft]=leftColor;
//            indexLeft++;
//            if (indexLeft>(n-1))indexLeft=0;
//          }
//        }
//        else
//        {
//          int tempLeft=indexLeft;
//          indexLeft++;
//          if (indexLeft>(n-1))indexLeft=0;
//          while(indexLeft!=indexRight)
//          {
//            necklace[indexLeft]='r';
//            indexLeft++;
//            if (indexLeft>(n-1))indexLeft=0;
//          }
//          int red=getMax(necklace);
//          indexLeft=tempLeft;
//          indexLeft++;
//          if (indexLeft>(n-1))indexLeft=0;
//          while(indexLeft!=indexRight)
//          {
//            necklace[indexLeft]='b';
//            indexLeft++;
//            if (indexLeft>(n-1))indexLeft=0;
//          }
//          int black=getMax(necklace);
//          if (red>black)
//          {
//            indexLeft=tempLeft;
//            indexLeft++;
//            if (indexLeft>(n-1))indexLeft=0;
//            while(indexLeft!=indexRight)
//            {
//              necklace[indexLeft]='r';
//              indexLeft++;
//              if (indexLeft>(n-1))indexLeft=0;
//            }
//          }
//        }
//      }
//    }
    for (int x=0;x<n;x++)
    {
      char leftColor=' ';
      char rightColor=' ';
      int indexLeft=0;
      int indexRight=x;
      if (x==0)
      {
        indexLeft=n-1;
      }
      else
      {
        indexLeft=x-1;
      }
      
      while (true)
      {
        if (necklace[indexLeft]!='w')
        {
          if (leftColor==' ')
            leftColor=necklace[indexLeft];
          else 
          {
            if (necklace[indexLeft]!=leftColor)
              break;
          }
        }
        if (indexLeft==x){
          max=n;
          break;
        }
        indexLeft--;
        if (indexLeft<0)
        {
          indexLeft=n-1;
        }
      }
      while (true)
      {
        if (necklace[indexRight]!='w')
        {
          if (rightColor==' ')
            rightColor=necklace[indexRight];
          else 
          {
            if (necklace[indexRight]!=rightColor)
              break;
          }
        }
        if (indexLeft==indexRight)break;
        indexRight++;
        if (indexRight>n-1)
        {
          indexRight=0;
        }
      }
      char[]temp=new char[n];
      System.arraycopy( necklace, 0, temp, 0, n );
      int split=x;
      indexLeft++;
      if (indexLeft>(n-1))indexLeft=0;
      while (indexLeft!=split)
      {
        if (temp[indexLeft]=='w')
          temp[indexLeft]=leftColor;
        indexLeft++;
        if (indexLeft>(n-1))indexLeft=0;
      }
      while (indexLeft!=indexRight)
      {
        if (temp[indexLeft]=='w')
          temp[indexLeft]=rightColor;
        indexLeft++;
        if (indexLeft>(n-1))indexLeft=0;
      }
      int tempVal=getMax(temp);
      if (tempVal>max)max=tempVal;
    }
    
    
    // for (int t=0;t<n;t++)
    //   System.out.print (necklace[t]);
    //  System.out.println();
    out.println (max);
    out.close();
  }
  
  public static int getMax(char[]arr)
  {
    int n=arr.length;
    if (n<3)return n;
    int maxCount=0;
    for (int z=0;z<n;z++)
    {
      int index=0;
      int countLeft=1;
      int countRight=1;
      char leftColor=' ';
      if (z==0)
      {
        leftColor=arr[n-1];
        index=n-1;
      }
      else
      {
        leftColor=arr[z-1];
        index=z-1;
      }
      char rightColor=arr[z];
      while (true)
      {
        index--;
        if (index<0)index=n-1;
        if (index==z)return arr.length;
        if (arr[index]!=leftColor) break;
        else
          countLeft++;
      }
      index=z;
      while (true)
      {
        index++;
        if (index>(n-1))index=0;
        if (arr[index]!=rightColor) break;
        else
          countRight++;
      }
      if ((countLeft+countRight)>maxCount)maxCount=countLeft+countRight;
    }
    return maxCount;
  }
}