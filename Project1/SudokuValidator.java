import java.util.*;
import java.io.*;

/** 
 * This class instantiates a Sudoku object passing a Scanner on a
 * file to the Sudoku constructor.  It prints the puzzle using the
 * Sudoku toString method.  It determines if the digit matrix is a
 * valid solution for a Sudoku puzzle or not and prints the result.
 * 
 * @author Bob Wilson
 * 
 */

public class SudokuValidator
{
  private Sudoku puzzle;
  private int size;
  
  /**
   * @param args - not used
   */
  public static void main( String [] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter name of file containing puzzle to verify");   
    SudokuValidator myValidator = new SudokuValidator(scan.nextLine());
    System.out.println(myValidator.isSolution() ? 
                "It is a valid solution" : "It is not a valid solution");
  }
    
  public SudokuValidator(String fileName)
  {
    Scanner file = null;
    try
    {
      file = new Scanner(new File(fileName));
    }
    catch (Exception e)
    {
      System.out.println("Bad file name");
      System.exit(0);
    }
    
    puzzle = new Sudoku(file);
    System.out.println(puzzle);
  }
  
  /**
   * using SudokuIterator to iterate through the Sudoku puzzle,
   * each iteration returns an array containing a row, column, and box of the puzzle.
   * the array should contain 3 sets of numbers, since each row, column, and box has unique integers
   * check if each row, column and box are unique using a HashMap to store the values.
   *@return if the puzzle is a valid Sudoku solution.
   */
  public boolean isSolution()
  {
    // write your code to validate the puzzle solution here
    HashMap<Integer, Integer> map = new HashMap<>();

    for(Cell[] cellArray: puzzle){
      for(Cell cellObj: cellArray){
        Integer temp = map.get(cellObj.getValue());
        if(temp == null)
          map.put(cellObj.getValue(), 1);
        else
          map.put(cellObj.getValue(), ++temp); 
      }
      for(Integer num: map.values()){
        if(num != 3)
          return false;
      }
      map.clear();
    }
    return true;
  }
}/* 201340 */
