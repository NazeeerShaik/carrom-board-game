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
}
