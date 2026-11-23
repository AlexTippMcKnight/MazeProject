Go to MazeVisual.java in the src/ to run the program

Variables 'rows' and 'columns' are used to change the maze size

-- GridCell.java --
Stores the information of a cell for the project

-- Grid.java --
Creates a grid, and contains the DFS/BFS algorithms, along side methods needed for them to work.
DFS uses a stack to generate the maze.
BFS uses a queue to solve the maze and a arraylist to store the solution

-- MazeVisual.java --
The main method, uses the methods from Grid.java and passes the results to MazeCanvas.java.
Runs the program

-- MazeCanvas.java --
Draws the maze walls, colours the start green, the end red, and the blue solution line.

Each cell has a row and column, [0,0] is the start and [rows, columns] is the end. (variables from MazeVisual.java)

-- Stack and Queue --
Taken from the labs and located in src/lib for project clarity