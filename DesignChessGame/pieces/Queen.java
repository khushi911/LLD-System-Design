package chessgame.pieces;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public class Queen extends Piece{
    public Queen(Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board,Cell from , Cell to){
        //QUEEN MOVEMENT
        //1. moves  straight forward/backward - like a rook
        //2. moves diagonally forward/backward - like a bishop

        int rowDiff=Math.abs(to.getRow()-from.getRow());
        int colDiff = Math.abs(to.getCol()-from.getCol());

        return (rowDiff>0 && colDiff==0) ||
                (colDiff>0 && rowDiff==0) ||
                (rowDiff==colDiff && rowDiff>0 && colDiff>0);
    }
    
}
