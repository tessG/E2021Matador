import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
   static ArrayList<Player> players = new ArrayList();
   static int MAX = 6;
   private static Board board;
   private static UI ui= new UI();
   public static Player currentPlayer;
    private static int turnCounter = 0;

    public static void main(String [] arg){
        //todo: Single responsibility: placer fil io i egen klasse
        //todo: sørg for at der kan læses fra fil eller database, uden negative konsekvenser når man skifter i mellem de to kilder

       try {
            readGameData();
        }catch(FileNotFoundException e){
            ui.createAccounts();
        }catch (NoSuchElementException e){
            System.out.println("file is empty");
            ui.createAccounts();
        }

        printAccounts();
        DBConnector db = new DBConnector();
        String [] data = db.readFieldData();

        //todo: skriv kode der gør at man let kan skifte mellem den ene og den anden persistens-metode
        // String [] data = fileReader.readFieldData();

        //sender data til Board klassen, så den kan lave alle de forskellige felt instanser
        board = new Board(data);
        runLoop();

        // Vi gemmer ikke data ligenu, da saveGameData metoden ikke er refaktoreret til at gemme spillernes position og isNext værdi.
        // Koden vil derfor fejle hvis vi får overskrevet data.txt
        //  saveGameData();
    }

    private static void runLoop(){
        String input = "";

        while(!input.equalsIgnoreCase("N")) {
            if(turnCounter == Main.players.size()) {
                turnCounter = 0;
            }
            currentPlayer = players.get(turnCounter);
            System.out.println("Det er "+currentPlayer.getName()+"'s tur");
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

    public static String[] readFieldData() {
        String[] data = new String[40];
        File file = new File("src/fields.txt");
        String s;
        int i = 0;
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//ignorerer headeren

            while(scan.hasNextLine()){
                 s = scan.nextLine();
                 data[i] = s;
                 i++;
            }

        }catch(FileNotFoundException e){
            System.out.println(e.getCause());
        }
        return data;
    }

    /**
     *
     * Denne metode gemmer sessionens tilstand,
     * instantier en gamedata tekst-streng (String)
     * loop igennem accounts, og for hver linie tilføj data i formen "ejer:balance" til strengen
     * instantier FileWriter og kald dens write med den opbyggede streng som argument
     *
     */

    private static void saveGameData() {
        String gamedata = "";
        gamedata="name, balance, position, isNext \n";
        for (Player a : players) {
            gamedata += a;
        }

        try {
            FileWriter writer = new FileWriter("src/data.txt");
            writer.write(gamedata);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void printAccounts() {
        for(Player a: players){
            System.out.println(a);
        }
    }

    /**
     * Indlæser gamedata og danner spillerinstanser på baggrund af data
     * objekterne gemmes herefter i denne klasses ArrayList<Players>
     *
     *   'throws FileNotFoundException' i metodesignaturen fordi vi hellere vil fange indlæsningsfejl oppe i main
     *   - i de tilfælde kan vi i stedet igangsætte en dialog til manuel indtastning af spiller data
     */
    //todo: refactor sådan at metoden returnerer en arrayListe af spillere: ArrayList<Player>
    // kald til metoden: players = io.readGameData()
    public static void readGameData() throws FileNotFoundException, NoSuchElementException {
        File file = new File("src/data.txt");
        Scanner scan = null;
        scan = new Scanner(file);
        scan.nextLine();
        while(scan.hasNextLine()){
            String [] values = scan.nextLine().split(",");
            int balance = Integer.parseInt(values[1]);
            int position = Integer.parseInt(values[2]);
            boolean isNext = Boolean.getBoolean(values[3]);
            Player p = new Player(values[0], balance, position, isNext);
            players.add(p);
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
