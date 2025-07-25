package chessgame.pieces;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public class Pawn extends Piece{
    public Pawn(Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board,Cell from , Cell to){
        //PAWN MOVEMENT
        // 1. pawn moves 1 step forward
        // 2. first move of pawn can be 2 steps
        // 3. pawn moves 1 step diagonally to kill 

        int rowDiff = to.getRow() - from.getRow();
        int colDiff = Math.abs(to.getCol()-from.getCol());

        //WHITE is at 0,1 rows
        //BLACK is at 6,7 rows

        if(color==Color.WHITE){
            //WHITE 
            return (rowDiff == 1 && colDiff == 0) ||
                (from.getRow()== 1 && rowDiff ==2 && colDiff ==0) ||
                (rowDiff==1 && colDiff==1 && board.getPiece(to.getRow(), to.getCol()).getColor()== Color.BLACK);
        }
        else{
            //BLACK
            return (rowDiff == -1 && colDiff == 0) ||
                (from.getRow()== 6 && rowDiff == -2 && colDiff ==0) ||
                (rowDiff==-1 && colDiff==1 && board.getPiece(to.getRow(), to.getCol()).getColor()== Color.WHITE);
        }
    }
}
