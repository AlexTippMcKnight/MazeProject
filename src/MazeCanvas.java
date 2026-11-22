import java.awt.*;
import java.util.ArrayList;

public class MazeCanvas extends Canvas {

    GridCell[][] grid;
    ArrayList<GridCell> solution;

    public MazeCanvas(GridCell[][] grid, ArrayList<GridCell> solution) {
        this.grid = grid;
        this.solution = solution;

    }//end of MazeCanvas

    private void drawCell(Graphics g, GridCell c, int top, int left, int cell_dim){
        top+= 25;
        left+= 25;
        if(c.getTop())
            g.drawLine(left, top, left+cell_dim, top);
        if(c.getLeft())
            g.drawLine(left, top, left, top+cell_dim);
        if(c.getBottom())
            g.drawLine(left, top+cell_dim, left+cell_dim, top+cell_dim);
        if(c.getRight())
            g.drawLine(left+cell_dim, top, left+cell_dim, top+cell_dim);

    }//end of drawCell

	@Override
    public void paint(Graphics g) {
        int w = getWidth() - 50;
        int h = getHeight() - 50;

        int cell_dim;

        if(w < h){
            cell_dim = w/grid.length;
        }
        else{
            cell_dim = h/grid.length;
        }

        //draws maze walls
        for(int i=0; i < grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                drawCell(g, grid[i][j], i*cell_dim, j*cell_dim, cell_dim);
            }
        }
        
        //Start Cell
        g.setColor(Color.GREEN);
        g.fillRect(26,26, cell_dim-4, cell_dim-4);

        //End Cell
        g.setColor(Color.RED);
        g.fillRect((grid[0].length-1)*cell_dim+26, (grid.length-1)*cell_dim+26, cell_dim-4, cell_dim-4);


        //Solution Line
        g.setColor(Color.BLUE);
        int middle = 25 + cell_dim/2;
        for(int i = 0; i < solution.size() -1; i++) {
            GridCell currentCell = solution.get(i);
            GridCell nextCell = solution.get(i + 1);

            //current cell
            int x1 = middle + currentCell.getCol() * cell_dim;
            int y1 = middle + currentCell.getRow() * cell_dim;

            //next cell
            int x2 = middle + nextCell.getCol() * cell_dim;
            int y2 = middle + nextCell.getRow() * cell_dim;

            g.drawLine(x1, y1, x2, y2);
        }//end of loop

    }//end of paint

}//end of class