//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P5 Ascii Art
// Files: AsciiArt.java, AsciiTest.java, Canvas.java, DrawingChange.
// java, DrawingStack.java, DrawingStackIterator.java
// Course: CS300 Summer 2019
//
// Author: Kunlun Wang
// Email: kwang358@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: N/A
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Iterator;

/**
 * This class serves to test the methods in the StackADT interface and some critical methods such as
 * push and peek
 * 
 * @author Kunlun Wang, Mingi Kim
 *
 */

public class AsciiTest {

  /**
   * testStackPushPeek() tests the functionality push() and peek()
   * 
   * @return true if it correctly pushes and peeks, false otherwise
   */
  public static boolean testStackPushPeek() {
    boolean testPassed = false;
    DrawingStack testStack = new DrawingStack();

    // create 2 new changes
    DrawingChange testChange1 = new DrawingChange(1, 1, 'a', 'b');
    DrawingChange testChange2 = new DrawingChange(2, 2, 'c', 'd');

    // push the stack with the 2 change2
    testStack.push(testChange1);
    testStack.push(testChange2);

    // peek the stack and check whether it is correct
    if (testStack.peek() == testChange2) {
      testPassed = true;
    }
    return testPassed;
  }

  /**
   * testStackPushException() serves to check if DrawingStack throws IllegalArgumentException when
   * adding a null element to top of stack
   *
   * @return true if succeed, false otherwise
   */
  public static boolean testStackPushException() {

    DrawingStack stack = new DrawingStack();

    try {
      stack.push(null);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }

  /**
   * testStackPopIsEmpty() checks if pop() and isEmpty () method works correct
   *
   * @return true test passed, false otherwise
   */
  public static boolean testStackPopIsEmpty() {
    boolean testPassed = false;
    DrawingStack testStack = new DrawingStack();
    DrawingChange testChange = new DrawingChange(2, 2, 'a', 'b');
    testStack.push(testChange);
    // store the returned value of pop to newChange2, in this case it should be 'b'
    DrawingChange newChange2 = testStack.pop();
    if (testChange == newChange2 && testStack.isEmpty()) {
      testPassed = true;
      return testPassed;
    }
    return testPassed;
  }

  /**
   * testStackSize() serves to check the functionality of size() method
   *
   * @return true if test passed, false otherwise
   */
  public static boolean testStackSize() {
    boolean testPassed = false;
    DrawingStack testStack = new DrawingStack();
    DrawingChange testChange = new DrawingChange(2, 2, 'a', 'b');
    // add 'b' at top of the stack
    testStack.push(testChange);
    // the size of the stack should be 1
    if (testStack.size() == 1) {
      testPassed = true;
      return testPassed;
    }
    return testPassed;
  }


  /**
   * Test the functionality of toString method.
   * 
   * @return true if successfully converted to string, false otherwise
   */
  public static boolean testToString() {
    char[] testChar = {'1', '1', '1', '1'};
    Canvas testCanvas = new Canvas(4, 4);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        testCanvas.draw(i, j, testChar[j]);
      }
    }
    if (testCanvas.toString().equals("1111\n1111\n1111\n1111\n")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Run multiple other test methods. return false if any of its component tests fail, and true if
   * they all succeed
   *
   * @return true if all test case succeed, false if any of them fail
   */
  public static boolean runStackTestSuite() {
    if (testStackPushPeek() && testStackPushException() && testStackPopIsEmpty() 
        && testStackSize() && testToString()) {
      return true;
    }
    return false;
  }

  /**
   * The main method for the test
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    System.out.println("testStackPushPeek(): " + testStackPushPeek());
    System.out.println("runStackTestSuite(): " + runStackTestSuite());
  }
}
