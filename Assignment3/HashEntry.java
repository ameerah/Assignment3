// stores each entry of the hash table
// contains each bit of information for each picture

public class HashEntry
{
   String fileName = null;
   String description = null;
   String fileSize = null;
   String path = null;
   int key = 0;
   String reference; // contains relative path
   int displayIndex; // this is what is actually used as the reference
   
   // get methods
   public int getKey()
   {
      return key;
   }
   
   public String getName()
   {
      return fileName;
   }
   
   public int getDisplayIndex()
   {
      return displayIndex;
   }
   
   // set methods
   
   public void setDisplayIndex(int num)
   {
      displayIndex = num;
   }
      
   public void setReference(String pth)
   {
      // setting the reference as a relative path (so substring of the actual path)
      // in some case the path doesn't exist
      //System.out.println(pth+"");
      if (pth.equals(""))
      {
         reference = "This path does not exist.";
      }
      else
      {
         int length = ("C:\\Users\\Anna\\Documents\\DS2").length(); // cuts off the bit for the absolute path
         reference = pth.substring(length+4);
      }
   }
   
   // constructor
   public HashEntry(String name, String desc, String size, String filePath, int nameKey)
   {
      fileName = name;
      description = desc;
      fileSize = size;
      path = filePath;
      key = nameKey;
      
      setReference(path);
   }

}