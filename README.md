Added generateMaze(), getNextCell() to Grid.java 
Added removeWall(), getRow/Col(), check/setVisited() to GridCell.java 


// GridCell.java changes ==========================
    checkVisited() checks cells visited state
    setVisited() sets cells visited state to true

    getRow/Col() gives the row and column

    removeWall() removes the wall between the 2 cells

// Grid.java changes ==============================
    getNextCell() adds unvisited surrounding cells into an array and chooses one at random

    generateMaze() uses a stack to keep track of the current path, which allows the DFS to backtrack when a deadend is reached, maze always starts at [0,0].
    it uses getNextCell() to choose the direction
    it updates each cell to visited as it passes through, until a complete maze is finished
