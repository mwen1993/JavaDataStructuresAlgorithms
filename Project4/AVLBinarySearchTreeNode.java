import java.util.*;

//*******************************************************************
//  AVLBinarySearchTreeNode.java               
//
//  Represents a node in an AVL binary search tree
//  with left child, right child, and parent nodes
// - Bob Wilson 04/30/2015
// - uses balance factor attribute stored in node 
//*******************************************************************

public class AVLBinarySearchTreeNode<T extends Comparable<T>>
{
   protected T element;
   protected AVLBinarySearchTreeNode<T> left, right, parent;
   protected int balanceFactor;

   /*****************************************************************
     Creates a new tree node with the specified data.
   *****************************************************************/
   public AVLBinarySearchTreeNode (T obj) 
   {
     element = obj;
     left = right = parent = null;
     balanceFactor = 0;
   }
   
   public String toString()
   {
     return "" + element;
   }
}
