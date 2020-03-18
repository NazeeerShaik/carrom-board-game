public class Board {
    private Player player1;
    private Player player2;
    private Player currentStrikingPlayer;
    private int player1RemainingCoins;
    private int player2RemainingCoins;
    private final int NUMBER_OF_COINS;

    {
        NUMBER_OF_COINS = 9;
    }


    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentStrikingPlayer = player1;
        this.player1RemainingCoins = NUMBER_OF_COINS;
        this.player2RemainingCoins = NUMBER_OF_COINS;
        player1.setType(Coin.WHITE);
        player2.setType(Coin.BLACK);

    }

    public Player start() {
        while (!checkForWin(currentStrikingPlayer)) {
            int pokedCoins = currentStrikingPlayer.strike();
            calculateRemainingCoins(currentStrikingPlayer, pokedCoins);
        }
        return currentStrikingPlayer;
    }

    private void calculateRemainingCoins(Player currentStrikingPlayer, int pokedCoins) {
        if (currentStrikingPlayer == player1) player1RemainingCoins -= pokedCoins;
        else player2RemainingCoins -= pokedCoins;
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
        return (player == player1 && player1RemainingCoins <= 0) || (player == player2 && player2RemainingCoins <= 0);
    }
}