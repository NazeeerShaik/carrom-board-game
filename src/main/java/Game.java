public class Game {
    private Board board;

    Game(Player player1,Player player2) {
        this.board = new Board(player1,player2);
    }

    public void start() {
        board.start();
    }
}
