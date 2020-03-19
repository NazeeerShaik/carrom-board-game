import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private Player player1;
    private Player player2;
    private Player currentStrikingPlayer;
    private List<Coin> player1Coins;
    private List<Coin> player2Coins;
    private final int NUMBER_OF_COINS;
    private StringBuilder result = new StringBuilder();

    {
        NUMBER_OF_COINS = 9;
    }


    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        init(player1, player2);
    }

    private void init(Player player1, Player player2) {
        this.currentStrikingPlayer = player1;
        this.player1Coins = new ArrayList<>(Collections.nCopies(NUMBER_OF_COINS, Coin.WHITE));
        this.player2Coins = new ArrayList<>(Collections.nCopies(NUMBER_OF_COINS, Coin.BLACK));
        player1.setType(Coin.WHITE);
        player2.setType(Coin.BLACK);
    }

    public void start() {
        while (!checkForWin(currentStrikingPlayer)) {
            int pokedCoins = currentStrikingPlayer.strike();
            generateResult(currentStrikingPlayer, pokedCoins);
            calculateRemainingCoins(currentStrikingPlayer, pokedCoins);
            if (checkForStrikeChange(pokedCoins)) changeStrike();
        }
        displayResult(currentStrikingPlayer);
    }

    private void displayResult(Player currentStrikingPlayer) {
        result.append(currentStrikingPlayer).append("Wins !");
        System.out.println(result.toString());
    }

    private void generateResult(Player currentStrikingPlayer, int pokedCoins) {
        if (currentStrikingPlayer == player1) result.append("PLAYER #1 poked ").append(pokedCoins).append(" coins\n");
        else result.append("PLAYER #2 poked ").append(pokedCoins).append(" coins\n");
    }

    private void calculateRemainingCoins(Player currentStrikingPlayer, int pokedCoins) {
        if (currentStrikingPlayer == player1) {
            while (pokedCoins != 0 && !player1Coins.isEmpty()) {
                player1Coins.remove(Coin.WHITE);
                pokedCoins--;
            }
        } else {
            while (pokedCoins != 0 && !player2Coins.isEmpty()) {
                player2Coins.remove(Coin.BLACK);
                pokedCoins--;
            }
        }
    }


    public boolean checkForStrikeChange(int value) {
        return value == 0;
    }

    public void changeStrike() {
        if (currentStrikingPlayer == player1) currentStrikingPlayer = player2;
        else currentStrikingPlayer = player1;
    }

    public Player getCurrentStrikingPlayer() {
        return currentStrikingPlayer;
    }

    public boolean checkForWin(Player player) {
        return (player == player1 && player1Coins.isEmpty()) || (player == player2 && player2Coins.isEmpty());
    }
}