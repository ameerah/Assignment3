// Assignment 3: hashing
// Using a hash table to store data  about pictures, and retrieve the picture

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.Runtime;

public class assignment3
{
	public static void main(String[] args)
	{
		// get input from CSV file
      Scanner fileInput = null;
      try
      {
         fileInput = new Scanner(new FileInputStream("picture.csv"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found.");
      }
      
      // note to self: Scanner class reads up to the delimiter and removes it from the file but discards it (not included in returned string)
      fileInput.nextLine(); // discards line with headings
      
      // create table of size 13 (only 7 pictures to account for so 13 is for extra space)
      HashTable table = new HashTable(13);
      
      // create variables for elements in table
      String name;
      String description;
      String size;
      String filePath;
      HashEntry entry;
      int key;
      
      // process each line of input for creation of element for insertion into hash table
      fileInput.useDelimiter(",");
      while (fileInput.hasNextLine())
      {
         name = fileInput.next();
         description = fileInput.next();
         size = fileInput.next();
         filePath = (fileInput.nextLine()).substring(1);
         
         key = getKey(name);
	
         entry = new HashEntry(name, description, size, filePath, key);
         
         table.insertElement(entry);         
      }
      fileInput.close(); // closes scanner
      
      // obtains input for file retrieval section
      Scanner userInput = new Scanner(System.in);
      displayOpen(); // displays welcome message below
      String choice = userInput.nextLine();
      int picture;
      
      while (choice.equalsIgnoreCase("Y"))
      {
         displayMenu(table); // displays contents of menu
         
         System.out.println("............................................................");
         System.out.println("Would you like to see another?");
         System.out.println("Press \'Y\' to display a menu of pictures or \'N\' to quit.");
         System.out.println("............................................................");
         choice = userInput.nextLine();
      }
      
      // me, being nice. casual.
      System.out.println("............................................................");
      System.out.println("Thank you! Have a nice day.");
      System.out.println("............................................................");
      
	}
   
   public static void displayOpen()
   {
      // displays welcome message
      System.out.println("............................................................");
      System.out.println("Hello! Would you like to view some pictures?");
      System.out.println("Press \'Y\' to display a menu of pictures or \'N\' to quit.");
      System.out.println("............................................................");
   }
   
   public static void displayMenu(HashTable htab)
   {
      // rather than manually typing what to print out, this iterates through the array and prints the name
      int count = 1;
      String label;
      for (int i = 0; i <= ((htab).getLength() - 1); i++)
      {
         if (htab.table[i] != null)
         {
            label = htab.table[i].getName();
            System.out.println(count + ". " + label);
            htab.table[i].setDisplayIndex(count);
            count += 1;
         }
      }
      
      System.out.println("\nEnter the number of the picture you wish to view:");
      
      Scanner keyboard = new Scanner(System.in);
      int picture = keyboard.nextInt(); // gets index of item
      
      // ACTUAL RETRIEVAL PART; compares index
      for (int i = 0; i <= ((htab).getLength() - 1); i++)
      {
         if (htab.table[i] != null)
         {
            if (htab.table[i].getDisplayIndex() == picture)
            {
               displayPicture(((htab).table[i]).getName()); // retrieves name; uses name as reference
               // that file path thing was unnecessary but I left it in anyway
            }
         }
      }
   }
   
   public static void displayPicture(String fileName)
   {
      // uses an object to run a command line prompt to display picture
      try
      {
         Runtime commandPrompt = Runtime.getRuntime();
         commandPrompt.exec("display " + fileName);
      }
      catch (Throwable t)
      {
         System.out.println("Could not display file! Perhaps it doesn't exist?");
      }
   }
   
   public static int getKey(String fileName)
   {
      // remove the ".jpg" by finding out how long the name itself is
      int nameLength = fileName.length();
      int index = nameLength - 3; // finds index at which substring should end
      
      // slice the ".jpg" bit off
      fileName = fileName.substring(0,index);
      
      // variables for determining key
      char character;
      int ascii = 0;
      int sum = 0;
      
      // iterates through every character in the String passed, determines its ascii code and sums it
      for (int i=0; i < index; i++)
      {
         character = fileName.charAt(i);
         ascii = (int) character;
         sum = sum + ascii;
      }
      
      return sum;
   }
}
