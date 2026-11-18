import java.util.*;

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
        start.setVisited();
        stack.push(start);

        //test visual ----------- remove later
        System.out.println("Started at: [0,0]");

        while(!stack.isEmpty()) {
            GridCell curr = (GridCell) stack.peek();
            GridCell next = getNextCell(curr);

            if(next != null) {
                curr.removeWall(next);
                next.setVisited();
                stack.push(next);
                //test visual ----------- remove later
                System.out.println("Moved to: [" + next.getRow() + "," + next.getCol() + "]");
            } else {
                stack.pop();
                //test visual ----------- remove later
                System.out.println("Backtracking from: [" + curr.getRow() + "," + curr.getCol() + "]");
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

    public void printGrid() {
        for(int row= 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                System.out.print("[" + row + "," + col + "] ");
            }
            System.out.println();
        }
    }//end of printGrid

    public static void main(String[] args) {
        Grid grid = new Grid(3, 3);
        grid.printGrid();

        grid.generateMaze();


    }//end of main
}//end of class
