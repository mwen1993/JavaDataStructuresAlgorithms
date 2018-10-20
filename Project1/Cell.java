/**
 * A Cell object represents a single cell on a Sudoku Board.
 * A Cell contains a value.
 * @author Ming Wen
 */

public class Cell{
  private int value;

  private Cell() {} //default constructor not used

  /**
   * constructor initializing value
   * @param value the value of the cell
   */
  public Cell(int value){
    this.value = value;
  }

  /**
   * @return value of the cell.
   */
  public int getValue(){
    return value;
  }

  /**
   * Compares if two cell objects are equal by comparing value.
   * @return true if two cells are equal.
   */
  public boolean equals(Cell that){
    return that != null && this.value == that.value;
  }

  /**
   * @return value as a string
   */
  public String toString(){
    return "" + value;
  }
}