import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BoardTest {
    @Test
    public void shouldReturnTypeOfCoinsPlayerIsPlaying() {
        Player player1 = new Player();
        Player player2 = new Player();
        Board board = new Board(player1, player2);

        Assert.assertEquals(player1.getType(), Coin.WHITE);
        Assert.assertEquals(player2.getType(), Coin.BLACK);
    }

    @Test
    public void shouldReturnTrueIfStrikingPlayerUnableToPockCoins() {
        Player player1 = new Player();
        Player player2 = new Player();
        Board board = new Board(player1, player2);

        boolean expected = board.checkForStrikeChange(0);

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnFalseIfStrikingPlayerAbleToPockCoins() {
        Player player1 = new Player();
        Player player2 = new Player();
        Board board = new Board(player1, player2);

        boolean expected = board.checkForStrikeChange(2);

        Assert.assertFalse(expected);
    }

    @Test
    public void shouldChangeStrikingPlayer() {
        Player player1 = new Player();
        Player player2 = new Player();
        Board board = new Board(player1, player2);

        board.changeStrike();

        Assert.assertEquals(board.getCurrentStrikingPlayer(), player2);
    }

    @Test
    public void shouldChangeStrikingPlayerV2() {
        Player player1 = new Player();
        Player player2 = new Player();
        Board board = new Board(player1, player2);

        board.changeStrike();
        board.changeStrike();

        Assert.assertEquals(board.getCurrentStrikingPlayer(), player1);
    }

    @Test
    public void shouldReturnTruePlayerWins() {
        Player player1 = new Player();
        Player player2 = new Player();
        Board board = new Board(player1, player2);

        boolean expected = board.checkForWin(player1);

        Assert.assertFalse(expected);
    }

}
