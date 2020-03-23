import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void shouldReturnNumberOfCoinsPoked() {
        Player player = new Player();
        RandomNumber randomNumber = mock(RandomNumber.class);
        when(randomNumber.getNumber()).thenReturn(0);

        Assert.assertEquals(player.strike(),0);
    }

    @Test
    public void shouldReturnTypeOfCoins() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setType(Coin.WHITE);
        player2.setType(Coin.BLACK);

        Assert.assertEquals(player1.getType(),Coin.WHITE);
        Assert.assertEquals(player2.getType(),Coin.BLACK);
    }
}
