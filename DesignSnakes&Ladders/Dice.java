import java.util.Random;

public class Dice {
    private final int diceCount;
    private final int minValue;
    private final int maxValue;

    public Dice(int diceCount, int minValue, int maxValue) {
        this.diceCount = diceCount;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int rollDice() {
        // to include for more than 1 dice

        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount) {
            Random random = new Random();
            int diceScore = random.nextInt(6) + 1; // (0-5) + 1 → (1-6)

            totalSum += diceScore;
            diceUsed++;
        }

        return totalSum;
    }
}
