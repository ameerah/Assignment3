// stores each entry of the hash table
// contains each bit of information for each picture

public class HashEntry
{
   String fileName = null;
   String description = null;
   String fileSize = null;
   String path = null;
   
   // get methods
   
   
   
   // set methods
   
   public void setDetails(String name, String desc, String size, String filePath)
   {
      fileName = name;
      description = desc;
      fileSize = size;
      path = filePath;
   }
   
   // constructor method
   public HashEntry(String name, String desc, String size, String filePath)
   {
      fileName = name;
      description = desc;
      fileSize = size;
      path = filePath;
   }
}