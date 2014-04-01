// Class that creates the hash table object
// For a small problem size like this, there is a negligible difference in using an array vs using a binary search tree (for image retrieval)
// If anything, the array setup is quicker to code so the trade-off in efficiency vs coding time is not worth it (#smartProgramming)

public class HashTable
{
   int tableSize;
   HashEntry[] table;
   
   // constructor method
   public HashTable(int size)
   {
      // creates table using array of strings (the file size is not used or considered in this problem so we do not need to process it as a float)
      // so it isn't worth it to use a data structure that stores multiple types of data since they're less efficient when we don't need file size as a float
      tableSize = size;
      table = new HashEntry[size];      
   }
   
   public void insertElement(HashEntry newItem)
   {
      // use linear probing to check availability; with a hash table this small we don't need to concern ourselves with clustering
      int key = newItem.getKey();
      
      // use hash function to determine place of insertion
      int index = ((key)%(tableSize))+1;
      
      // while the new entry has not been inserted, linear probe to check where the next open slot it
      boolean inserted = false;
      while (inserted == false)
      {
         if (table[index] == null)
         {
            table[index] = newItem;
            inserted = true;
         }
         else
         {
            if (index < (tableSize - 1))
            {
               index += 1;
            }
            else
            {
               index = 0;
            }
         }
      }
   }
   
   public int getLength()
   {
      return tableSize;
   }
}