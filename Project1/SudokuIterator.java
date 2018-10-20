import java.util.Iterator;
/**
 * iterator for a Sudoku puzzle
 */
public class SudokuIterator implements Iterator<Cell []>{
	
	private Cell[][] puzzle;
	private int cursor;
	
	/**
	 * Constructor initializing a cursor and the puzzle
	 */
	public SudokuIterator(Cell[][] puzzle){
		cursor = 0;
		this.puzzle = puzzle;
	}

	/**
	 * @return boolean if there is more left to be iterated
	 */
	public boolean hasNext(){
		return cursor < puzzle.length;
	}

	/**
	 * loops through the puzzle 3 times, once for a row, 
	 * once for a column, and once for a box
	 * @return a Cell array of size puzzle length * 3, each length is a loop through puzzle
	 */
	public Cell[] next(){
		
		int total = puzzle.length*3;
		int counter = 0;
		Cell[] result = new Cell[total];
		
		//loops through puzzle one row at a time
		for(int i = 0; i < puzzle.length; i++){
			result[counter++] = puzzle[cursor][i];
		}
		
		//loops through puzzle one column at a time
		for(int i = 0; i < puzzle.length; i++){
			result[counter++] = puzzle[i][cursor];
		}
		

		//loops through puzzle one square at a time
		int squared = (int)Math.sqrt(puzzle.length);
		int startRow = (cursor / squared) * squared;
		int startCol = (cursor % squared) * squared;
		for(int i = 0, row = startRow; i < squared; i++, row++){
			for(int j = 0, col = startCol; j < squared; j++, col++){
				result[counter++] = puzzle[row][col];
			}
		}
		cursor++;

		return result;
	}

	public void remove(){}//not used
}