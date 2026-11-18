public class GridCell {
    private boolean top;
    private boolean bottom;
    private boolean left;
    private boolean right;

    private boolean visited;

    public GridCell() {
        this.top = true;
        this.bottom = true;
        this.left = true;
        this.right = true;
        
        this.visited = false;
    }
}
