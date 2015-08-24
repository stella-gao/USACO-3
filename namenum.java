/*
 ID: Benson.2
 LANG: JAVA
 TASK: namenum
 */
import java.io.*;
import java.util.*;

public class namenum
{
  static String[] valid;
  static int count=0;
  static int validnum=0;
  static String[] code=new String[]{"","","ABC","DEF","GHI","JKL","MNO","PRS","TUV","WXY"};
  public static void main (String[]args)throws IOException
  {
    Scanner s=new Scanner (new File("namenum.in"));
    Scanner t=new Scanner (new File("dict.txt"));
    PrintWriter out=new PrintWriter (new FileWriter("namenum.out"));
    String []dict=new String[4617];
    String num=s.next();
    int numLength=num.length();
    // valid=new String[(int)Math.pow(3,num.length())];
    
    // recurse("",num);
    
    for (int w=0;w<4617;w++)
      dict[w]=t.next();
    
//    for (int x=0;x<valid.length;x++)
//    {
//      if (Arrays.binarySearch(dict,valid[x])>=0)
//      {
//        out.println (valid[x]);
//        validnum++;
//      }
//    }
    
    for (int x=0;x<4617;x++)
    {
      boolean valid=true;
      if (dict[x].length()!=numLength)
        continue;
      for (int y=0;y<num.length();y++)
      {
        int dig=Integer.parseInt(num.substring(y,y+1));
        if (code[dig].charAt(0)!=dict[x].charAt(y)&&code[dig].charAt(1)!=dict[x].charAt(y)&&code[dig].charAt(2)!=dict[x].charAt(y))
        {
          valid=false;
          break;
        }
      }
      
      if (valid)
      {
        out.println (dict[x]);
        validnum++;
      }
    }
    if (validnum==0)
      out.println ("NONE");
    out.close();
    
  }
  
  public static void recurse (String number,String n)
  {
    if (number.length()==n.length())
    {
      String name="";
      for (int x=0;x<n.length();x++)
      {
        int pos=Integer.parseInt(n.substring(x,x+1));
        int digit=Integer.parseInt(number.substring(x,x+1));
        name+=code[pos].substring(digit,digit+1);
        valid[count]=name;
      }
      count++;
      return;
    }
    recurse(number+"0",n);
    recurse(number+"1",n);
    recurse(number+"2",n);
  }
  
}