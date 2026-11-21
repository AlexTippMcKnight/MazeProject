import java.awt.*;

public class MazeCanvas extends Canvas {
    GridCell[][] grid;
    public MazeCanvas(GridCell[][] grid) {
        this.grid = grid;
    }
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
    }
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

        for(int i=0; i < grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                drawCell(g, grid[i][j], i*cell_dim, j*cell_dim, cell_dim);
            }
        }
        
        g.setColor(Color.GREEN);
        g.fillRect(26,26, cell_dim-4, cell_dim-4);

        g.setColor(Color.RED);
        g.fillRect((grid[0].length-1)*cell_dim+26, (grid.length-1)*cell_dim+26, cell_dim-4, cell_dim-4);
    }
}