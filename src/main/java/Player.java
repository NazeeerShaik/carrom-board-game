public class Player {
    private int score;
    private final int NUMBER_OF_COINS;
    private String name;
    private Coin type;

    public void setType(Coin type) {
        this.type = type;
    }

    Player(String name) {
        this.name = name;
        this.NUMBER_OF_COINS = 9;
    }

    public void strike() {
        this.score += getNumberOfPokedCoins();
    }

    int getNumberOfPokedCoins() {
        return (int) (Math.random() * 3);
    }

    public boolean isWin() {
        return this.score >= NUMBER_OF_COINS;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
