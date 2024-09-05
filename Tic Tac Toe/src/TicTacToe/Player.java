package TicTacToe;

public class Player {
    private String name;
    private Type pieceType;

    public Player(String name, Type pieceType) {
        setName(name);
        setPieceType(pieceType);
    }

    public Type getPieceType(){
        return pieceType;
    }

    public String getName() {return name;}

    public void setPieceType(Type pieceType){
        this.pieceType = pieceType;
    }
    public void setName(String name){
        this.name = name;
    }
}
