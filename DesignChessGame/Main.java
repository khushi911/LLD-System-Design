package chessgame;

public class Main {
    public static void main(){
        ChessGame chessGame = new ChessGame();
        chessGame.setPlayers("Alice", "Bob");
        chessGame.start();
    }
}
