import junit.framework.TestCase;

/**
 * AVLTreeTest1.java
 * 4/30/2015
 * Bob Wilson
 * Tests left rotations and right rotations
 */

public class AVLTestTree1 extends TestCase
{
  // left rotation test cases - 3 nodes
  public void testL3()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("a");                                  // adds root
    assertTrue(myTree.root.element.equals("a"));
    assertEquals( 0,myTree.root.balanceFactor);
    myTree.addElement("b");                                  // no rotation expected
    assertTrue(myTree.root.element.equals("a"));
    assertEquals(+1,myTree.root.balanceFactor);
    myTree.addElement("c");                                  // left rotation around a expected
    assertTrue(myTree.root.element.equals("b"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("c"));
    assertEquals( 0,myTree.root.right.balanceFactor);

    // check again after unbalanced removes
    assertEquals("a",myTree.removeElement("a"));             // no rotation expected
    assertTrue(myTree.root.element.equals("b"));    
    assertEquals(+1,myTree.root.balanceFactor);
    
    assertEquals("b",myTree.removeElement("b"));             // removing the root
    assertTrue(myTree.root.element.equals("c"));
    assertEquals( 0,myTree.root.balanceFactor);
    
    assertEquals("c",myTree.removeElement("c"));             // removing the root
    assertEquals(null,myTree.root);                          // tree should be empty
  }
  
  // left rotation test cases - 7 nodes
  public void testL7()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("a");                                 // no rotation expected
    myTree.addElement("b");                                 // no rotation expected
    myTree.addElement("c");                                 // left rotation around a expected
    myTree.addElement("d");                                 // no rotation expected
    myTree.addElement("e");                                 // left rotation around c expected
    myTree.addElement("f");                                 // left rotation around b expected
    myTree.addElement("g");                                 // left rotation around e expected
    
    // check state of the tree after a sequence of unbalanced adds
    assertTrue(myTree.root.element.equals("d"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("c"));
    assertEquals( 0,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("e"));
    assertEquals( 0,myTree.root.right.left.balanceFactor);
    assertTrue(myTree.root.right.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.right.balanceFactor);
    
    // check again after unbalanced removes
    assertEquals("a",myTree.removeElement("a"));             // no rotation expected
    assertTrue(myTree.root.element.equals("d"));    
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(+1,myTree.root.left.balanceFactor);
    
    assertEquals("b",myTree.removeElement("b"));             // no rotation expected
    assertTrue(myTree.root.element.equals("d"));
    assertEquals(+1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("c"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    
    assertEquals("c",myTree.removeElement("c"));             // left rotation around d expected
    assertTrue(myTree.root.element.equals("f"));
    assertEquals(-1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("d"));
    assertEquals(+1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("e"));
    assertEquals( 0,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    
    assertEquals("d",myTree.removeElement("d"));             // no rotation expected
    assertTrue(myTree.root.element.equals("f"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("e"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    
    assertEquals("e",myTree.removeElement("e"));             // no rotation expected
    assertTrue(myTree.root.element.equals("f"));
    assertEquals(+1,myTree.root.balanceFactor);
    
    assertEquals("f",myTree.removeElement("f"));             // no rotation expected
    assertTrue(myTree.root.element.equals("g"));
    assertEquals( 0,myTree.root.balanceFactor);
    
    assertEquals("g",myTree.removeElement("g"));             // no rotation expected
    assertEquals(null,myTree.root);                          // tree should be empty
  }
  
  // right rotation test cases - 3 nodes
  public void testR3()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");                                  // adds root
    assertTrue(myTree.root.element.equals("c"));
    assertEquals( 0,myTree.root.balanceFactor);
    myTree.addElement("b");                                  // no rotation expected
    assertTrue(myTree.root.element.equals("c"));
    assertEquals(-1,myTree.root.balanceFactor);
    myTree.addElement("a");                                  // left rotation around c expected
    assertTrue(myTree.root.element.equals("b"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("c"));
    assertEquals( 0,myTree.root.right.balanceFactor);

    // check again after unbalanced removes
    assertEquals("c",myTree.removeElement("c"));             // no rotation expected
    assertTrue(myTree.root.element.equals("b"));    
    assertEquals(-1,myTree.root.balanceFactor);
    
    assertEquals("b",myTree.removeElement("b"));             // removing the root
    assertTrue(myTree.root.element.equals("a"));
    assertEquals( 0,myTree.root.balanceFactor);
    
    assertEquals("a",myTree.removeElement("a"));             // removing the root
    assertEquals(null,myTree.root);                          // tree should be empty
  }
  
  // right rotation test cases - 7 nodes
  public void testR7()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("g");                                 // no rotation expected
    myTree.addElement("f");                                 // no rotation expected
    myTree.addElement("e");                                 // right rotation around g expected
    myTree.addElement("d");                                 // no rotation expected
    myTree.addElement("c");                                 // right rotation around e expected
    myTree.addElement("b");                                 // right rotation around f expected
    myTree.addElement("a");                                 // right rotation around c expected
    // check state of the tree after a sequence of unbalanced adds
    assertTrue(myTree.root.element.equals("d"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("c"));
    assertEquals( 0,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("e"));
    assertEquals( 0,myTree.root.right.left.balanceFactor);
    assertTrue(myTree.root.right.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.right.balanceFactor);
    
    // check again after unbalanced removes
    assertEquals("g",myTree.removeElement("g"));             // no rotation expected
    assertTrue(myTree.root.element.equals("d"));    
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals(-1,myTree.root.right.balanceFactor);
    
    assertEquals("f",myTree.removeElement("f"));             // no rotation expected
    assertTrue(myTree.root.element.equals("d"));
    assertEquals(-1,myTree.root.balanceFactor);
    assertTrue(myTree.root.right.element.equals("e"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    
    assertEquals("e",myTree.removeElement("e"));             // right rotation around d expected
    assertTrue(myTree.root.element.equals("b"));
    assertEquals(+1,myTree.root.balanceFactor);
    assertTrue(myTree.root.right.element.equals("d"));
    assertEquals(-1,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("c"));
    assertEquals( 0,myTree.root.right.left.balanceFactor);
    assertTrue(myTree.root.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    
    assertEquals("d",myTree.removeElement("d"));             // no rotation expected
    assertTrue(myTree.root.element.equals("b"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("c"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    
    assertEquals("c",myTree.removeElement("c"));             // no rotation expected
    assertTrue(myTree.root.element.equals("b"));
    assertEquals(-1,myTree.root.balanceFactor);
    
    assertEquals("b",myTree.removeElement("b"));             // no rotation expected
    assertTrue(myTree.root.element.equals("a"));
    assertEquals( 0,myTree.root.balanceFactor);
    
    assertEquals("a",myTree.removeElement("a"));             // no rotation expected
    assertEquals(null,myTree.root);                          // tree should be empty
  }
  
  // no rotation test cases - 7 nodes
  public void testN7()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("d");                // no rotations expected!
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("c");
    myTree.addElement("e");
    myTree.addElement("g");
    // check state of the tree after a sequence of balanced adds
    assertTrue(myTree.root.element.equals("d"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.left.element.equals("a"));
    assertEquals( 0,myTree.root.left.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("c"));
    assertEquals( 0,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("e"));
    assertEquals( 0,myTree.root.right.left.balanceFactor);
    assertTrue(myTree.root.right.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.right.balanceFactor);
    
    while (!myTree.isEmpty())  {           // should be one right rotation around g in this loop
      String result = myTree.removeElement(myTree.root.element);   // always remove the root
      if (result.equals("f")) {
        assertTrue(myTree.root.element.equals("b"));
        assertEquals(+1,myTree.root.balanceFactor);
      }
    }
    myTree.displayState();                 // show the state of the tree - should be empty
  }
  
  public static void main(String[] args)
  {
    System.out.println("-->Add in order forcing a sequence of left rotations.");
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("a");                // no rotation expected
    myTree.addElement("b");                // no rotation expected
    myTree.addElement("c");                // left rotation around a expected
    myTree.addElement("d");                // no rotation expected
    myTree.addElement("e");                // left rotation around c expected
    myTree.addElement("f");                // left rotation around b expected
    myTree.addElement("g");                // left rotation around e expected
    myTree.displayState();                 // show the state of the tree - should be balanced
    System.out.println("-->Remove in the same order");
    myTree.removeElement("a");             // no rotation expected
    myTree.removeElement("b");             // no rotation expected
    myTree.removeElement("c");             // left rotation around d expected
    myTree.removeElement("d");             // no rotation expected
    myTree.removeElement("e");             // no rotation expected
    myTree.removeElement("f");             // no rotation expected
    myTree.removeElement("g");             // no rotation expected
    myTree.displayState();                 // show the state of the tree - should be empty
    
    myTree = new AVLLinkedBinarySearchTree<String>();
    System.out.println("-->Add in reverse order forcing a sequence of right rotations.");
    myTree.addElement("g");                // no rotation expected
    myTree.addElement("f");                // no rotation expected
    myTree.addElement("e");                // right rotation around g expected
    myTree.addElement("d");                // no rotation expected
    myTree.addElement("c");                // right rotation around e expected
    myTree.addElement("b");                // right rotation around f expected
    myTree.addElement("a");                // right rotation around c expected
    myTree.displayState();                 // show the state of the tree - should be same as above
    System.out.println("-->Remove in the same order");
    myTree.removeElement("g");             // no rotation expected
    myTree.removeElement("f");             // no rotation expected
    myTree.removeElement("e");             // right rotation around d expected
    myTree.removeElement("d");             // no rotation expected
    myTree.removeElement("c");             // no rotation expected
    myTree.removeElement("b");             // no rotation expected
    myTree.removeElement("a");             // no rotation expected
    myTree.displayState();                 // show the state of the tree - should be empty
    
    myTree = new AVLLinkedBinarySearchTree<String>();
    System.out.println("-->Add in balanced order to avoid any rotations.");
    myTree.addElement("d");                // no rotations expected!
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("c");
    myTree.addElement("e");
    myTree.addElement("g");
    myTree.displayState();                 // show the state of the tree - should be same as above
    System.out.println("-->Remove the root each time");
    while (!myTree.isEmpty())              // should be one right rotation around g in this loop
      myTree.removeElement(myTree.root.element);   // always remove the root
    myTree.displayState();                 // show the state of the tree - should be empty
  }
}