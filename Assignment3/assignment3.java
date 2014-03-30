// Assignment 3: hashing
// Using a hash table to store data  about pictures, and retrieve the picture

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
         filePath = fileInput.nextLine();
         
         key = getKey(name);
         
         entry = new HashEntry(name, description, size, filePath, key);
         
         table.insertElement(entry);
         
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
