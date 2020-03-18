import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    @Test
    public void shouldChangeThePlayerIfPokedCoinsAreZero() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        Game game = new Game(player1, player2);

        game.changePlayerBasedOn(0);

        System.out.println(player1);
        System.out.println(player2);
        Assert.assertEquals(game.currentPlayer, player2);
    }

}