import junit.framework.TestCase;

/**
 * AVLTreeTest2.java
 * 4/30/2015
 * Bob Wilson
 * Tests the four cases of left-right rotations
 * Tests the four cases of right-left rotations
 */

public class AVLTestTree2 extends TestCase
{
  // left-right test case 1
  public void testLR1()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("c");
    myTree.addElement("g");
    myTree.addElement("d");
    // check state of the tree before L-R rotation
    assertTrue(myTree.root.element.equals("e"));
    assertEquals(-1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(+1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("c"));
    assertEquals(+1,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals(+1,myTree.root.right.balanceFactor);
    
    myTree.removeElement("f");
    // check state of the tree after L-R rotation
    assertTrue(myTree.root.element.equals("c"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(-1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("e"));
    assertEquals( 0,myTree.root.right.balanceFactor);
  }
  
  // left-right test case 2
  public void testLR2()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("d");
    myTree.addElement("g");
    myTree.addElement("c");
    // check state of the tree before L-R rotation
    assertTrue(myTree.root.element.equals("e"));
    assertEquals(-1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(+1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("d"));
    assertEquals(-1,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals(+1,myTree.root.right.balanceFactor);
    
    myTree.removeElement("f");
    // check state of the tree after L-R rotation
    assertTrue(myTree.root.element.equals("d"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("e"));
    assertEquals(+1,myTree.root.right.balanceFactor);
  }
  
  // left-right test case 3
  public void testLR3()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("f");
    myTree.addElement("b");
    myTree.addElement("g");
    myTree.addElement("a");
    myTree.addElement("d");
    myTree.addElement("h");
    myTree.addElement("c");
    myTree.addElement("e");
    // check state of the tree before L-R rotation
    assertTrue(myTree.root.element.equals("f"));
    assertEquals(-1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(+1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("d"));
    assertEquals( 0,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals(+1,myTree.root.right.balanceFactor);
    
    myTree.removeElement("g");
    // check state of the tree after L-R rotation
    assertTrue(myTree.root.element.equals("d"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals( 0,myTree.root.right.balanceFactor);
  }
  
  // left-right test case 4
  public void testLR4()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("c");
    // check state of the tree before L-R rotation
    assertTrue(myTree.root.element.equals("e"));
    assertEquals(-1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(+1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.left.right.element.equals("c"));
    assertEquals( 0,myTree.root.left.right.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals( 0,myTree.root.right.balanceFactor);
    
    myTree.removeElement("f");
    // check state of the tree after L-R rotation
    assertTrue(myTree.root.element.equals("c"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("e"));
    assertEquals( 0,myTree.root.right.balanceFactor);
  }
  
  // right-left test case 1
  public void testRL1()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("e");
    myTree.addElement("g");
    myTree.addElement("d");
    // check state of the tree before R-L rotation
    assertTrue(myTree.root.element.equals("c"));
    assertEquals(+1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(-1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals(-1,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("e"));
    assertEquals(-1,myTree.root.right.left.balanceFactor);
    
    myTree.removeElement("b");
    // check state of the tree after R-L rotation
    assertTrue(myTree.root.element.equals("e"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("c"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals(+1,myTree.root.right.balanceFactor);
  }
  
  // right-left test case 2
  public void testRL2()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("d");
    myTree.addElement("g");
    myTree.addElement("e");
    // check state of the tree before R-L rotation
    assertTrue(myTree.root.element.equals("c"));
    assertEquals(+1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(-1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals(-1,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("d"));
    assertEquals(+1,myTree.root.right.left.balanceFactor);

    myTree.removeElement("b");
    // check state of the tree after R-L rotation
    assertTrue(myTree.root.element.equals("d"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("c"));
    assertEquals(-1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("f"));
    assertEquals( 0,myTree.root.right.balanceFactor);
  }
  
  // right-left test case 3
  public void testRL3()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");
    myTree.addElement("b");
    myTree.addElement("g");
    myTree.addElement("a");
    myTree.addElement("e");
    myTree.addElement("h");
    myTree.addElement("d");
    myTree.addElement("f");
    // check state of the tree before R-L rotation
    assertTrue(myTree.root.element.equals("c"));
    assertEquals(+1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals(-1,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals(-1,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("e"));
    assertEquals( 0,myTree.root.right.left.balanceFactor);

    myTree.removeElement("b");
    // check state of the tree after R-L rotation
    assertTrue(myTree.root.element.equals("e"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("c"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.balanceFactor);
  }
  
  // right-left test case 4
  public void testRL4()
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("g");
    myTree.addElement("f");
    // check state of the tree before R-L rotation
    assertTrue(myTree.root.element.equals("e"));
    assertEquals(+1,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("b"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals(-1,myTree.root.right.balanceFactor);
    assertTrue(myTree.root.right.left.element.equals("f"));
    assertEquals( 0,myTree.root.right.left.balanceFactor);

    myTree.removeElement("b");
    // check state of the tree after R-L rotation
    assertTrue(myTree.root.element.equals("f"));
    assertEquals( 0,myTree.root.balanceFactor);
    assertTrue(myTree.root.left.element.equals("e"));
    assertEquals( 0,myTree.root.left.balanceFactor);
    assertTrue(myTree.root.right.element.equals("g"));
    assertEquals( 0,myTree.root.right.balanceFactor);
  }
  
  public static void main(String[] args)
  {
    AVLLinkedBinarySearchTree<String> myTree = new AVLLinkedBinarySearchTree<String>();
    // left-right case 1
    System.out.println("Left-Right Case 1");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("c");
    myTree.addElement("g");
    myTree.addElement("d");
    myTree.displayState();
    
    System.out.println("Removing: f");
    myTree.removeElement("f");
    myTree.displayState();
    
    // left-right case 2
    System.out.println("Left-Right Case 2");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("d");
    myTree.addElement("g");
    myTree.addElement("c");
    myTree.displayState();
    
    System.out.println("Removing: f");
    myTree.removeElement("f");
    myTree.displayState();
    
    // left-right case 3
    System.out.println("Left-Right Case 3");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("f");
    myTree.addElement("b");
    myTree.addElement("g");
    myTree.addElement("a");
    myTree.addElement("d");
    myTree.addElement("h");
    myTree.addElement("c");
    myTree.addElement("e");
    myTree.displayState();
    
    System.out.println("Removing: g");
    myTree.removeElement("g");
    myTree.displayState();
    
    // left-right case 4
    System.out.println("Left-Right Case 4");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("c");
    myTree.displayState();
    
    System.out.println("Removing: f");
    myTree.removeElement("f");
    myTree.displayState();
    
    // right-left case 1
    System.out.println("Right-Left Case 1");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("e");
    myTree.addElement("g");
    myTree.addElement("d");
    myTree.displayState();
    
    System.out.println("Removing: b");
    myTree.removeElement("b");
    myTree.displayState();
    
    // right-left case 2
    System.out.println("Right-Left Case 2");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");
    myTree.addElement("b");
    myTree.addElement("f");
    myTree.addElement("a");
    myTree.addElement("d");
    myTree.addElement("g");
    myTree.addElement("e");
    myTree.displayState();
    
    System.out.println("Removing: b");
    myTree.removeElement("b");
    myTree.displayState();
    
    // right-left case 3
    System.out.println("Right-Left Case 3");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("c");
    myTree.addElement("b");
    myTree.addElement("g");
    myTree.addElement("a");
    myTree.addElement("e");
    myTree.addElement("h");
    myTree.addElement("d");
    myTree.addElement("f");
    myTree.displayState();
    
    System.out.println("Removing: b");
    myTree.removeElement("b");
    myTree.displayState();
    
    // right-left case 4
    System.out.println("Right-Left Case 4");
    myTree = new AVLLinkedBinarySearchTree<String>();
    myTree.addElement("e");
    myTree.addElement("b");
    myTree.addElement("g");
    myTree.addElement("f");
    myTree.displayState();
    
    System.out.println("Removing: b");
    myTree.removeElement("b");
    myTree.displayState();
    
  }
}