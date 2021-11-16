import java.util.ArrayList;

public class Main {
   static ArrayList<Player> players = new ArrayList();
   static int MAX = 6;
    private static Board board;
    public static UI ui= new UI();
    public static Player currentPlayer;
    private static int turnCounter = 0;
    enum Datasource{
        DATABASE,
        CSVFILE
    }
    private static Datasource datapath = Datasource.CSVFILE;

    public static void main(String [] arg){
        //todo: Single responsibility: placer kode til fil-læsning og -skrivning i egen klasse
        //todo: sørg for at der kan læses fra fil eller database, uden negative konsekvenser når man skifter i mellem de to kilder
        IO io;

        if(datapath==Datasource.CSVFILE) {
            io = new FileReader();
        }else {
            io = new DBConnector();
        }

        //FileReader fr = new FileReader();
        players = io.readGameData();
        printAccounts();
        String [] data;
        //DBConnector db = new DBConnector();
        data = io.readFieldData();
        //todo: skriv kode der gør at man let kan skifte mellem den ene og den anden persistens-metode
         board = new Board(data);
        runLoop();
        io.saveGameData(players);

    }

    private static void runLoop(){
        String input = "";

        while(!input.equalsIgnoreCase("N")) {
            if(turnCounter == Main.players.size()) {
                turnCounter = 0;
            }
            currentPlayer = players.get(turnCounter);
          //  System.out.println("Det er "+currentPlayer.getName()+"'s tur");
            takeTurn();
            input = ui.getUserInput("Er alle klar til næste runde? Y/N: ");
            turnCounter++;
        }
    }

    private static void takeTurn() {
        //slå med terninger (DICE)
        int diceValue = board.dice.throwDice();

        // opdater spillers position (PLAYER)
        int position = currentPlayer.updatePosition(diceValue);
        System.out.println(currentPlayer.getName() + "'s nye position er " + position+"\n");

        // Få fat i det felt spilleren er landet på (BOARD)
        Field f = board.getField(position);

        // hent besked hos det aktuelle felt
        String message = f.onLand(); //polymorfisk kald

        // startDialog(UI) med den besked felt har returneret returnerer det brugeren svarer
        String response = ui.startDialog(message);

        message = f.processResponse(response);
        System.out.println(message + currentPlayer.getName() + "'s saldo: " + currentPlayer.account.getBalance());


    }

    private static void printAccounts() {
        for(Player a: players){
            System.out.println(a);
        }
    }

    /**
     * Denne metode skal ikke bruges lige nu.
     * Den ender nok inde i UI der har med al brugerinteraktion at gøre
     */
    private static void showMenu() {
        System.out.println("Press Q to quit");
        System.out.println("Press C to create Bank Accounts");
        System.out.println("Press T to do transaction");
    }

    public static void setTurnCounter(int playerid) {
        turnCounter = playerid;
    }
}
