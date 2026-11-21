import javax.swing.*;
import java.awt.*;

public class MazeVisual extends JFrame {

    public MazeVisual() {
        setTitle("The Maze");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grid maze = new Grid(100, 100);
        maze.generateMaze();
        add(new MazeCanvas(maze.grid));
    }
    public static void main(String[] args) {
    	new MazeVisual().setVisible(true);
    }
}
