import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyTest {
  Board board;
  Player player1 = new Player("Hans", 30000);
  Player player2 = new Player("Grete", 30000);
    @Before
    public void setUp() throws Exception {
       // Main.readGameData();
        String [] data = Main.readFileData();
        board = new Board(data);

    }

    @Test
    public void onLand() {
        Main.currentPlayer = player1;
        int position = Main.currentPlayer.updatePosition(4);
        Field f = board.getField(position);
        f.onLand();
        f.processResponse("Y");
        assertEquals(28800,Main.currentPlayer.account.getBalance());

        Main.currentPlayer = player2;
        position = Main.currentPlayer.updatePosition(4);
        f =  board.getField(position);
        f.onLand();
        assertEquals("pay",  ((Property) f).currentOption);
        f.processResponse("Y");
        assertEquals(29950,player2.account.getBalance());
        assertEquals(28850,player1.account.getBalance());



    }
}