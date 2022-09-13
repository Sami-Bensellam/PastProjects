
package mini3;

import api.CellStatus;
import api.GridCell;
import api.TwoDGrid;

/**
 * Utility class for searching a maze described by a collection
 * of GridCell objects.
 */
public class MazeExplorer
{
  /**
   * Recursively searches a given GridCell and all of its unexplored 
   * neighbors.  Immediately returns true if the current cell is the goal;
   * otherwise,  immediately returns false if the current cell is a wall 
   * or if the current cell's status is anything other than NOT_STARTED.
   * Otherwise, initiates a recursive search of the neighbors of the current cell.
   * If any search of a neighbor results in the goal being found, the current cell's status
   * is set to CellStatus.FOUND_IT and the method immediately returns true.  If 
   * no search of a neighbor results in the goal being found, the current cell's 
   * status is set to DEAD_END and the method returns false.
   * <p>
   * <strong>Neighbors are always searched in the order up, down, left, then right,</strong>
   * and during a recursive search of a neighbor, the current cell's status
   * is set to SEARCHING_UP, SEARCHING_DOWN, SEARCHING_LEFT, or SEARCHING_RIGHT, 
   * respectively.
   * 
   * @param maze
   *   the 2d grid to be searched
   * @param row
   *   the row for the current cell being searched
   * @param col
   *   the column for the current cell being searched
   * @return
   *   true if a search from the current cell has reached the goal,
   *   false if the goal can't be reached from the current cell
   */
  public static boolean search(TwoDGrid maze, int row, int col)
  {
//if c is goal return true

//check if current spot is surrounded by 3 walls or dead end
//I need to find a way to change the maze and move the current spot.
//get cell and 
      GridCell current = maze.getCell(row, col);
      CellStatus s = current.getStatus();
      

      

      if (current.isWall()||s != CellStatus.NOT_STARTED) {
	return false;
}
else if (current.isGoal()) {
	return true;
}
      
      
      
      
    current.setStatus(CellStatus.SEARCHING_UP);
if(search(maze, row -1, col) == true) {
    current.setStatus(CellStatus.FOUND_IT);
		  return true;
  }
	  current.setStatus(CellStatus.SEARCHING_DOWN);
   if(search(maze, row +1, col) == true) {
	  current.setStatus(CellStatus.FOUND_IT);
	  return true;
  }
  current.setStatus(CellStatus.SEARCHING_LEFT);
   if(search(maze, row, col-1) == true) {
	   current.setStatus(CellStatus.FOUND_IT);
	   return true;
  }
   
   current.setStatus(CellStatus.SEARCHING_RIGHT);
   if(search(maze, row, col+1) == true) {
	   current.setStatus(CellStatus.FOUND_IT);
	   return true;
  }
current.setStatus(CellStatus.DEAD_END);

return false;
}
}