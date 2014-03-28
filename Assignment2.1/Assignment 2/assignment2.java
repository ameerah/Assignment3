// CSC2001F Assignment 2: Binary Search Tree to track popularity of name / surname
// 19 March 2014
// Ameerah Allie (ALLAME002)

// driver class

// import ncessary packages
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class assignment2
{   
   public static void main(String[] args)
   {
      // creates empty trees
      BinarySearchTree nameBST = new BinarySearchTree();
      BinarySearchTree surnameBST = new BinarySearchTree();
      
      createBinaryTree(nameBST, surnameBST); // Adds to trees
      
      // print traversals
      System.out.println("Name BST Traversed In Order");
      nameBST.inOrderTraversal(nameBST.root);
      System.out.println("\nSurname BST Traversed Post Order");
      surnameBST.postOrderTraversal(surnameBST.root);
   }
   
   
   // method creates Binary Search Tree objects; calls for nodes to be added and passes key and other info on to node
   public static void createBinaryTree(BinarySearchTree nameTree, BinarySearchTree surnameTree)
   {
      // initialising necessary variables
      String line;
      String name;
      String surname;
      int nameKey;
      int surnameKey;
      
      // Scanner class used in gathering input
      Scanner fileInput = null;
      
      //try-catch decision tree for handling exceptions
      try{
         fileInput = new Scanner(new FileInputStream("toSearchIn.txt")); // input to come from file
      }
      catch(FileNotFoundException e)
      {
         System.out.println("The file was not found.");
         System.exit(0);
      }
      
      // while the file still has lines in it, reads in name and surname and adds to respective trees "simultaneously"
      while (fileInput.hasNextLine())
      {
         name = fileInput.next().trim();
         surname = fileInput.nextLine().trim();
         
         Node nameNode = new Node(null, null);
         Node surnameNode = new Node(null, null);
         
         // converts name and surname to ascii for key
         nameKey = getKey(name);
         surnameKey = getKey(surname);
         nameNode.setKey(nameKey);
         surnameNode.setKey(surnameKey);
         nameNode.setName(name);
         surnameNode.setName(surname);
         
         // adds node to respective BST
         nameTree.createNode(nameNode, nameTree.root);
         surnameTree.createNode(surnameNode, surnameTree.root);
      }
      
   }
   
   //method for determining key of node
   public static int getKey(String name)
   {
      int length = name.length();
      char character;
      int ascii = 0;
      int sum = 0;
      
      // iterates through every character in the String passed, determines its ascii code and sums it
      for (int i=0; i < length; i++)
      {
         character = name.charAt(i);
         ascii = (int) character;
         sum = sum + ascii;
      }
      
      return sum;
   }


}