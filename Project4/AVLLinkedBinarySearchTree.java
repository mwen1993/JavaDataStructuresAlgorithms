//********************************************************************
// AVLLinkedBinarySearchTree.java      
//
// Implements the AVL Binary Search Tree with links
// - Bob Wilson 05/11/2015
// - uses balance factor attribute stored in node 
//********************************************************************

public class AVLLinkedBinarySearchTree<T extends Comparable<T>>
{
   protected int count;
   protected AVLBinarySearchTreeNode<T> root;
   
   /******************************************************************
     Creates an empty binary search tree.
   ******************************************************************/
   public AVLLinkedBinarySearchTree() 
   {
      root = null;
      count = 0;
   }
      
   public boolean isEmpty()
   {
     return count == 0;
   }

   /******************************************************************
     Adds the specified object to the binary search tree in the
     appropriate position according to its key value.  Note that
     equal elements are added to the right.  Rebalances after adding.
   ******************************************************************/
   public void addElement (T element) 
   {
      AVLBinarySearchTreeNode<T> node = new AVLBinarySearchTreeNode<T> (element);

      if (isEmpty())
         root = node;
      else 
      {
         AVLBinarySearchTreeNode<T> current = root;
         boolean added = false;

         while (!added) 
         {
            if (element.compareTo(current.element) < 0)
            {
               if (current.left == null) 
               {
                  current.left = node;
                  node.parent = current;
                  added = true;
               } 
               else
                  current = current.left;
            }
            else
            {
               if (current.right == null) 
               {
                  current.right = node;
                  node.parent = current;
                  added = true;
               } 
               else
                  current = current.right;
            }
         }
            
         // now go back up the tree rebalancing
         while (current != null) {
           if (node == current.left)               // if added node is left child of current
             current.balanceFactor--;              //   decrement balance factor
           else                                    // else node is right child of current
             current.balanceFactor++;              //   increment balance factor

           if (current.balanceFactor == 0) //{     // did we only lengthen the shorter tree?
             break;                                // yes, so we are done

           if (rebalance(current))                 // check on need for rebalancing
             break;                                // if we rebalanced, we are done
           else {                                  // else we didn't rebalance,
             node = current;                       // so continue up the tree
             current = node.parent;
           }
         }
      }
      count++;  
   }
   
   private boolean rebalance(AVLBinarySearchTreeNode<T> node)
   {
     // AVL tree logic for addElement and removeElement methods
     // determine if any need for rotation at this node and rebalance
     // if rebalance performed, return true - otherwise return false

     // TODO: add your code here

    if(node.balanceFactor == -2){
      if(node.left.balanceFactor <= 0){
        rotateRight(node);
        System.out.println("Perform right rotation around: " + node);
      }
      else{ // node left child balanace factor is 1
        //perform left right
        rotateLeft(node.left);
        node.left.balanceFactor -= 1;
        rotateRight(node);
        System.out.println("Perform left-right rotation around: " + node);
      }
      return true;
    } 
    else if(node.balanceFactor == 2){
      if(node.right.balanceFactor >= 0){
        rotateLeft(node);
        System.out.println("Perform left rotation around: " + node);
      }
      else{ //node right child balance factor is -1
        //perform right-left 
        rotateRight(node.right);
        node.right.balanceFactor += 1;
        rotateLeft(node);
        System.out.println("Perform right-left rotation around: " + node);
      }
      return true;
    }

    return false;   // stub to allow it to compile

   }

   private void rotateLeft(AVLBinarySearchTreeNode<T> pivot)
   {
     AVLBinarySearchTreeNode<T> parent = pivot.parent;
     AVLBinarySearchTreeNode<T> newPivot = pivot.right;
     newPivot.parent = pivot.parent;
     
     if (parent != null) {        // we are attached to a node in the path to the root
       if (pivot == parent.left)
         parent.left = newPivot;  // on the left
       else
         parent.right = newPivot; // on the right
     } 
     else                         // or we are at root of the tree
       this.root = newPivot;
     
     pivot.right = newPivot.left;
     if (pivot.right != null)
        pivot.right.parent = pivot;
     
     newPivot.left = pivot;
     pivot.parent = newPivot;
     
     // adjust balance factors
     // TODO: add your code here

     //pivot will always have balance factor of 2, so check right child
     //right child balance factor could be 1 or 0
     if(newPivot.balanceFactor == 1)
      pivot.balanceFactor -= 2;
     else //right child balance factor is 0
      pivot.balanceFactor -= 1;

     newPivot.balanceFactor -= 1;
   }
   
   private void rotateRight(AVLBinarySearchTreeNode<T> pivot)
   {
     AVLBinarySearchTreeNode<T> parent = pivot.parent;
     AVLBinarySearchTreeNode<T> newPivot = pivot.left;
     newPivot.parent = pivot.parent;

     if (parent != null) {        // we are attached to a node in the path to the root
       if (parent.left == pivot)
         parent.left = newPivot;  // on the left
       else
         parent.right = newPivot; // on the right
     }
     else                         // or we are at root of the tree
       this.root = newPivot;
     
     pivot.left = newPivot.right;
     if (pivot.left != null)
       pivot.left.parent = pivot;
     
     newPivot.right = pivot;
     pivot.parent = newPivot;
     
     // adjust balance factors
     // TODO: add your code here
     
     //pivot will always have balance factor of -2, so check left child
     //left child balance factor could be -1 or 0
     if(newPivot.balanceFactor == -1)
      pivot.balanceFactor += 2;
     else //left child balance factor is 0
      pivot.balanceFactor += 1;

     newPivot.balanceFactor += 1;
   }
   
   /******************************************************************
     Removes the first element that matches the specified target
     element from the binary search tree and returns a reference to
     it.  Returns null if the specified target element is not found.
   ******************************************************************/
   public T removeElement (T targetElement)
   {
      T result = null;

      AVLBinarySearchTreeNode<T> current = root;           // start at root
      boolean found = false;
      while (current != null && !found) {                  // look for target
        if (targetElement.equals(current.element)) { 
          found = true;
          count--;
          result =  current.element;
        } // end found
        else                                               // keep looking
        {
          if (targetElement.compareTo(current.element) < 0)
            current = current.left;
          else
            current = current.right;
        }
      } // end while
      
      // after a successful find, complete the updating and rebalancing of tree
      if (result != null) {
        // move replacement elements upward until we reach a leaf that can be removed
        AVLBinarySearchTreeNode<T> newCurrent = replacement(current);
        while (newCurrent != null) {
          current.element = newCurrent.element;
          current = newCurrent;
          newCurrent = replacement(current);
        }
           
        if (current == root)   // if we are still at the root, we just remove last node
          root = null;
        else {
          // remove leaf node that is now irrelevent and rebalance upward
          if (current == current.parent.left) {    // if we are removing a left child
            current.parent.left = null;            //   so remove it
            current.parent.balanceFactor++;        //   and increment parent balance factor
          }
          else {                                   // else we are removing a right child
            current.parent.right = null;           //   so remove it
            current.parent.balanceFactor--;        //   and decrement parent balance factor
          }
                  
          // rebalance upward from parent of removed leaf node up to and including the root
          do {
            current = current.parent;              // move up a level
            if (rebalance(current) || current.balanceFactor != 0)
              break;                               // just rebalanced or don't need to
            if (current != root)                   // if not at root, update parent balance factor
              if (current == current.parent.left)
                current.parent.balanceFactor++;
              else
                current.parent.balanceFactor--;
          } while (current != root);               // and loop until we are at the root
        }
      }
      return result;
   }

   /******************************************************************
     Returns a reference to a node that will replace the one
     specified for removal.  In the case where the removed node has 
     two children, the inorder successor is used as its replacement.
   ******************************************************************/
   private AVLBinarySearchTreeNode<T> replacement (AVLBinarySearchTreeNode<T> node) 
   {
      AVLBinarySearchTreeNode<T> result = null;

      if ((node.left == null)&&(node.right==null))
         result = null;
      
      else if ((node.left != null)&&(node.right==null))
         result = node.left;
      
      else if ((node.left == null)&&(node.right != null))
         result = node.right;
      
      else
      {
         // to find "inorder successor" 
         // go down one level on the right
         AVLBinarySearchTreeNode<T> current = node.right;
         
         // and go down as many levels as possible on the left
         while (current.left != null)
            current = current.left;
         result = current;
      }
      return result;
   }
   
   public void displayState()
   {
     System.out.println("-------------------------\nState of Tree at Top");
     if (root != null) {
       System.out.println("Root Element: " + root.element);
       System.out.println("Balance Factor: " + root.balanceFactor);
       System.out.println("Parent: " + root.parent);
       System.out.println();
       if (root.left != null) {
         System.out.println("Left Element: " + root.left.element);
         System.out.println("Balance Factor: " + root.left.balanceFactor);
         System.out.println("Parent: " + root.left.parent.element);
         System.out.println();
       
         if (root.left.left != null) {
           System.out.println("Left Left Element: " + root.left.left.element);
           System.out.println("Balance Factor: " + root.left.left.balanceFactor);
           System.out.println("Parent: " + root.left.left.parent.element);
           System.out.println();
         }
         if (root.left.right != null) {
           System.out.println("Left Right Element: " + root.left.right.element);
           System.out.println("Balance Factor: " + root.left.right.balanceFactor);
           System.out.println("Parent: " + root.left.right.parent.element);
           System.out.println();
         }
       }
       if (root.right != null) {
         System.out.println("Right Element: " + root.right.element);
         System.out.println("Balance Factor: " + root.right.balanceFactor); 
         System.out.println("Parent: " + root.right.parent.element);
         System.out.println();
         if (root.right.left != null) {
           System.out.println("Right Left Element: " + root.right.left.element);
           System.out.println("Balance Factor: " + root.right.left.balanceFactor); 
           System.out.println("Parent: " + root.right.left.parent.element);
           System.out.println();
         }
         if (root.right.right != null) {
           System.out.println("Right Right Element: " + root.right.right.element);
           System.out.println("Balance Factor: " + root.right.right.balanceFactor); 
           System.out.println("Parent: " + root.right.right.parent.element);
         }
       }
     }
   System.out.println("----------------------------");
   }
}
