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
import java.util.NoSuchElementException;

/**
 * This class serves to iterate through a DrawingStack object
 * 
 * @author Kunlun Wang, Mingi Kim
 *
 */

public class DrawingStackIterator implements Iterator<DrawingChange> {
  // reference to the current element in the iteration
  private Node<DrawingChange> current;

  /**
   * Constructor that creates a DrawingStackIterator that iterates through an iteration of elements
   * of type DrawingChange
   * 
   * @param head reference to the first node in the iteration
   */
  public DrawingStackIterator(Node<DrawingChange> head) {
    this.current = head;
  }

  /**
   * hasNext() serves to check whether the current node has a next node
   * 
   * @return true if it has, false otherwise
   */
  @Override
  public boolean hasNext() {
    if (this.current.getNext() == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * next() method serves to move to the next node and return the current node
   * 
   * @return the current node
   */
  @Override
  public DrawingChange next() {
    // we need to check if the current node is the end of stack
    if (!hasNext()) {
      return null;
    }
    return this.current.getNext().getData();
  }
}
