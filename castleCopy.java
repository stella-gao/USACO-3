/*
 ID: Benson.2
 LANG: JAVA
 TASK: castle
 */
import java.util.*;
import java.io.*;

public class castle
{
  static int m,n;
  static char[][]floor;
  static ArrayList<ArrayList<String>>rooms;
  static int[][][] walls;
  public static void main (String[]args)throws IOException
  {
    //Scanner s=new Scanner (new File("castle.in"));
    Scanner s=new Scanner (new File("in.txt"));
    PrintWriter out=new PrintWriter (new FileWriter ("castle.out"));
    m=s.nextInt();
    n=s.nextInt();
    int absMax=m*n;
    floor=new char[2*n+1][2*m+1];
    rooms=new ArrayList<ArrayList<String>>();
    walls=new int[2*n+1][2*m+1][2];
        for (int y=0;y<2*n+1;y++)
    {
      for (int x=0;x<2*m+1;x++)
      {
        Arrays.fill (walls[y][x],0);
      }
    }
    for (int y=0;y<2*n+1;y++)
      Arrays.fill (floor[y],'#');
    for (int y=1;y<n+1;y++)
    {
      for (int x=1;x<m+1;x++)
      {
        floor [2*y-1][2*x-1]=' ';
      }
    }
    for (int y=1;y<n+1;y++)
    {
      for (int x=1;x<m+1;x++)
      {
        int a=s.nextInt();
        //west
        if (a%2==1)
        {
          a--;
          floor[2*y-1][2*x-2]='#';
        }
        else
        {
          floor[2*y-1][2*x-2]='.';
        }
        
        //south
        if (a>=8)
        {
          a-=8;
          floor[2*y][2*x-1]='#';
        }
        else
        {
          floor[2*y][2*x-1]='.';
        }
        
        //east
        if (a>=4)
        {
          a-=4;
          floor[2*y-1][2*x]='#';
        }
        else
        {
          floor[2*y-1][2*x]='.';
        }
        
        //north
        if (a>=2)
        {
          a-=2;
          floor[2*y-2][2*x-1]='#';
        }
        else
        {
          floor[2*y-2][2*x-1]='.';
        }
      }
    }
    
    //find rooms
    for (int y=1;y<n+1;y++)
    {
      for (int x=1;x<m+1;x++)
      {
        String coord =(2*x-1)+","+(2*y-1);
        if (!recorded (coord))
        {
          rooms.add (new ArrayList<String>());
          fillRoom(2*x-1,2*y-1,rooms.size()-1);
        }
      }
    }
    System.out.println (rooms.size());
    out.println (rooms.size());
    int max=1;
    //max room
    for (int x=0;x<rooms.size();x++)
    {
      if (rooms.get(x).size()>max)
        max=rooms.get(x).size();
    }
    System.out.println (max);
    out.println (max);
    //remove wall
    int modifiedMax=0;
    int wallX=0;
    int wallY=0;
    char dir=' ';
    for (int x=1;x<m+1;x++)
    {
      for (int y=n;y>0;y--)
      {
        //remove N
        if (y>1&&floor[2*y-2][2*x-1]=='#')
        {
          modifiedMax=0;
          floor[2*y-2][2*x-1]='.';
          rooms.clear();
          for (int y2=1;y2<n+1;y2++)
          {
            for (int x2=1;x2<m+1;x2++)
            {
              String coord =(2*x2-1)+","+(2*y2-1);
              if (!recorded (coord))
              {
                rooms.add (new ArrayList<String>());
                fillRoom(2*x2-1,2*y2-1,rooms.size()-1);
              }
            }
          }
          //max room
          for (int z=0;z<rooms.size();z++)
          {
            if (rooms.get(z).size()>modifiedMax)
              modifiedMax=rooms.get(z).size();
          }
          if (modifiedMax>max)
          {
            max=modifiedMax;
            wallX=x;
            wallY=y;
            dir='N';
          }
          floor[2*y-2][2*x-1]='#';
          if (modifiedMax==absMax)break;
        }
        //remove E
        if (x<m&&floor[2*y-1][2*x]=='#')
        {
          modifiedMax=0;
          floor[2*y-1][2*x]='.';
          rooms.clear();
          for (int y2=1;y2<n+1;y2++)
          {
            for (int x2=1;x2<m+1;x2++)
            {
              String coord =(2*x2-1)+","+(2*y2-1);
              if (!recorded (coord))
              {
                rooms.add (new ArrayList<String>());
                fillRoom(2*x2-1,2*y2-1,rooms.size()-1);
              }
            }
          }
          //max room
          for (int z=0;z<rooms.size();z++)
          {
            if (rooms.get(z).size()>modifiedMax)
              modifiedMax=rooms.get(z).size();
          }
          if (modifiedMax>max)
          {
            max=modifiedMax;
            wallX=x;
            wallY=y;
            dir='E';
          }
          floor[2*y-1][2*x]='#';
                    if (modifiedMax==absMax)break;
        }
      }
    }
    System.out.println (max);
    System.out.println (wallY+" "+wallX+" "+dir);
    out.println (max);
    out.println (wallY+" "+wallX+" "+dir);
    
    //display
//    for (int y=0;y<2*n+1;y++)
//    {
//      for (int x=0;x<2*m+1;x++)
//      {
//        System.out.print (floor [y][x]);
//      }
//      System.out.println ();
//    }
//    for (int x=0;x<rooms.size();x++)
//    {
//      System.out.println (rooms.get(x));
//    }
//    
    out.close();
  }
  
  public static boolean recorded (String coord)
  {
    for (int x=0;x<rooms.size();x++)
    {
      if (rooms.get(x).contains (coord))
        return true;
    }
    return false;
  }
  
  public static void fillRoom(int x, int y,int roomNum)
  {
    if (x<0||y<0||x>2*m||y>2*n)return;
    String coord =(x)+","+(y);
    if (rooms.get(roomNum).contains(coord))return;
    rooms.get(roomNum).add (coord);
    //   System.out.println ("pass");
    //north
    if (y-1>-1&&floor[y-1][x]=='.')
      fillRoom(x, y-2,roomNum);
    //east
    if (x+1<2*m+1&&floor[y][x+1]=='.')
      fillRoom(x+2, y,roomNum);
    //south
    if (y+1<2*n+1&&floor[y+1][x]=='.')
      fillRoom( x, y+2, roomNum);
    //west
    if (x-1>-1&&floor[y][x-1]=='.')
      fillRoom(x-2,  y, roomNum);
  }
}