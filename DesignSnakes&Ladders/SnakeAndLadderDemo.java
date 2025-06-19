import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public static void run() {
        // Start game 1
        List<Snake> snakes = Arrays.asList(
                new Snake(17, 7), new Snake(54, 34),
                new Snake(62, 19), new Snake(98, 79));

        List<Ladder> ladders = Arrays.asList(
                new Ladder(3, 38), new Ladder(24, 33),
                new Ladder(42, 93), new Ladder(72, 84));

        Board board = new Board(100, snakes, ladders);

        List<Player> players = Arrays.asList(new Player("Player 1"),
        new Player("Player 2"),new Player("Player 3"));

        SnakeAndLadderGame game = new SnakeAndLadderGame(board, players, new Dice(1,1, 6));

        game.startGame();
    }
}
