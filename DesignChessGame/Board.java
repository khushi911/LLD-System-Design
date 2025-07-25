package chessgame;

import chessgame.pieces.Bishop;
import chessgame.pieces.King;
import chessgame.pieces.Knight;
import chessgame.pieces.Pawn;
import chessgame.pieces.Piece;
import chessgame.pieces.Queen;
import chessgame.pieces.Rook;
import chessgame.Move;

public class Board {
    private final Cell[][] board;

    public Board(){
        //initialising board
        board = new Cell[8][8];

        for(int row =0;row<8;row++){
            for(int col=0;col<8;col++){
                board[row][col] = new Cell(row,col);
            }
        }

        setupPieces();
    }

    public void setupPieces(){
        //setting up pawns on both sides
        for(int j=0;j<8;j++){
            board[1][j].setPiece(new Pawn(Color.WHITE));
            board[6][j].setPiece(new Pawn(Color.BLACK));
        }

        //setting up other pieces for WHITE
        board[0][0].setPiece(new Rook(Color.WHITE));
        board[0][1].setPiece(new Knight(Color.WHITE));
        board[0][2].setPiece(new Bishop(Color.WHITE));
        board[0][3].setPiece(new Queen(Color.WHITE));
        board[0][4].setPiece(new King(Color.WHITE));
        board[0][5].setPiece(new Bishop(Color.WHITE));
        board[0][6].setPiece(new Knight(Color.WHITE));
        board[0][7].setPiece(new Rook(Color.WHITE));

        //setting up other pieces for BLACK
        board[7][0].setPiece(new Rook(Color.BLACK));
        board[7][1].setPiece(new Knight(Color.BLACK));
        board[7][2].setPiece(new Bishop(Color.BLACK));
        board[7][3].setPiece(new Queen(Color.BLACK));
        board[7][4].setPiece(new King(Color.BLACK));
        board[7][5].setPiece(new Bishop(Color.BLACK));
        board[7][6].setPiece(new Knight(Color.BLACK));
        board[7][7].setPiece(new Rook(Color.BLACK));

    }

    public synchronized boolean movePiece(Move move){
        Cell from = move.getStart();
        Cell to = move.getEnd();
        Piece piece = from.getPiece();

        if(piece==null || !piece.canMove(this,from,to)){
            return false;
        }
        
        to.setPiece(piece);
        from.setPiece(null);
        return true;
    }


    public Cell getCell(int row,int col){
        return board[row][col];
    }

    public Piece getPiece(int row,int col){
        return board[row][col].getPiece();
    }

    public void setPiece(int row,int col,Piece piece){
        board[row][col].setPiece(piece);
    }

    public boolean isCheckMate(Color color){
        // TODO: Implement checkmate logic
        return false;
    }

    public boolean isStalemate(Color color) {
        // TODO: Implement stalemate logic
        return false;
    }

}
