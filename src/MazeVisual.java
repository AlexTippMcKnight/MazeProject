import javax.swing.*;
import java.awt.*;

public class MazeVisual extends JFrame {

    //Grid values
    int rows = 30;
    int columns = 30;

    public MazeVisual() {
        setTitle("The Maze");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grid maze = new Grid(rows, columns);
        maze.generateMaze();
        maze.solveMaze();
        add(new MazeCanvas(maze.grid, maze.solution));
    }//end of MazeVisual

    public static void main(String[] args) {
    	new MazeVisual().setVisible(true);
    }//end of main
}//end of class
