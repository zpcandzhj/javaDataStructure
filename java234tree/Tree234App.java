package java234tree;

import java.io.*;

public class Tree234App {

	public static void main(String[] args) throws IOException
    {
    long value;
    Tree234 theTree = new Tree234();
    theTree.insert(3);
    theTree.insert(50);
    theTree.insert(50);
    theTree.insert(40);
    theTree.insert(60);
    theTree.insert(30);
    theTree.insert(80);

    while(true)
       {
       System.out.println("Enter first letter of  show, insert, or find:");
       System.out.print("Enter x to exit: ");
       char choice = getChar();
       switch(choice)
          {
          case 's':
             theTree.displayTree();
             break;
          case 'i':
             System.out.print("Enter value to insert: ");
             value = getInt();
             theTree.insert(value);
             break;
          case 'f':
             System.out.print("Enter value to find: ");
             value = getInt();
             int found = theTree.find(value);
             if(found != -1)
                System.out.println("Found "+value);
             else
                System.out.println("Could not find "+value);
             break;
          case 'x':
        	  System.exit(0);
          default:
             System.out.print("Invalid entry\n");
          }  // end switch
       }  // end while
    }  // end main()
//--------------------------------------------------------------
 public static String getString() throws IOException
    {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
    }
//--------------------------------------------------------------
 public static char getChar() throws IOException
    {
    String s = getString();
    return s.charAt(0);
    }

//-------------------------------------------------------------
 public static int getInt() throws IOException
    {
    String s = getString();
    return Integer.parseInt(s);
    }
}
