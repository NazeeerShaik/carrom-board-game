import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void shouldReturnNumberOfCoinsPoked() {
        Player player = new Player();
        RandomNumber randomNumber = mock(RandomNumber.class);
        when(randomNumber.getNumber()).thenReturn(1);

        int expected = player.strike();

        Assert.assertEquals(expected, 1);
    }
}
