/*
 ID: Benson.2
 LANG: JAVA
 TASK: maze1
 */
import java.util.*;
import java.io.*;

public class maze1
{
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File ("in.txt"));
    Scanner s=new Scanner (new File ("maze1.in"));
    PrintWriter out=new PrintWriter(new FileWriter ("maze1.out"));
    int w=s.nextInt();
    int h=s.nextInt();
    int x1=0;
    int y1=0;
    boolean found1=false;
    int x2=0;
    int y2=0;
    s.nextLine();
    char [][]maze=new char[2*h+1][2*w+1];
    for (int y=0;y<2*h+1;y++)
    {
      maze [y]=s.nextLine().toCharArray();
    }
    for (int y=0;y<2*h+1;y++)
    {
      for (int x=0;x<2*w+1;x++)
      {
        if (found1&&(y==0||y==2*h||x==0||x==2*w)&&maze[y][x]==' ')
        {
          x2=x;
          y2=y;
          if (x2==0)
            x2++;
          if (y2==0)
            y2++;
          if (x2==2*w)
            x2--;
          if (y2==2*h)
            y2--;
          break;
        }
        if ((y==0||y==2*h||x==0||x==2*w)&&maze[y][x]==' ')
        {
          found1=true;
          x1=x;
          y1=y;
          if (x1==0)
            x1++;
          if (y1==0)
            y1++;
          if (x1==2*w)
            x1--;
          if (y1==2*h)
            y1--;
        }
      }
    }
    int [][]shortest1=new int[2*h+1][2*w+1];
    boolean[][]visited1=new boolean[2*h+1][2*w+1];
    for (int x=0;x<2*h+1;x++)
    {
      Arrays.fill (visited1[x],false);
      Arrays.fill (shortest1[x],999999);
    }
    int counter=2;
    shortest1[y1][x1]=0;
    update (maze,x1,y1,shortest1,visited1);
    
    shortest1[y2][x2]=0;
    update (maze,x2,y2,shortest1,visited1);
    int next[]=new int[2];
    while (counter<h*w)
    {
      find (maze,next,shortest1,visited1);
      update (maze,next[0],next[1],shortest1,visited1);
      counter++;
    }
    
    int min=0;
    for (int y=1;y<2*h+1;y+=2)
    {
      for (int x=1;x<2*w+1;x+=2)
      {
        if (maze[y][x]==' ')
          min=Math.max(min,shortest1[y][x]);
      }
    }
    //System.out.println (min+1);
    out.println (min+1);
    
//    for (int y=0;y<2*h+1;y++)
//    {
//      for (int x=0;x<2*w+1;x++)
//      {
//        System.out.print (maze [y][x]);
//      }
//      System.out.println ();
//    }
//    
//    for (int y=0;y<2*h+1;y++)
//    {
//      for (int x=0;x<2*w+1;x++)
//      {
//        System.out.print (shortest1 [y][x]+" ");
//      }
//      System.out.println ();
//    }
    
    out.close(); 
    s.close();
  }
  
  public static void find(char[][]maze,int[]co,int[][]shortest,boolean[][]visited)
  {
    int min=10000;
    for (int y=1;y<maze.length;y+=2)
    {
      for (int x=1;x<maze[0].length;x+=2)
      {
        if (!visited[y][x]&&shortest[y][x]<=min)
        {
          min=shortest[y][x];
          co[1]=y;
          co[0]=x;
        }
        
      }
    }
  }
  public static void update (char [][]maze, int x1,int y1,int[][] shortest,boolean visited[][])
  {
    visited[y1][x1]=true;
    if (x1>1)
    {
      if (maze[y1][x1-1]==' '&&maze[y1][x1-2]==' '&&(shortest[y1][x1]+1<shortest[y1][x1-2]))
      {
        shortest[y1][x1-2]=shortest[y1][x1]+1;
      }
    }
    if (x1<maze[0].length-2)
    {
      if (maze[y1][x1+1]==' '&&maze[y1][x1+2]==' '&&(shortest[y1][x1]+1<shortest[y1][x1+2]))
      {
        shortest[y1][x1+2]=shortest[y1][x1]+1;
      }
    }
    
    if (y1>1)
    {
      if (maze[y1-1][x1]==' '&&maze[y1-2][x1]==' '&&(shortest[y1][x1]+1<shortest[y1-2][x1]))
      {
        shortest[y1-2][x1]=shortest[y1][x1]+1;
      }
    }
    if (y1<maze.length-2)
    {
      if (maze[y1+1][x1]==' '&&maze[y1+2][x1]==' '&&(shortest[y1][x1]+1<shortest[y1+2][x1]))
      {
        shortest[y1+2][x1]=shortest[y1][x1]+1;
      }
    }
  }
}