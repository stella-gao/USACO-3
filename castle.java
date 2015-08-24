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
    Scanner s=new Scanner (new File("castle.in"));
    //Scanner s=new Scanner (new File("in.txt"));
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
        Arrays.fill (walls[y][x],-1);
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
    
    //setup walls
    for (int y=1;y<n+1;y++)
    {
      for (int x=1;x<m+1;x++)
      {
        if (y>1&&floor[2*y-2][2*x-1]=='#')
        {
          //0-north 1-south
          walls[2*y-2][2*x-1][0]=roomContain((2*x-1)+","+(2*y-3));
          walls[2*y-2][2*x-1][1]=roomContain((2*x-1)+","+(2*y-1));
        }
        if (x<m&&floor[2*y-1][2*x]=='#')
        {
          //0-west 1-east
          walls[2*y-1][2*x][0]=roomContain((2*x-1)+","+(2*y-1));
          walls[2*y-1][2*x][1]=roomContain((2*x+1)+","+(2*y-1));
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
    max=0;
    int wallX=0;
    int wallY=0;
    char dir=' ';
    for (int x=1;x<m+1;x++)
    {
      for (int y=n;y>0;y--)
      {
        //North
        if (y>1&&floor[2*y-2][2*x-1]=='#')
        {
          if (walls[2*y-2][2*x-1][0]!= walls[2*y-2][2*x-1][1])
            modifiedMax=rooms.get(walls[2*y-2][2*x-1][0]).size()+rooms.get(walls[2*y-2][2*x-1][1]).size();
          else
            modifiedMax=rooms.get(walls[2*y-2][2*x-1][0]).size();
          if (modifiedMax>max)
          {
            max=modifiedMax;
            wallX=x;
            wallY=y;
            dir='N';
          }
          if (modifiedMax==absMax)break;
        }
        //East
        if (x<m&&floor[2*y-1][2*x]=='#')
        {
          if (x<m&&floor[2*y-1][2*x]=='#')
          {
            if (walls[2*y-1][2*x][0]!=walls[2*y-1][2*x][1])
              modifiedMax=rooms.get(walls[2*y-1][2*x][0]).size()+rooms.get(walls[2*y-1][2*x][1]).size();
            else
              modifiedMax=rooms.get(walls[2*y-1][2*x][0]).size();
            if (modifiedMax>max)
            {
              max=modifiedMax;
              wallX=x;
              wallY=y;
              dir='E';
            }
            if (modifiedMax==absMax)break;
          }
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
  
  public static int roomContain(String coord)
  {
    for (int x=0;x<rooms.size();x++)
    {
      if (rooms.get(x).contains (coord))
        return x;
    }
    return -1;
  }
}