// stores each entry of the hash table
// contains each bit of information for each picture

//import java.nio.file;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HashEntry
{
   String fileName = null;
   String description = null;
   String fileSize = null;
   String path = null;
   int key = 0;
   Path reference = null; // link to 
   
   // get methods
   public int getKey()
   {
      return key;
   }
   
   // set methods
   
   public HashEntry(String name, String desc, String size, String filePath, int nameKey)
   {
      fileName = name;
      description = desc;
      fileSize = size;
      path = filePath;
      System.out.println("---"+path+"---");
      key = nameKey;
      
      setReference(path);
   }
   
   public void setReference(String pth)
   {
      // setting the reference as a relative path (so substring of the actual path)
      int length = ("C:\\Users\\Anna\\Documents\\DS2\\").length();
      reference = Paths.get(pth.substring(length));
   }
   
   // constructor method
   /**public HashEntry(String name, String desc, String size, String filePath, int nameKey)
   {
      fileName = name;
      description = desc;
      fileSize = size;
      path = filePath;
      key = nameKey;
   }
   **/
}