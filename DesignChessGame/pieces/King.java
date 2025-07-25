package chessgame.pieces;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public class King extends Piece{
    public King(Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board,Cell from , Cell to){
        //KING MOVEMENT
        //King moves only one step 

        int rowDiff=Math.abs(to.getRow()-from.getRow());
        int colDiff = Math.abs(to.getCol()-from.getCol());

        return (rowDiff==1 && colDiff==0) ||
                (rowDiff==1 && colDiff==1) ||
                (rowDiff==0 && colDiff==1);
    }
    
}
