public class Player {
    private Coin type;
    private final RandomNumber randomNumber = new RandomNumber();

    public int strike() {
        return randomNumber.getNumber();
    }

    public void setType(Coin type) {
        this.type = type;
    }

    public Coin getType() {
        return type;
    }
}
