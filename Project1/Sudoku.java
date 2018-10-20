import java.util.*;

/**
 * Sudoku class represents the matrix of cells in a Sudoku puzzle
 * @version 01/05/2012
 * @author Bob Wilson
 */

public class Sudoku implements Iterable<Cell []>
{
  private Cell [] [] puzzle;
  
  /**
   * Default constructor should not be called.  Make it private.
   */
  private Sudoku() {}
  
  /**
   * Puzzle constructor that uses a Scanner object to read a file.
   * File contains 81 numbers that are the values of the 81 cells.
   * @param file a Scanner object on a File object
   */
  public Sudoku(Scanner file)
  {
    int size = file.nextInt();
    System.out.println("Size: " + size);
    puzzle = new Cell[size][size];
    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        puzzle[i][j] = new Cell(file.nextInt());
  }
  
  /**
   * Generates and returns a String representation of the puzzle cells
   * @return A String representing the contents of the puzzle array
   */
  public String toString()
  {
    // display the puzzle
    String value = "Puzzle is:\n";
    
    for (int i = 0; i < puzzle.length; i++) {
      for (int j = 0; j < puzzle[i].length; j++) 
        value += puzzle[i][j].toString();
      value += "\n";
    }
    return value;
  }
  
  /**
   * Instantiates and returns a new SudokuIterator object
   * @return A SudokuIterator object on the puzzle array
   */
  
   // write your code for the iterator method here
  public Iterator<Cell[]> iterator(){
    return new SudokuIterator(puzzle);
    
  }
}/* 201340 */
