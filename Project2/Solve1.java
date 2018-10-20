/** Solve1.java - Class containing the main method for iterative solution
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.Stack;

public class Solve1
{
  public static void main(String [] args)
  {
    // create the maze to solve
    Maze maze = new Maze();
    
    // create two Stack of Bird objects named traceBack and path here
    Stack<Bird> traceBack = new Stack<Bird>();
    Stack<Bird> path = new Stack<Bird>();
    //extra code added later to print the path visually
    Stack<Bird> printStack = new Stack<Bird>();
    

    // Write your code for solving the maze here using the traceback stack
    Bird current = maze.getStart();

    //loop through all bird paths starting from start bird until we reach end bird
    while(!current.equals(maze.getEnd())){
      traceBack.push(current);

      current = current.getNextBird();

      while(current == null){
        traceBack.pop();
        current = traceBack.peek();
        current = current.getNextBird();
      }
    }

    traceBack.push(current);

    //some paths might take a loop before going off to a different path, eliminate those loop paths,
    //at the same time, save the actual path to the path stack so that the pathwill be in order when printing
    while(!traceBack.isEmpty()){
      current = traceBack.pop();
      
      if(traceBack.search(current) > -1){
        while(!traceBack.peek().equals(current)){
          traceBack.pop();
        }
        traceBack.pop();
      }

      path.push(current);
      printStack.push(current);//print stack is identical to path stack
    }


    //print the path from the path stack
    while(!path.isEmpty()){
      System.out.println(path.pop().toString());
    }

    //print the path on the maze visually
    String[][] puzzle = new String[5][7];

    while(!printStack.isEmpty()){
      Bird bird = printStack.pop();
      int row = bird.getRow();
      int column = bird.getColumn();
      puzzle[row][column] = bird.displayDirection();
    }
    
    for(int i = 0; i < puzzle.length; i++){
      for(int j = 0; j < puzzle[i].length; j++){
        if(puzzle[i][j] == null)
          System.out.print("  ");
        else
          System.out.print(puzzle[i][j]);
      }
      System.out.println();
    } 
    
  }
}