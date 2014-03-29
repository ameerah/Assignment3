// Class that creates the hash table object
// For a small problem size like this, there is a negligible difference in using an array vs using a binary search tree (for image retrieval)
// If anything, the array setup is quicker to code so the trade-off in efficiency vs coding time is not worth it (#smartProgramming)

public class HashTable
{
   public void initialiseTable()
   {
      // creates table of 2D array of strings (the file size is not used or considered in this problem so we do not need to process it as a float)
      // so it isn't worth it to use a data structure that stores multiple types of data since they're less efficient when we don't need file size as a float
      HashEntry[][] table = new HashEntry[7][4];
   }
   
   public void insertElement(HashEntry newItem)
   {
      // use quadratic probing to check availability
   }
}