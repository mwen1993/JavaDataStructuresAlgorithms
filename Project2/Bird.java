/** Bird.java - Class representing a Bird in the Maze object
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.*;

public class Bird
{
  public static final int N  = 0;
  public static final int NE = 1;
  public static final int E  = 2;
  public static final int SE = 3;
  public static final int S  = 4;
  public static final int SW = 5;
  public static final int W  = 6;
  public static final int NW = 7;
  
  private static final String [] directions = {"N ", "NE", "E ", "SE", "S ", "SW", "W ", "NW"};
  
  private String name;
  private int direction;
  private Queue<Bird> queue;
  private int row;//added later for printing maze path visually
  private int column;//added later for printing maze path visually
  
  public Bird(int row, int column, int direction)
  {
    this.row = row;
    this.column = column;
    this.name = "Row/Column [" + row + "][" + column + "]";
    this.direction = direction;
  }
  
  public void setBirdQueue(Queue<Bird> queue)
  {
    this.queue = queue;
  }
  
  public String toString()
  {
    return "Location: " + name + ", Direction: " + directions[direction];
  }
  
  public int getDirection()
  {
    return this.direction;
  }
  
  public Bird getNextBird()
  {
    // write code to return the next Bird from the queue or null if no Birds left.
    return this.queue.poll();

  }

  public int getRow(){
    return this.row;
  }

  public int getColumn(){
    return this.column;
  }

  //addition method to display a direction visually
  public String displayDirection(){
    switch(this.direction){
      case 0:
        return "\u2191" + " ";

      case 1:
        return "\u2197" + " ";

      case 2:
        return "\u2192" + " ";

      case 3:
        return "\u2198" + " ";

      case 4:
        return "\u2193" + " ";
      case 5:
        return "\u2199" + " ";

      case 6:
        return "\u2190" + " ";

      case 7:
        return "\u2196" + " ";

      default:
        return "invalid direction integer.";
    }
  }
}