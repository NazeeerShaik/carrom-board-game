public class Game {
    private Board board;

    Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.start();
    }
}
