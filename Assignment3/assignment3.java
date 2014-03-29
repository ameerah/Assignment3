// Assignment 3: hashing
// Using a hash table to store data  about pictures, and retrieve the picture

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class assignment3
{
	public static void main(String[] args)
	{
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
      
      String name;
      String description;
      String size;
      String filePath;
      HashEntry entry;
      
      fileInput.useDelimiter(",");
      while (fileInput.hasNextLine())
      {
         name = fileInput.next();
         description = fileInput.next();
         size = fileInput.next();
         filePath = fileInput.nextLine();
         
         entry = new HashEntry(name, description, size, filePath);
      }
	}
}
