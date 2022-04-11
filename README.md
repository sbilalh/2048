# 2048
The classic 2048 game designed to play on the terminal.

Overview of features:
The src file contains two classes - Game2048 and Board2048.

Game2048:
1) newGame() -- creates a game object, prints welcome message and control instructions, and calls the main game loop (playGame()).
2) main(String[] args) -- calls newGame().

Board2048:
1) createBoard() -- creates the initial game board, filled with zeros alongside two numbers (either a 2 with 80% probability or a 4 with 20% probability) put in random positions.
2) moveZeros() -- moves all zeros in a row (for left & right moves) or in a column (for up & down moves) according to the respective direction inputted.
3) moveSimulator() -- computes the running sum in specified direction, given that the adjacent elements are equal to each other. Calls moveZeros() to format the board accordingly.
4) hasEmptySpace() -- Checks to see if the board has an empty space.
5) spawn() -- Spawns a random number if the board has an empty space.
6) score() -- Finds the highest number present on the board.
7) printBoard() -- Prints the game board.
8) clearScreen() -- Clears the previous board so that the player is presented with just one board at a time.
9) canMoveLeft(), canMoveRight(), canMoveUp(), canMoveDown() -- Checks if movement in left, right, up or down directions respectively is possible.
10) canMove() -- Returns false if no move is possible in any direction.
11) playGame() -- It is the main game loop. Runs the entire game inside a while loop. Takes input from the player. Checks to see if game has been won or lost. Checks to see if input entered is valid or not. Keeps track of score and number of moves. Calls all of the above methods present in Board2048. 
