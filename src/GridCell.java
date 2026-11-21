public class GridCell {
    private int row;
    private int col;

    private boolean top;
    private boolean bottom;
    private boolean left;
    private boolean right;

    private boolean visited;

    public GridCell(int row, int col) {
        this.row = row;
        this.col = col;

        this.top = true;
        this.bottom = true;
        this.left = true;
        this.right = true;
        
        this.visited = false;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public boolean checkVisited() {
        return visited;
    }
    public void setVisited() {
        this.visited = true;
    }
    public boolean getTop(){
        return top;
    }
    public boolean getLeft(){
        return left;
    }
    public boolean getBottom(){
        return bottom;
    }
    public boolean getRight(){
        return right;
    }

    // this. refers to curr.removeWall(next) in Grid.java 
    public void removeWall(GridCell next) {
        // Same row, either left or right
        if(this.row == next.row) {
            // To the right
            if(this.col < next.col) {
                this.right = false;
                next.left = false;
            } // To the left
            else {
                this.left = false;
                next.right = false;
            }
        }
        // Same column, either above or below
        else if(this.col == next.col) {
            // Below
            if(this.row < next.row) {
                this.bottom = false;
                next.top = false;
            } // Above
            else {
                this.top = false;
                next.bottom = false;
            }
        }
    }//end of removeWall
}
