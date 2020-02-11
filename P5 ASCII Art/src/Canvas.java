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
 * Canvas class serves to manipulate the canvas that the user is creating or changing through
 * altering its size, adding characters and redoing and undoing.
 * 
 * @author Kunlun Wang, Mingi Kim
 *
 */

public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * This is the constructor of Canvas class. It serves to create a new Canvas with given width and
   * height
   * 
   * @param width represents the width of the canvas
   * @param height represents the height of the canvas
   * @throws IllegalArgumentException if width or height is 0 or negative
   */
  public Canvas(int width, int height) throws IllegalArgumentException {
    // if width or height is 0 or negative, then throw a
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Negative input.");
    }
    // update the dimension
    this.width = width;
    this.height = height;
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();
    // create a 2D character array to store the drawing
    drawingArray = new char[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.drawingArray[i][j] = ' '; // initialize the character to be blank
      }
    }
  }

  /**
   * The draw () method serves to draw a character at the given position on the canvas
   * 
   * @param row represents the row number
   * @param col represents column number
   * @param c represents the char
   * @throws IllegalArgumentException if the drawing position is outside the canvas
   */
  public void draw(int row, int col, char c) throws IllegalArgumentException {

    char previousChar;
    // throws IllegalArgumentException if the char to be added is out of boundary
    if ((row < 0 || row > this.height - 1) || (col < 0 || col > this.width - 1)) {
      throw new IllegalArgumentException("WARNING: out of boundary!");
    }
    // create a char object previousChar which store the previous char at (row,col)
    previousChar = this.drawingArray[row][col];
    // this will create a new change
    DrawingChange newCharChange = new DrawingChange(row, col, previousChar, c);
    // after we made the change, we need to add the new change to undoStack
    // so we can undo if needed
    this.undoStack.push(newCharChange);
    this.drawingArray[row][col] = c;

  }

  /**
   * undo() method serves to undo the most recent drawing change.
   * 
   * @Return true if successful. False otherwise
   * 
   */
  public boolean undo() {
    // undoStack.pop() will retrieve the previous drawing
    DrawingChange previousDrawingChange = undoStack.pop();
    draw(previousDrawingChange.x, previousDrawingChange.y, previousDrawingChange.prevChar);
    // add the undone change to the redoStack so we can redo
    redoStack.push(previousDrawingChange);
    return true;
  }

  /**
   * The redo() method servers to redo the most recently undone addition.
   * 
   * @return
   */
  public boolean redo() {
    // get the most recent undone change
    DrawingChange recentUndoneDrawingChange = redoStack.pop();
    // redo the change
    draw(recentUndoneDrawingChange.x, recentUndoneDrawingChange.y,
        recentUndoneDrawingChange.newChar);
    // add the change to the undoStack so we can undo it
    undoStack.push(recentUndoneDrawingChange);
    return true;
  }

  /**
   * toString() serves to convert the contents of canvas to strings
   */
  public String toString() {
    String canvasString = "";
    // traverse the whole drawingArray field to store the char
    // in canvas to string
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        // append char one by one to the string
        canvasString += drawingArray[i][j];
      }
      canvasString += System.lineSeparator();
    }
    return canvasString;

  }

  /**
   * @return: returns the height of the canvas
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * @return: Returns the width of the canvas.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * printDrawing() methods serve to print the canvas
   */
  public void printDrawing() {
    System.out.println(this.toString());
  }

  /**
   * printHistory() method provides a record for any previous addition
   */
  public void printHistory() {
    // creator a new iterator
    Iterator<DrawingChange> undoIterator = undoStack.iterator();
    int sizeOfUndoStack = undoStack.size();
    // store the change
    DrawingChange changeStorer;
    // iterate until there's no more elements
    while (undoIterator.hasNext()) {
      changeStorer = undoIterator.next();
      // print the message out
      System.out.println(sizeOfUndoStack + ". draw '" + changeStorer.newChar + "' on ("
          + changeStorer.y + "," + changeStorer.x + ")");
      sizeOfUndoStack--;
    }
  }

}
