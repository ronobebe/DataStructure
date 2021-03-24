package Algorithms.FairDraft.Trees;

import junit.framework.TestCase;
import static  org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class RedBlackTreeTest extends TestCase {
  private RedBlackTree redBlackTree;

  @BeforeEach
  public void createRBTObject() {
    redBlackTree = new RedBlackTree();
  }

  @RepeatedTest(1)
  @DisplayName("Insert Operation")
  void insert() {

      assertAll("Assert all is : ",
              ()->assertTrue("Test to insert is : ", redBlackTree.add(9)),
              ()-> assertTrue("Test to insert is : ", redBlackTree.add(4)),
              ()->assertTrue("Test to insert is : ", redBlackTree.add(8)),
              ()-> assertTrue("Test to insert is : ", redBlackTree.add(10))

      );


    redBlackTree.add(5);
    redBlackTree.add(6);
    redBlackTree.add(11);
    redBlackTree.add(18);
    redBlackTree.add(20);
    redBlackTree.add(5);
    redBlackTree.add(3);
    redBlackTree.add(21);
  }
}
