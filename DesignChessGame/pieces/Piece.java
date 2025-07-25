package chessgame.pieces;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;
//abstract class -> for closely related classes
public abstract class Piece{
    protected final Color color;

    public Piece(Color color){
        this.color = color;
    }

    public abstract boolean canMove(Board board,Cell from, Cell to);
    public Color getColor(){
        return color;
    }

}
