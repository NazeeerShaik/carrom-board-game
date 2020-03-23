import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {
    @Test
    public void shouldReturnWinner() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        Game game = new Game(player1,player2);
        when(player1.strike()).thenReturn(0);
        when(player2.strike()).thenReturn(2, 2, 2, 2, 2);
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        game.start();

        verify(out).println("PLAYER #1 poked 0 coins\n" +
                "PLAYER #2 poked 2 coins\n" +
                "PLAYER #2 poked 2 coins\n" +
                "PLAYER #2 poked 2 coins\n" +
                "PLAYER #2 poked 2 coins\n" +
                "PLAYER #2 poked 2 coins\n" +
                player2 + "Wins !");
    }

    @Test
    public void shouldReturnWinnerV2() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        Game game = new Game(player1,player2);
        when(player1.strike()).thenReturn(2, 2, 0, 2, 2, 1);
        when(player2.strike()).thenReturn(0);
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        game.start();

        verify(out).println("PLAYER #1 poked 2 coins\n" +
                "PLAYER #1 poked 2 coins\n" +
                "PLAYER #1 poked 0 coins\n" +
                "PLAYER #2 poked 0 coins\n" +
                "PLAYER #1 poked 2 coins\n" +
                "PLAYER #1 poked 2 coins\n" +
                "PLAYER #1 poked 1 coins\n" +
                player1 + "Wins !");
    }

}