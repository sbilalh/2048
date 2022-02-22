public class Game2048 {

    // Creates a new game
    public static void newGame(){
        Board2048 puzzle = new Board2048();
        System.out.println("Welcome to 2048!");
        System.out.println("Controls: a = left, d = right, w = up, s = down, q = quit, r = restart");
        System.out.println();
        puzzle.playGame();
    }

    // Main method calls newGame()
    public static void main(String[] args) {
        newGame();
    }

}
