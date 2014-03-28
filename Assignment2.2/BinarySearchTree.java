// Assignment2
// Binary Search Tree class: defines what BSTs are and gives methods to them
// Enables them to populate tree with nodes to make a non-empty tree

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BinarySearchTree
{  
   Node root = null;
   
   // method to populate tree with nodes   
   public void createNode(Node newNode, Node currentNode)
   {
      
      if (root == null)
      {
         root = newNode;
      }
      else
      {
         if (newNode.getKey() < currentNode.getKey())
         {
            // new node has a lesser key; needs to be added on the left
            // if left child doesn't exist for this current node, we can add the new node as its left child
            if (currentNode.getLeftChild() == null)
            {
               currentNode.setLeftChild(newNode);
            }
            // else examine the left subtree for vacancies
            else
            {
               createNode(newNode, currentNode.getLeftChild());
            }
         }
         else if (newNode.getKey() > currentNode.getKey())
         {
            // new node has a greater key; needs to be added on the right
            // if right child doesn't exist for this current node, we can add the new node as its right child
            if (currentNode.getRightChild() == null)
            {
               currentNode.setRightChild(newNode);
            }
            // else examine the right subtree for vacancies
            else
            {
               createNode(newNode, currentNode.getRightChild());
            }

         }
         else if (currentNode.getKey() == newNode.getKey())
         {
            // new node to be added and node being looked at's keys are equal
            // need to consider whether or not the names stored in the nodes are equal
            // if they are equal, update the count
            if ((currentNode.getName()).equals(newNode.getName()))
            {
               currentNode.addToCount();
            }
            // else, insert the new node on the left tree
            // we're not concerned about imbalances right now so it would be alright to just insert it between...
            // ...the current left child and of this node with an equivalent key and still keep the BST conditions
            else
            {
               newNode.setLeftChild(currentNode.getLeftChild());
               currentNode.setLeftChild(newNode);
            }
         }
      }
   }
   
   // traversal methods
   public void inOrderTraversal(Node startingNode)
   {
      if (startingNode == null) { return; }
      
      inOrderTraversal(startingNode.leftChild);
      
      System.out.println("key: "+startingNode.nodeKey+", "+"name"+": "+startingNode.nodeName+", count: "+startingNode.count);
      
      inOrderTraversal(startingNode.rightChild);
   }
   
   public void postOrderTraversal(Node startingNode)
   {
      if (startingNode == null) { return; }
      
      postOrderTraversal(startingNode.leftChild);
      
      postOrderTraversal(startingNode.rightChild);
      
      System.out.println("key: "+startingNode.nodeKey+", "+"surname"+": "+startingNode.nodeName+", count: "+startingNode.count);
   }
}
