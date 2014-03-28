// Assignment 2
// Node class: defines children belonging to a node; allows values to be assigned to node variables

public class Node
{
   // defines node properties
   int nodeKey;
   int count = 1;
   String nodeName;
   
   // defines children attached to node or lack thereof
   Node leftChild;
   Node rightChild;
   
   // constructor for node
   Node(Node lc, Node rc)
   {
      leftChild = lc;
      rightChild = rc;
   }
   
   // get methods
   public Node getLeftChild()
   {
      return leftChild;
   }
   public Node getRightChild()
   {
      return rightChild;
   }
   public int getKey()
   {
      return nodeKey;
   }
   public String getName()
   {
      return nodeName;
   }
   
   // set methods
   public void setRightChild(Node rc)
   {
      rightChild = rc;
   }
   public void setLeftChild(Node lc)
   {
      leftChild = lc;
   }
   
   public void setKey(int key)
   {
      nodeKey = key;
   }
   public void setName(String name)
   {
      nodeName = name;
   }
   
   // updates count variable
   public void addToCount()
   {
      count += 1;
   }
   
}

