package chessgame.pieces;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public class Rook extends Piece{

    public Rook(Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board,Cell from , Cell to){
        //ROOK MOVEMENT
        //1. Rook can move straight ahead in a row
        //2. Rook can move straight ahead in a column
        
        int rowDiff=Math.abs(to.getRow()-from.getRow());
        int colDiff = Math.abs(to.getCol()-from.getCol());

        return (rowDiff>0 && colDiff==0) ||
                (colDiff>0 && rowDiff==0);
    }

}
