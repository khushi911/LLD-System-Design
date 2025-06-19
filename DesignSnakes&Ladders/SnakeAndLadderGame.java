import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SnakeAndLadderGame {
    //use private final
    Board board;
    List<Player> players;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public SnakeAndLadderGame(Board board,List<Player> players,Dice dice){
        this.board=board;
        this.dice=dice;
        this.players=players;
    }

    public void startGame(){
        while(winner==null){
            //check whose turn now
            Player currPlayer = findPlayerTurn();
            System.out.println("The current player turn is:" + currPlayer.name + " current position is: " + currPlayer.currPosition);

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int newPosition = currPlayer.currPosition+diceNumbers;

            if(newPosition <= board.getBoardSize()){
                currPlayer.setPosition(board.getNextPosition(newPosition));
                System.out.println(currPlayer.getName() + " rolled a " + diceNumbers +
                " and moved to position " + currPlayer.getPosition()); 
            }

             //check for winning condition
            if(currPlayer.getPosition() >= board.getBoardSize()){
                System.out.println(currPlayer.getName() + " wins!");
                winner = currPlayer;
            }
        }
    }

    private Player findPlayerTurn(){
        Player playerTurn = playersList.removeFirst();
        playersList.addLast(playerTurn);
        return playerTurn;
    }
}
