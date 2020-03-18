import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void shouldReturnNumberOfPokedCoinsIfStrikeIsSuccess() {
        Player player = mock(Player.class);

        when(player.getNumberOfPokedCoins()).thenReturn(0);

        Assert.assertEquals(player.getNumberOfPokedCoins(), 0);
    }

    @Test
    public void shouldReturnNumberOfPokedCoinsIfStrikeIsSuccessV2() {
        Player player = mock(Player.class);

        when(player.getNumberOfPokedCoins()).thenReturn(2);

        Assert.assertEquals(player.getNumberOfPokedCoins(), 2);
    }

    @Test
    public void shouldReturnFalseIfPlayerLooseTheGame() {
        Player player = mock(Player.class);
        when(player.getNumberOfPokedCoins()).thenReturn(0);

        player.strike();

        Assert.assertFalse(player.isWin());
    }
}
