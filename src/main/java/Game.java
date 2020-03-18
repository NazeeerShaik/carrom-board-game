public class Game {
    private Player player1;
    private Player player2;
    Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = this.player1;
        player1.setType(Coin.WHITE);
        player2.setType(Coin.BLACK);
    }

    public void play() {
        while (!currentPlayer.isWin()) {
            changePlayerBasedOn(pokedCoins());
        }
    }

    public void changePlayerBasedOn(int pokedCoins) {
        if (pokedCoins == 0) {
            if (currentPlayer == player1) currentPlayer = player2;
            else currentPlayer = player1;
        }
    }

    public int pokedCoins() {
        int previous = currentPlayer.getScore();
        currentPlayer.strike();
        return currentPlayer.getScore() - previous;
    }
}
