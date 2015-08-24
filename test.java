//ID:benson.2
//LANG:JAVA
//TASK:test

import java.io.*;
import java.util.*;

public Test
{
  public static void main (String[]args) throws IOException
  {
    Scanner s=new Scanner (new File ("test.in"));
    PrintWriter out=new PrinterWriter (new FileWriter ("test.out"));
    out.println (s.nextInt()+s.nextInt());
    out.close();
  }
}