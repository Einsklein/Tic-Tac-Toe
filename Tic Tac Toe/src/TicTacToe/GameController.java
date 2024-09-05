package TicTacToe;

import java.util.Random;


public class GameController {
    private Player[] players;
    private int remainingTurnTime = 60;
    private int currentTurn;
    private Board board;
    private int requiredWinningSameType;
    final Random rand = new Random();
    private boolean isWinner = false;
    private String winner;


    public GameController(Player player1, Player player2, int requiredWinningSameType) {
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        board = new Board();
        currentTurn = rand.nextInt(2);
        this.requiredWinningSameType = requiredWinningSameType;
    }

    void setPiece(int posRow, int posColumn) {
        if (isValidPosition(posRow, posColumn) && board.getBoard()[posRow][posColumn] == Type.EMPTY) {
            board.updateBoard(posRow, posColumn, players[currentTurn].getPieceType());
            if (win(posRow, posColumn, players[currentTurn].getPieceType())){
                isWinner = true;
                winner = players[currentTurn].getName();
            }
            switchTurn();
        }

    }

    public String displayWinner(String name){
        return name + " has won!";
    }

    public void switchTurn() {
        currentTurn = (currentTurn + 1) % 2;
    }

    public Board getBoard() {
        return board;
    }

    public boolean getIsWinner() {return isWinner;}
    public String getWinner() {return winner;}

    public Player[] getPlayers() {
        return players;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public boolean win(int posRow, int posColumn, Type type) {
        int sameType = 1;
        int iPossibilities = 0;
        int iDirection = 0;
        int directionRow = -1;
        int directionColumn = -1;
        boolean isWinner = false;
        while (iPossibilities < 8 && !isWinner) {
            switch (iDirection) {
                case 0:
                    directionRow = -1;
                    directionColumn = -1;
                    break;
                case 1:
                    directionRow = -1;
                    directionColumn = 0;
                    break;
                case 2:
                    directionRow = -1;
                    directionColumn = 1;
                    break;
                case 3:
                    directionRow = 0;
                    directionColumn = 1;
                    break;
                case 4:
                    directionRow = 1;
                    directionColumn = 1;
                    break;
                case 5:
                    directionRow = 1;
                    directionColumn = 0;
                    break;
                case 6:
                    directionRow = 1;
                    directionColumn = -1;
                    break;
                case 7:
                    directionRow = 0;
                    directionColumn = -1;
                    break;

            }
            int nextRow = posRow + directionRow;
            int nextColumn = posColumn + directionColumn;
            sameType = 1;
            while (sameType < requiredWinningSameType && isValidPosition(nextRow, nextColumn) && board.getBoard()[posRow][posColumn] == board.getBoard()[nextRow][nextColumn]) {
                nextRow += directionRow;
                nextColumn += directionColumn;
                sameType++;
            }
            iDirection++;
            isWinner = sameType == requiredWinningSameType;
            iPossibilities++;

        }

        return isWinner;
    }


    public boolean isValidPosition(int posRow, int posColumn) {
        return posRow >= 0 && posRow < board.getBoard().length && posColumn >= 0 && posColumn < board.getBoard()[0].length;
    }


}
