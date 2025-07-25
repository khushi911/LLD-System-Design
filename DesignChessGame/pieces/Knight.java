package chessgame.pieces;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public class Knight extends Piece{
    public Knight(Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board,Cell from , Cell to){
        //KNIGHT MOVEMENT
        // Knight moves in L shaped manner

        int rowDiff = Math.abs(to.getRow()-from.getRow());
        int colDiff = Math.abs(to.getCol()-from.getCol());

        return (rowDiff==2 && colDiff==1) ||
                (colDiff==2 && rowDiff==1);
    }
}
