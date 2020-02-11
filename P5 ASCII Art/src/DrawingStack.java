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
 * This class represents the stack of DrawingChange used in this assignment
 * 
 * @author Kunlun Wang, Mingi Kim
 *
 */
public class DrawingStack implements StackADT<DrawingChange> {

  // create a Node object to refer to the top of the stack
  Node<DrawingChange> topOfStack;
  // create a int variable to refer to the size of the stack
  int sizeOfAStack;
  // create a DrawingStackIterator object to iterate objects
  DrawingStackIterator objectIterator;

  /**
   * This is the default constructor for DrawingStack class It serves to create new DrawingStack
   * object or instance
   */
  public DrawingStack() {
    // constructor completes initialization
    topOfStack = null;
    sizeOfAStack = 0;
    // iterator of the topOfStack
    this.objectIterator = new DrawingStackIterator(topOfStack);
  }

  /**
   * The push() method overrides the push() method in StackADT It serves to add a new node on the
   * top of the stack
   * 
   * @param element an element to be added
   * @throws IllegalArgumentException if the argument is illegal
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    // need to check if the element to be added is null
    if (element == null) {
      throw new IllegalArgumentException();
    }
    // newNode will contain the element to be added
    Node<DrawingChange> newNode = new Node<>(element, this.topOfStack);
    // topOfStack will contain the new element to be added
    topOfStack = newNode;
    // increase the size of the stack
    sizeOfAStack++;
  }

  /**
   * The pop() method overrides the pop() in StackADT interface It serves to remove the element at
   * the top of the stack and return it
   * 
   * @return the element removed from top of the stack
   * @throws NullPointerException if the top of the stack is null (empty)
   */
  @Override
  public DrawingChange pop() throws NullPointerException {
    // even though in the previous method, I add a throws clause to
    // see if the new element is null or not. To be safer, I want to add another throws clause
    // to prevent NullPointerException
    if (isEmpty()) {
      throw new NullPointerException("WARNING: The Top of Stack is empty.");
    }
    // we store the node at the top of stack in nodeToRemove
    DrawingChange nodeToRemove = topOfStack.getData();
    // get next element and put it to the topOfStack
    topOfStack = topOfStack.getNext();
    // decrease the size
    sizeOfAStack--;
    // return the node to be removed
    return nodeToRemove;
  }

  /**
   * peek() method overrides the peek() method in StackADT interface It serves to return the return
   * the top element of the stack, without remove it.
   * 
   * @return the top element of the stack
   * @throws NullPointerException if the top of the stack is null (empty)
   */
  @Override
  public DrawingChange peek() throws NullPointerException {
    // need to check if the top of the stack is empty
    if (isEmpty()) {
      throw new NullPointerException("WARNING: The Stack is empty.");
    }
    // return the node of top of stack without removing or changing it
    return this.topOfStack.getData();
  }

  /**
   * isEmpty () method override the isEmpty () method in stackADT interface This method check
   * whether the stack is empty
   * 
   * @return a boolean true if stack is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (this.sizeOfAStack == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * size() method overrides the size() method in StackADT interface It serves to returns the number
   * of elements in the stack.
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return this.sizeOfAStack;
  }

  /**
   * @return iterator of the stack
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    // return new DrawingStackIterator(topOfStack);
    return this.objectIterator;
  }
}
