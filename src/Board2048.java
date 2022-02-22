import java.util.*;

public class Board2048 {

    // Declaring fields
    private final Random rand = new Random();
    private final int[][] board = new int[4][4];

    // Creates the initial board
    private void createBoard() {
        int initialValue1 = 2;
        int initialValue2 = 4;
        int prob1 = rand.nextInt(100);
        int prob2 = rand.nextInt(100);
        int initialRow1 = rand.nextInt(4);
        int initialCol1 = rand.nextInt(4);
        int initialRow2 = rand.nextInt(4);
        int initialCol2 = rand.nextInt(4);
        while (initialRow1 == initialRow2 && initialCol1 == initialCol2) {//make sure indexes dont overlap
            //initialRow2 = rand.nextInt(4);
            initialCol2 = rand.nextInt(4);
        }
        if (prob1 < 80) {//put 2
            board[initialRow1][initialCol1] = initialValue1;
        }
        else {//put 4
            board[initialRow1][initialCol1] = initialValue2;
        }
        if (prob2 < 80) {//put 2
            board[initialRow2][initialCol2] = initialValue1;
        }
        else {//put 4
            board[initialRow2][initialCol2] = initialValue2;
        }
    }

    // Moves all zeros to either side depending on direction inputted
    private void moveZeros(String dir) {
        int count = 0;
        switch (dir) {
            case "A":
            case "a":// traversing left -- move zeros to right
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[i][j] == 0) {
                            count++;
                        }
                    }
                    if (board[i][board.length-1] == 0) {
                        count--;
                    }
                    while (count > 0) {
                        for (int j = 0; j < board.length - 1; j++) {
                            if (board[i][j] == 0) {
                                board[i][j] = board[i][j + 1];
                                board[i][j + 1] = 0;
                                count--;
                            }
                        }
                    }
                    count = 0;
                }
                break;
            case "D":
            case "d":// traversing right -- move zeros to left
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[i][j] == 0) {
                            count++;
                        }
                    }
                    if (board[i][0] == 0) {
                        count--;
                    }
                    while (count > 0) {
                        for (int j = board.length-1; j > 0; j--) {
                            if (board[i][j] == 0) {
                                board[i][j] = board[i][j - 1];
                                board[i][j - 1] = 0;
                                count--;
                            }
                        }
                    }
                    count = 0;
                }
                break;
            case "W":
            case "w":// traversing up -- move zeros down
                for (int j = 0; j < board.length; j++) {
                    for (int i = 0; i < board.length; i++) {
                        if (board[i][j] == 0) {
                            count++;
                        }
                    }
                    if (board[board.length-1][j] == 0) {
                        count--;
                    }
                    while (count > 0) {
                        for (int i = 0; i < board.length-1; i++) {
                            if (board[i][j] == 0) {
                                board[i][j] = board[i+1][j];
                                board[i+1][j] = 0;
                                count--;
                            }
                        }
                    }
                    count = 0;
                }
                break;
            case "S":
            case "s":// traversing down -- move zeros up
                for (int j = 0; j < board.length; j++) {
                    for (int i = 0; i < board.length; i++) {
                        if (board[i][j] == 0) {
                            count++;
                        }
                    }
                    if (board[0][j] == 0) {
                        count--;
                    }
                    while (count > 0) {
                        for (int i = board.length-1; i > 0; i--) {
                            if (board[i][j] == 0) {
                                board[i][j] = board[i-1][j];
                                board[i-1][j] = 0;
                                count--;
                            }
                        }
                    }
                    count = 0;
                }
                break;
            default:
        }
    }

    // Simulating a move
    private void moveSimulator(String dir) {
        switch (dir) {
            case "A":
            case "a":// traversing left
                moveZeros(dir);
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length-1 ; j++) {
                        moveZeros(dir);
                        if (board[i][j] == board[i][j+1]) {
                            board[i][j+1] += board[i][j];
                            board[i][j] = 0;
                        }
                    }
                }
                moveZeros(dir);
                break;
            case "D":
            case "d":// traversing right
                for (int i = 0; i < board.length; i++) {
                    for (int j = board.length-1; j > 0; j-- ) {
                        moveZeros(dir);
                        if (board[i][j] == board[i][j-1]) {
                            board[i][j-1] += board[i][j];
                            board[i][j] = 0;
                        }
                    }
                }
                moveZeros(dir);
                break;
            case "W":
            case "w":// traversing up
                for (int j = 0; j < board.length; j++) {
                    for (int i = 0; i < board.length-1; i++ ) {
                        moveZeros(dir);
                        if (board[i][j] == board[i+1][j]) {
                            board[i+1][j] += board[i][j];
                            board[i][j] = 0;
                        }
                    }
                }
                moveZeros(dir);
                break;
            case "S":
            case "s":// traversing down
                for (int j = 0; j < board.length; j++) {
                    for (int i = board.length-1; i > 0; i-- ) {
                        moveZeros(dir);
                        if (board[i][j] == board[i-1][j]) {
                            board[i-1][j] += board[i][j];
                            board[i][j] = 0;
                        }
                    }
                }
                moveZeros(dir);
                break;
            default:

        }
    }

    // Checks to see if the board has an empty space
    private boolean hasEmptySpace(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // Spawns a random number if the board has an empty space
    public void spawn() {

        //doesnt spawn if no empty space
        if (!hasEmptySpace(board)) {
            return;
        }

        //spawning
        int prob = rand.nextInt(100);
        int row = rand.nextInt(4);
        int col = rand.nextInt(4);

        //prevents overlapping
        while (board[row][col] != 0 ) {
            row = rand.nextInt(4);
            col = rand.nextInt(4);
        }

        if (prob < 80) {
            board[row][col] = 2;
        }
        else {
            board[row][col] = 4;
        }
    }

    // Finds the highest number present on the board
    private int score() {
        int score = board[0][0];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (score < board[i][j]) {
                    score = board[i][j];
                }
            }
        }
        return score;
    }

    // Prints a formatted 4x4 2D integer array
    private void printBoard() {
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 0) {
                    System.out.printf("%-10s", "*");
                }
                else {
                    System.out.printf("%-10d", ints[j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Clears the screen
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Checks if left move is possible
    private boolean canMoveLeft() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j<board.length-1; j++) {
                if(board[i][j] == 0 && board[i][j+1] != 0) {
                    return true;
                }
                if(board[i][j] != 0 && board[i][j] == board[i][j+1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if right move is possible
    private boolean canMoveRight() {
        for (int i = 0; i < board.length; i++) {
            for (int j = board.length-1; j > 0; j--) {
                if(board[i][j] == 0 && board[i][j-1] != 0) {
                    return true;
                }
                if(board[i][j] != 0 && board[i][j] == board[i][j-1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if up move is possible
    private boolean canMoveUp() {
        for (int i = 0; i < board.length-1; i++) {
            for (int j=0; j < board.length; j++) {
                if(this.board[i][j] == 0 && this.board[i+1][j] != 0) {
                    return true;
                }
                if(this.board[i][j] != 0 && this.board[i][j]== this.board[i+1][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if down move is possible
    private boolean canMoveDown() {
        for(int i = board.length-1; i > 0; i--) {
            for (int j = 0; j< board.length; j++) {
                if(board[i][j] == 0 && board[i-1][j]!=0) {
                    return true;
                }
                if(board[i][j] != 0 && board[i][j]== board[i-1][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if any move is possible
    private boolean canMove() {
        if (!canMoveLeft() && !canMoveRight() && !canMoveUp() && !canMoveDown()) {
            return false;
        }
        else {
            return true;
        }
    }

    // The main game loop
    public void playGame() {
        Scanner s = new Scanner(System.in);
        boolean keepPlaying = true;
        boolean won = false;
        boolean lost = false;
        int moves = 0;
        createBoard();
        while (keepPlaying) {
            if (score() == 2048) {
                won = true;
                keepPlaying = false;
            }
            boolean invalidMove = true;
            printBoard();
            System.out.println("Your score: " + score());
            System.out.println("Your number of moves so far: " + moves);
            System.out.println("Enter your move :");
            String dir = s.next();

            if (!canMove()) {
                lost = true;
                keepPlaying = false;
            }

            System.out.println("Key pressed: " + dir);
            while (invalidMove) {
                if (dir.equals("q") || dir.equals("Q") || dir.equals("r") ||
                        dir.equals("R") || dir.equals("a") || dir.equals("A") ||
                        dir.equals("s") || dir.equals("S") || dir.equals("d") ||
                        dir.equals("D") || dir.equals("w") || dir.equals("W")) {
                    System.out.println("Valid move");
                    invalidMove = false;
                } else {
                    System.out.println("Invalid move. Please enter a valid move.");
                    System.out.print("Enter your move :");
                    dir = s.next();
                }
            }

            if (dir.equals("q") || dir.equals("Q")) {
                keepPlaying = false;
            }
            if(dir.equals("r") || dir.equals("R")){
                Game2048.newGame();
            }

            moves++;
            moveSimulator(dir);
            spawn();
            clearScreen();
        }
        if (won) {
            System.out.println("Congratulations! You won the game in " + moves + " moves.");
        }
        else if (lost) {
            System.out.println("You lost.");
        }
    }
}
