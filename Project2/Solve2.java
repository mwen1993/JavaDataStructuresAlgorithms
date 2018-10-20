/** Solve2.java - Class containing the main method for recursive solution
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.Stack;

//a recursive solution to the puzzle similar to Solve1.java
public class Solve2
{
  public static void main(String [] args)
  {
    // create the maze to solve
    Maze maze = new Maze();

    // create a Stack of Bird objects named path here
    Stack<Bird> path = new Stack<Bird>();

    
    // call recursive method to solve the maze and print the path
    recurse(path, maze.getStart(), maze.getEnd());
    print(path);
  }
  
  //recursive solution to traverse paths of the puzzle until we find the answer
  private static boolean recurse(Stack<Bird> path, Bird current, Bird end){
    if(current == end){
      path.push(current);
      return true;
    } 
    else if(current == null){
      path.pop();
      return recurse(path, path.peek().getNextBird(), end);
    } 
    else{
      path.push(current);
      return recurse(path, current.getNextBird(), end);
    }
  }
  
  //print the result path, remove all loop paths along the way
  private static void print(Stack<Bird> stack)
  {
    Stack<Bird> path = new Stack<Bird>();

    while(!stack.isEmpty()){
      Bird current = stack.pop();

      if(stack.search(current) > -1){
        while(!stack.peek().equals(current)){
          stack.pop();
        }
        stack.pop();
      }

      path.push(current);
    }

    while(!path.isEmpty()){
      System.out.println(path.pop());
    }
  }
}