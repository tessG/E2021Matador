import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxTest {
    Board board;
    Player player1 = new Player("Hans", 30000);
    Player player2 = new Player("Grete", 30000);
    @Before
    public void setUp() throws Exception {
        // Main.readGameData();
        String [] data = Main.readFieldData();
        board = new Board(data);

    }
    @Test
    public void onLand() {
        Main.currentPlayer = player1;
        int position = Main.currentPlayer.updatePosition(5);
        Field f = board.getField(position);
        f.onLand();
        System.out.println(f.label);
        f.processResponse("N");
        assertEquals(27000,Main.currentPlayer.account.getBalance());

    }
}