import java.util.Random;
import java.util.Scanner;
//1. The game is played on a grid that's 3 squares by 3 squares.



//2. You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.//

//3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.//

//4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.//
//https://www.exploratorium.edu/brain_explorer/tictactoe.html//

class TickTackToe {

    Scanner scnr = new Scanner(System.in);

    public static void initilizeBoard(char[][] gameBoard) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                gameBoard[row][col] = '-';
    }

    public static void printgameBoard(char[][] gameBoard) {
        System.out.println();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(gameBoard[row][col]);
                if (col < 2)
                    System.out.print("|");
            }
            if (row < 2)
                System.out.println("\n_____");
        }
        System.out.println();
    }

    public static void playersMove(char[][] gameBoard) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nPlease Enter a Row and Collumn 1 to 3");

        int row = scnr.nextInt();
        int col = scnr.nextInt();
        while (gameBoard[row - 1][col - 1] != '-') {
            System.out.println("\nPlease Enter a Row and Collumn 1 to 3 not taken");

            row = scnr.nextInt();
            col = scnr.nextInt();
        }
        gameBoard[row - 1][col - 1] = 'x';

    }

    public static void computerMove(char[][] gameBoard) {
        Random ran = new Random();
        System.out.println("\nComputer move");
        int row = ran.nextInt(3);
        int col = ran.nextInt(3);
        while (gameBoard[row][col] != '-') {
            row = ran.nextInt(3);
            col = ran.nextInt(3);
        }
        gameBoard[row][col] = 'O';

    }

    public static boolean determineWinnerH(char[][] gameBoard, char xOrO) {
        if (gameBoard[0][0] == xOrO && gameBoard[0][1] == xOrO && gameBoard[0][2] == xOrO
                || gameBoard[1][0] == xOrO && gameBoard[1][1] == xOrO && gameBoard[1][2] == xOrO
                || gameBoard[2][0] == xOrO && gameBoard[2][1] == xOrO && gameBoard[2][2] == xOrO)
            return true;

        return false;
    }

    public static boolean determineWinnerV(char[][] gameBoard, char xOrO) {
        if (gameBoard[0][0] == xOrO && gameBoard[1][0] == xOrO && gameBoard[2][0] == xOrO
                || gameBoard[0][0] == xOrO && gameBoard[1][0] == xOrO && gameBoard[2][0] == xOrO
                || gameBoard[0][1] == xOrO && gameBoard[1][1] == xOrO && gameBoard[2][1] == xOrO)
            return true;

        return false;
    }

    public static boolean determineWinnerD(char[][] gameBoard, char xOrO) {
        if (gameBoard[0][0] == xOrO && gameBoard[1][0] == xOrO && gameBoard[2][0] == xOrO
                || gameBoard[0][0] == xOrO && gameBoard[1][1] == xOrO && gameBoard[2][2] == xOrO
                || gameBoard[2][0] == xOrO && gameBoard[1][1] == xOrO && gameBoard[0][2] == xOrO)
            return true;

        return false;
    }

    public static boolean determineWinner(char[][] gameBoard, char xOrO) {
        if (determineWinnerH(gameBoard, xOrO) || determineWinnerV(gameBoard, xOrO) || determineWinnerD(gameBoard, xOrO))
            return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] gameBoard = new char[3][3];

        initilizeBoard(gameBoard);
        int count=0;
        while (true) {
            playersMove(gameBoard);
            printgameBoard(gameBoard);
            if(determineWinner(gameBoard, 'x')){
                System.out.println("You Win");
                break;
            }
            count++;
            if(count>8){
                System.out.println("It's a Tie");
                break;
            }
            computerMove(gameBoard);
            printgameBoard(gameBoard);
            if(determineWinner(gameBoard, 'O')){
                System.out.println("You Lose");
                break;
            }
            count++;
            if(count>8){
                System.out.println("It's a Tie");
                break;
            }
        }
    }

}
