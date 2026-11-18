public class Grid {
    public GridCell[][] grid;
    
    public Grid(int rows, int cols) {
        grid = new GridCell[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = new GridCell();
            }
        }

    }//end of grid

    public void printGrid() {
        for(int row= 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                System.out.print("[" + row + "," + col + "] ");
            }
            System.out.println();
        }
    }//end of printGrid

    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        grid.printGrid();
    }//end of main
    
}
