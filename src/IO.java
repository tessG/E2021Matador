import java.util.ArrayList;

public interface IO {
    String[] readFieldData();
    void saveGameData(ArrayList<Player> players);
    ArrayList<Player> readGameData();
}
