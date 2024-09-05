package TicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name player 1: ");
        String namePlayer1 = scanner.nextLine();
        System.out.println("Name player 2: ");
        String namePlayer2 = scanner.nextLine();
        Player player1 = new Player(namePlayer1, Type.X);
        Player player2 = new Player(namePlayer2, Type.O);
        GameController gameController = new GameController(player1, player2, 4);
        int row;
        int column;
        System.out.println(gameController.getBoard().displayBoard());
        while (!gameController.getIsWinner()){
            System.out.println("Current turn: " + gameController.getPlayers()[gameController.getCurrentTurn()].getName());
            do {
                System.out.print("Enter coordinate row: ");
                row = scanner.nextInt();
                System.out.print("Enter coordinate column: ");
                column = scanner.nextInt();
                if (!gameController.isValidPosition(row, column) || gameController.getBoard().getBoard()[row][column] != Type.EMPTY){
                    System.out.println("Invalid position!");
                }
            } while (!gameController.isValidPosition(row, column) || gameController.getBoard().getBoard()[row][column] != Type.EMPTY);

            gameController.setPiece(row, column);
            System.out.print(gameController.getBoard().displayBoard());
        }
        System.out.println(gameController.displayWinner(gameController.getWinner()));


    }
}
