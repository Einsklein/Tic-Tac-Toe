package TicTacToe;


public class Board {
    private int rows = 7;
    private int columns = 7;
    private Type[][] board;

    public Type[][] getBoard() {
        return board;
    }

    public Board() {
        board = new Type[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = Type.EMPTY;
            }
        }
    }

    public Boolean updateBoard(int row, int column, Type type) {
        if (board[row][column] == Type.EMPTY) {
            board[row][column] = type;
            return true;
        }
        return false;

    }


    String concatenateDash(){
        String dash = "";
        for (int iDash = 0; iDash < rows; iDash++) {
            dash += " ---";
        }
        dash += "\n";
        return dash;
    }


    String displayBoard() {
        int iRow = 0;
        String message = "";
        for (int i = 0; i < rows; i++) {
            message += "  " + i + " ";
        }
        message += "\n";

        for (int j = 0; j < rows; j++) {
            message += dislayARow(board[j], iRow);
            iRow++;
        }
        message += concatenateDash();
        return message;
    }

    String dislayARow(Type[] row, int iRow) {
        String message = concatenateDash() + "|";



        for (int i = 0; i < rows; i++) {
            switch (row[i]) {
                case EMPTY:
                    message += "   |";
                    break;
                case X:
                    message += " X |";
                    break;
                case O:
                    message += " O |";
                    break;
            }
        }
        message += " " + iRow + "\n";
        return message;
    }

    void resetBoard() {
        for (int iRow = 0; iRow < rows; iRow++) {
            for (int iColumn = 0; iColumn < columns; iColumn++) {
                board[iRow][iColumn] = Type.EMPTY;
            }
        }
    }


}
