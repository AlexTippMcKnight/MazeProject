import java.util.*;
import lib.*;

public class Grid {
    public GridCell[][] grid;

    public Grid(int rows, int cols) {
        grid = new GridCell[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = new GridCell(i, j);
            }
        }

    }//end of grid
    public void generateMaze() {
        StackReferenceBased stack = new StackReferenceBased();
        GridCell start = grid[0][0];
        start.setVisited(true);
        stack.push(start);

        while(!stack.isEmpty()) {
            GridCell curr = (GridCell) stack.peek();
            GridCell next = getNextCell(curr);

            if(next != null) {
                curr.removeWall(next);
                next.setVisited(true);
                stack.push(next);
            } else {
                stack.pop();
            }
        }

    }//end of generateMaze

    public GridCell getNextCell(GridCell curr) {
        int row = curr.getRow();
        int col = curr.getCol();

        ArrayList<GridCell> unvisitedCells = new ArrayList<>();

        // check top cell
        if(row > 0 && !grid[row - 1][col].checkVisited()) {
            unvisitedCells.add(grid[row - 1][col]);
        }
        // check left cell
        if(col > 0 && !grid[row][col - 1].checkVisited()) {
            unvisitedCells.add(grid[row][col - 1]);
        }
        // check bottom cell
        if(row < grid.length - 1 && !grid[row + 1][col].checkVisited()) {
            unvisitedCells.add(grid[row + 1][col]);
        }
        // check right cell
        if(col < grid[0].length - 1 && !grid[row][col + 1].checkVisited()) {
            unvisitedCells.add(grid[row][col + 1]);
        }

        //return
        if(unvisitedCells.isEmpty()) {
            return null; // No unvisited cells
        }else {
            return unvisitedCells.get((int)(Math.random() * unvisitedCells.size()));
        }
    }//end of getNextCell

    public void resetVisited(){
        for(int i= 0; i< grid.length; i++) {
            for(int j = 0; j< grid[0].length; j++) {
                grid[i][j].setVisited(false);
            }
        }
    }// end of resetVisited
}//end of class
